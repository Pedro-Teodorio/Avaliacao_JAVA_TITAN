package com.app.estacionamento.service;

import com.app.estacionamento.model.ValorModel;
import com.app.estacionamento.repository.ValorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValorService {

    @Autowired
    ValorRepository repository;
    public Optional<ValorModel> getValor(Long id) {
        return repository.findById(id);
    }
}
