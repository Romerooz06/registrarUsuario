package com.example.ejercicio.model.phone;

import com.example.ejercicio.model.User;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Transactional
@Getter
@Setter
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID phoneId;

    private String number;

    private String cityCode;

    private String countryCode;

    @OneToOne(mappedBy = "phone")
    private User user;

}
