package com.example.ejercicio.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionMessages {
    INVALID_EMAIL("Por favor verifica el formato de tu correo e intenta nuevamente"),
    INVALID_PASS("Contraseña no valida (Debe contener 8 caracteres, una minuscula, una mayuscula, un numero y un caracter especial =.*[@#$%^&+=]"),
    EXISTING_EMAIL("El correo ya se encuentra en la base de datos"),
    INSERT_DB_ERROR("Error insertando usuario en la base de datos, intente nuevamente");

    private final String message;
}
