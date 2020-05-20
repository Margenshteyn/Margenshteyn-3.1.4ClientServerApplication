package com.example.SpringClient.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ClientController {

    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    @GetMapping("/mainPage")
    public String getTable(Model model, HttpSession session) {
        model.addAttribute("user", session.getAttribute("user"));
        return "table";
    }

}

