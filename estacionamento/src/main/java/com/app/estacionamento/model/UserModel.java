package com.app.estacionamento.model;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@Entity
@DynamicInsert
@Table(name = "tblUsuario")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column
    @ColumnDefault("'admin'")
    private String name;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_user", referencedColumnName = "idUser")
    @ToString.Exclude
    List<MovimentacaoModel> movimentacao ;


    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserModel userModel = (UserModel) o;
        return idUser != null && Objects.equals(idUser, userModel.idUser);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
