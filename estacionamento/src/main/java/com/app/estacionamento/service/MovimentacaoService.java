package com.app.estacionamento.service;

import com.app.estacionamento.model.MovimentacaoModel;
import com.app.estacionamento.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovimentacaoService {
    @Autowired
    MovimentacaoRepository repository;

    public void addMovi(MovimentacaoModel movi) {
        repository.save(movi);
    }

    public Optional<MovimentacaoModel> getMoviByID(Long id) {
        return repository.findById(id);
    }


}
