package com.spring_MVC_hibernate.demo.controller;

import com.spring_MVC_hibernate.demo.model.User;
import com.spring_MVC_hibernate.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", service.findAllUsers());
        return "index";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user) {
        service.saveUser(user.getName(), user.getCity(), user.isMarried());
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") long id, Model model) {
        model.addAttribute("user", service.findByIdUser(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String update(User user) {
        service.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") long id) {
        service.deleteByIdUser(id);
        return "redirect:/";
    }

    @GetMapping("/clear")
    public String clear() {
        service.deleteAllUsers();
        return "redirect:/";
    }
}
