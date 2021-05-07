package com.example.lab14;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/home")
public class ItemController {

    private static final List<Item> items = new ArrayList<Item>();
    private static final List<Order> orders = new ArrayList<Order>();

    static {
        items.add(new Item("Example Item", "17.04.2021", "270rub"));
        orders.add(new Order("12344", "17.04.2021"));
    }

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
        Item item = new Item();
        Order order = new Order();
        model.addAttribute("order", order);
        model.addAttribute("item", item);
        model.addAttribute("items", items);
        model.addAttribute("orders", orders);

        return "itemsList";
    }

    @GetMapping("/addItem")
    public String addedItem(Model model) {
        Item newItem = new Item();
        model.addAttribute("newItem", newItem);

        return "addItem";
    }

    @PostMapping("/addItem")
    public String addItem(Model model, @ModelAttribute("newItem") Item newItem) {
        Item nItem = new Item(newItem.getName(), newItem.getCreationDate(), newItem.getPrice());
        items.add(nItem);

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
        Order nOrder = new Order(newOrder.getNumber(), newOrder.getOrderDate());
        orders.add(nOrder);

        return "redirect:itemsList";
    }

    @PostMapping("/delItem")
    public String delItem(Model model, @ModelAttribute("item") Item item) {
        items.removeIf(i -> i.getName().equals(item.getName()));
        return "redirect:itemsList";
    }

    @PostMapping("/delOrd")
    public String delOrd(Model model, @ModelAttribute("order") Order order) {
        orders.removeIf(i -> i.getNumber().equals(order.getNumber()));
        return "redirect:itemsList";
    }
}
