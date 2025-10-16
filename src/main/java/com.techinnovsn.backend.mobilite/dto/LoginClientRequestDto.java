package com.techinnovsn.backend.mobilite.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginClientRequestDto {
    @NotBlank(message = "Veuillez saisir votre numéro de téléphone")
    private String telephone;
}
