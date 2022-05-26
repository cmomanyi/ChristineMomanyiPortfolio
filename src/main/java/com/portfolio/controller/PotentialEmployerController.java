package com.portfolio.controller;

import com.portfolio.domain.PotentialEmployer;
import com.portfolio.repo.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * java docs coming up
 * https://www.baeldung.com/spring-boot-crud-thymeleaf
 */

@Controller
public class PotentialEmployerController {
    @Autowired
    EmployerRepository employerRepository;

    @GetMapping("/signup")
    public String showSignUpForm(PotentialEmployer potentialEmployer)
    {
        return "add-potentialEmployer";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid PotentialEmployer potentialEmployer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-potentialEmployer";
        }

        employerRepository.save(potentialEmployer);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("potentialEmployers", employerRepository.findAll());
        return "index";
    }

//    @GetMapping("/edit/{id}")
//    public String showUpdateForm(@PathVariable("id") long id, Model model) {
//        PotentialEmployer potentialEmployer = employerRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//
//        model.addAttribute("user", potentialEmployer);
//        return "update-user";
 //   }
}
