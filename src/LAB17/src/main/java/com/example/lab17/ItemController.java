package com.example.lab17;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/home")
public class ItemController {

    private static List<Item> items = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();
    private Item findItem = new Item("null", "null", "null");
    private static List<Order> findOrders = new ArrayList<>();
    private Boolean flag = true;

    static {
        findOrders.add(new Order("null", "null"));
    }

    @Autowired
    private Service service;

    @Value("${home.name}")
    private String name;

    @Value("${home.group}")
    private String group;

    @Value("${home.var}")
    private String var;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("name", name);
        model.addAttribute("group", group);
        model.addAttribute("var", var);

        return "home";
    }

    @GetMapping("/itemsList")
    public String itemList(Model model) {
        if (flag) {
            orders = service.getAllOrders();
            items = service.getAllItems();
        }
        flag = true;
        Item item = new Item();
        Order order = new Order();
        model.addAttribute("order", order);
        model.addAttribute("item", item);
        model.addAttribute("items", items);
        model.addAttribute("orders", orders);
        model.addAttribute("findItem", findItem);
        model.addAttribute("findOrders", findOrders);

        return "itemsList";
    }

    @GetMapping("/addItem")
    public String addedItem(Model model) {
        Item newItem = new Item();
        model.addAttribute("newItem", newItem);

        return "addItem";
    }

    @PostMapping("/addItem")
    public String addItem(@ModelAttribute("newItem") Item newItem) {
        service.addItem(newItem);

        return "redirect:itemsList";
    }

    @GetMapping("/addOrder")
    public String addedOrder(Model model) {
        Order newOrder = new Order();
        model.addAttribute("newOrder", newOrder);

        return "addOrder";
    }

    @PostMapping("/addOrder")
    public String addOrder(@ModelAttribute("newOrder") Order newOrder) {
        service.addOrder(newOrder);

        return "redirect:itemsList";
    }

    @PostMapping("/delItem")
    public String delItem(@ModelAttribute("item") Item item) {
        for (Item i: items) {
            if (item.getName().equals(i.getName())) {
                service.delItem(i);
            }
        }
        return "redirect:itemsList";
    }

    @PostMapping("/delOrd")
    public String delOrd(@ModelAttribute("order") Order order) {
        for (Order i: orders) {
            if (order.getNumber().equals(i.getNumber())) {
                service.delOrder(i);
            }
        }
        return "redirect:itemsList";
    }

    @PostMapping("/findItem")
    public String findItem(@ModelAttribute("order") Order order) {
        findItem = service.getItemByOrder(order.getItem_id());

        return "redirect:itemsList";
    }

    @PostMapping("/findOrders")
    public String findItem(@ModelAttribute("item") Item item) {
        findOrders = service.getOrdersByItem(item.getId());

        return "redirect:itemsList";
    }

    @GetMapping("/getOBN")
    public String getOBN() {
        flag = false;
        orders = service.getOrdersBy("number");

        return "redirect:itemsList";
    }

    @GetMapping("/getOBD")
    public String getOBD() {
        flag = false;
        orders = service.getOrdersBy("orderDate");

        return "redirect:itemsList";
    }

    @GetMapping("/getIBN")
    public String getIBN() {
        flag = false;
        items = service.getItemsBy("name");

        return "redirect:itemsList";
    }

    @GetMapping("/getIBD")
    public String getIBD() {
        flag = false;
        items = service.getItemsBy("creationDate");

        return "redirect:itemsList";
    }

    @GetMapping("/getIBP")
    public String getIBP() {
        flag = false;
        items = service.getItemsBy("price");

        return "redirect:itemsList";
    }
}
