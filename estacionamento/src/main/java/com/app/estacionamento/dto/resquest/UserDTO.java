package com.app.estacionamento.dto.resquest;


import com.app.estacionamento.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String username;
    private String password;

    public UserModel resquest (){
        return new UserModel()
                .setUsername(this.username)
                .setPassword(this.password);

    }
}
