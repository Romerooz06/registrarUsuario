package com.example.ejercicio.service.dto;


import com.example.ejercicio.service.dto.phone.PhoneDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Valid
public class UserDTO {

    private String name;

    private String email;

    private String password;

    private PhoneDTO phone;

}
