package com.spring_MVC_hibernate.demo.controller;

import com.spring_MVC_hibernate.demo.service.IUserService;
import com.spring_MVC_hibernate.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final IUserService service;

    @Autowired
    public UserController(IUserService service) {
        this.service = service;
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", service.findAll());
        return "index";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user) {
        System.out.println(user);
        service.save(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") long id, Model model) {
        model.addAttribute("user", service.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String update(User user) {
        service.save(user);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") long id) {
        service.deleteById(id);
        return "redirect:/";
    }
}
