package com.app.estacionamento.controller;

import com.app.estacionamento.model.MovimentacaoModel;
import com.app.estacionamento.service.MovimentacaoService;
import com.app.estacionamento.service.ValorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Controller
public class MovimentacaoController {

    @Autowired
    MovimentacaoService service;

    @Autowired
    ValorService valorService;

    @GetMapping("movimentacao/{id}")
    public String loadMovimentacao(@PathVariable Long id, Model model) {
        model.addAttribute("key", id);
        return "/movimentacao/formMov";
    }

    @PostMapping("movimentacao/add")
    public String addMovi(String placa, String modelo, Long idUser) {

        LocalDateTime dataAtual = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formatDateTime = dataAtual.format(format);

        MovimentacaoModel movi = new MovimentacaoModel();
        movi.setModelo(modelo);
        movi.setIdUser(idUser);
        movi.setPlaca(placa);
        movi.setDataEntrada(formatDateTime);
        service.addMovi(movi);
        return "redirect:/" + idUser + "/lista";
    }

    @GetMapping("movimentacao/editar/{id}")
    public String getMoviByID(@PathVariable Long id, Model model) {

        var movi = service.getMoviByID(id);

        movi.ifPresent(movimentacaoModel -> model.addAttribute("data", movimentacaoModel));
        return "/movimentacao/formMovEdit";
    }

    @PostMapping("movimentacao/editar/{id}")
    public String changeMovi(String placa, String modelo, Long idUser, @PathVariable Long id) {

        var movimentacao = service.getMoviByID(id);

        movimentacao.ifPresent(movi -> {
            movi.setModelo(modelo);
            movi.setIdUser(idUser);
            movi.setPlaca(placa);
            service.addMovi(movi);
        });

        return "redirect:/" + idUser + "/lista";
    }

    @GetMapping("movimentacao/saida/{id}")
    public String getMoviSaidaByID(@PathVariable Long id, Model model) {

        var movi = service.getMoviByID(id);
        var valor = valorService.getValor(1L);

        valor.ifPresent(value -> model.addAttribute("valor", value));
        movi.ifPresent(movimentacao -> model.addAttribute("data", movimentacao));
        return "/movimentacao/formMovSaida";
    }

    @PostMapping("movimentacao/saida/{id}")
    public String postMoviSaidaByID(@PathVariable Long id, MovimentacaoModel model) {

        var movimentacao = service.getMoviByID(id);

        movimentacao.ifPresent(mov -> service.addMovi(model));

        return "redirect:/" + movimentacao.get().getIdUser() + "/lista";
    }
}
