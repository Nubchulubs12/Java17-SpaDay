package org.launchcode.controllers;

import org.launchcode.UserData;
import org.launchcode.models.User;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("")
    public String displayADDUserForm() {
        return "user/add";
    }
    @PostMapping("")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verifyPassword) {
        if (!user.getPassword().equals(verifyPassword)) {

            model.addAttribute("errorMessage", "Passwords do not match. Please try again.");
            model.addAttribute("userame", user.getUsername());
            model.addAttribute("email", user.getEmail());
            return "/user/add";

        } else {
            UserData.add(user);
            model.addAttribute("username", user);
            model.addAttribute("users", UserData.getAll());
            return "/user/index";

        }

    }
    @GetMapping("/details/{id}")
    public String displayDetails(@PathVariable int id, Model model) {
        model.addAttribute("user", UserData.getById(id));
        return "/user/details";
    }
}