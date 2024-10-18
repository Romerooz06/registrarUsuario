package com.example.ejercicio.model;

import com.example.ejercicio.model.phone.Phone;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;


@Entity
@Transactional
@Table(name = "userInfo")
@Getter
@Setter
public class User extends BaseModel {

    private String name;

    @Email
    private String email;

    private String password;

    private String token;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_phone_id")
    private Phone phone;

    private Boolean isActive = true;

}
