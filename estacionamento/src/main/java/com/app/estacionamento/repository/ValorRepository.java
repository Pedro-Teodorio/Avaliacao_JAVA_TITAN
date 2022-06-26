package com.app.estacionamento.repository;

import com.app.estacionamento.model.ValorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValorRepository extends JpaRepository<ValorModel, Long> {
}
