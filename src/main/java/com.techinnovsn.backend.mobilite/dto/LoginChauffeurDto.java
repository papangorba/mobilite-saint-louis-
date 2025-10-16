package com.techinnovsn.backend.mobilite.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginChauffeurDto {

    @NotBlank(message = "Veuillez saisir votre numéro de téléphone")
    private String telephone;

}
