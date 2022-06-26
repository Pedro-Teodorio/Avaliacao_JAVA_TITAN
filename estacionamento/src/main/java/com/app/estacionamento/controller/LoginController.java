package com.app.estacionamento.controller;

import com.app.estacionamento.dto.resquest.UserDTO;
import com.app.estacionamento.model.UserModel;
import com.app.estacionamento.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    UserService service;

    @GetMapping("/")
    public String
    login() {
        return "login/index";
    }

    @PostMapping("/")
    public String logar(Model model, UserDTO userDTO) {
        UserModel user = this.service.login(userDTO.resquest().getUsername(), userDTO.resquest().getPassword());
        if (user != null) {
            return "redirect:"+user.getIdUser()+"/lista";
        }
        model.addAttribute("erro", "Usuário ou Senha Inválidos");
        return "login/index";
    }
}
