package com.example.ejercicio.service.dto.phone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PhoneDTO {

    private String number;

    private String cityCode;

    private String countryCode;

}
