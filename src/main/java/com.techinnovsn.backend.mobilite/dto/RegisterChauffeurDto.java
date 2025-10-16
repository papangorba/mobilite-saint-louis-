package com.techinnovsn.backend.mobilite.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterChauffeurDto {
    @NotBlank(message = "Veuillez saisir votre nom")
    private String name;

    @NotBlank(message = "Veuillez saisir votre numéro de téléphone")
    private String telephone;

    @NotBlank(message = "Veuillez saisir votre numéro du permis")
    private String numeroDePermis;

    @NotBlank(message = "Veuillez saisir la date d'expiration du permis")
    private String dateExpirationDuPermis;

}
