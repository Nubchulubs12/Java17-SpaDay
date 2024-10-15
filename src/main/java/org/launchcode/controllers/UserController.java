package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/add")
    public String displayADDUserForm() {
        return "user/add";
    }
    @PostMapping("")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verifyPassword) {
        if (user.getPassword()==null || verifyPassword ==null || !user.getPassword().equals(verifyPassword)) {

            model.addAttribute("errorMessage", "Passwords do not match. Please try again.");
            model.addAttribute("userame", user.getUsername());
            model.addAttribute("email", user.getEmail());
            return "/user/add";

        } else {

            model.addAttribute("userName", user.getUsername());

            return "/user/index";

        }

    }
}