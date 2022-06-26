package com.app.estacionamento.controller;


import com.app.estacionamento.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ListController {



    @Autowired
    UserService userService;

    @GetMapping("{id}/lista")
    public String list(Model model, @PathVariable long id) {
        var user = userService.findById(id);

        if (user.isPresent()) {
            var movimentacao = user.get().getMovimentacao();
            model.addAttribute("movimentacao", movimentacao);
            model.addAttribute("id", id);
            return "lista/estacionados";
        }
        return "lista/estacionados";
    }
    @GetMapping("{id}/lista/sairam")
    public String listSairam(Model model, @PathVariable long id) {
        var user = userService.findById(id);

        if (user.isPresent()) {
            var movimentacao = user.get().getMovimentacao();
            model.addAttribute("movimentacao", movimentacao);
            model.addAttribute("id", id);
            return "lista/sairam";
        }
        return "lista/sairam";
    }

}
