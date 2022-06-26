package com.app.estacionamento.repository;

import com.app.estacionamento.model.MovimentacaoModel;
import com.app.estacionamento.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoRepository extends JpaRepository<MovimentacaoModel, Long> {

}
