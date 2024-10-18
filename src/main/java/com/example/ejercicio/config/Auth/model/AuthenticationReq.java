package com.example.ejercicio.config.Auth.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthenticationReq implements Serializable {

  private static final long serialVersionUID = 1L;

  private String usuario;

  private String clave;

}
