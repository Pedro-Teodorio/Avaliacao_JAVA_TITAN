package com.app.estacionamento.repository;

import com.app.estacionamento.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    public UserModel findByUsernameAndPassword(String user,String password);
}
