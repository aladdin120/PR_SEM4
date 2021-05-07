package com.example.lab19.controller;

import com.example.lab19.entities.Item;
import com.example.lab19.entities.Order;
import com.example.lab19.service.ItemService;
import com.example.lab19.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/home")
public class Controller {
    private static List<Item> items = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();
    private Boolean flag = true;

    @Autowired
    ItemService itemService;

    @Autowired
    OrderService orderService;

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
            items = itemService.getAllItems();
            orders = orderService.getAllOrders();
        }
        model.addAttribute("items", items);
        model.addAttribute("orders", orders);

        return "itemsList";
    }

    @GetMapping("/getOBN")
    public String getOBN() {
        flag = false;
        orders = orderService.getOrdersFilteredByNumber();

        return "redirect:itemsList";
    }

    @GetMapping("/getOBD")
    public String getOBD() {
        flag = false;
        orders = orderService.getOrdersFilteredByDate();

        return "redirect:itemsList";
    }

    @GetMapping("/getIBN")
    public String getIBN() {
        flag = false;
        items = itemService.getItemsFilteredByName();

        return "redirect:itemsList";
    }

    @GetMapping("/getIBD")
    public String getIBD() {
        flag = false;
        items = itemService.getItemsFilteredByDate();

        return "redirect:itemsList";
    }

    @GetMapping("/getIBP")
    public String getIBP() {
        flag = false;
        items = itemService.getItemsFilteredByPrice();

        return "redirect:itemsList";
    }
}
