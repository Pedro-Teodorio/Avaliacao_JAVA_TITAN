package com.app.estacionamento.controller;

import com.app.estacionamento.dto.resquest.UserDTO;
import com.app.estacionamento.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserService service;
    @GetMapping("/user/add")
    public String form(){
        return "user/formUser";
    }

    @PostMapping("/user/add")
    public String addUser(UserDTO user){
        service.addUser(user.resquest());
        return "redirect:/user/add";
    }
}
