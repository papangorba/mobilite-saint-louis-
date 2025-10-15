package com.techinnovsn.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterClientDto {

    @NotBlank(message = "Veuillez saisir votre numéro de téléphone")
    private String telephone;

}
