package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {
    @GetMapping("/")
    public String home(Model model) {
        Person person = new Person();
        person.setFirstname("John");
        person.setLastname("Doe");
        model.addAttribute(person);

        return "home";
    }

    @PostMapping("/")
    public String home(@ModelAttribute Person person, Model model) {
        model.addAttribute(person);
        return "home";
    }
}
