package com.lendos.onlinestore.controller;

import com.lendos.onlinestore.domain.Item;
import com.lendos.onlinestore.domain.User;
import com.lendos.onlinestore.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

@Controller
public class MainController {
    @Autowired
    private ItemRepo itemRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter,
                       Model model) {
        Iterable<Item> items = itemRepo.findAll();

        if (filter != null && !filter.isEmpty()) {
            items = itemRepo.findByItemName(filter);
        } else {
            items = itemRepo.findAll();
        }

        model.addAttribute("items", items);
        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String itemName,
            @RequestParam BigDecimal itemPrice,
            @RequestParam boolean inStock ,
            @RequestParam("file") MultipartFile file,
            Map<String, Object> model) throws IOException {
        Item item = new Item(itemName, itemPrice, inStock, user);

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            item.setFilename(resultFilename);
        }

        itemRepo.save(item);

        Iterable<Item> items = itemRepo.findAll();

        model.put("items", items);

        return "main";
    }
}