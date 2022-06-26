package com.app.estacionamento.service;

import com.app.estacionamento.model.UserModel;
import com.app.estacionamento.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserModel> listAll() {
        return userRepository.findAll();
    }

    public void addUser(UserModel user) {
        userRepository.save(user);
    }

    public UserModel login(String user,String password){
        return userRepository.findByUsernameAndPassword(user, password);
    }
    public Optional<UserModel> findById(long id){
        return userRepository.findById(id);
    }


}
