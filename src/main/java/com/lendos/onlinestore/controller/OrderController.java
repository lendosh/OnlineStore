package com.lendos.onlinestore.controller;

import com.lendos.onlinestore.domain.Order;
import com.lendos.onlinestore.domain.User;
import com.lendos.onlinestore.repos.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderRepo orderRepo;

    @GetMapping
    private String cart(Map<String, Object> model){
        return "cart";
    }

    @GetMapping("buy/{id}")
    public String buy(@AuthenticationPrincipal User customer,
                      @PathVariable("id") Long id,
                      Map<String, Object> model){
        Order order = new Order();

        return "redirect:/main";
    }
}
