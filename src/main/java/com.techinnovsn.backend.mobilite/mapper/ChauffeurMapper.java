package com.techinnovsn.backend.mobilite.mapper;

import com.techinnovsn.backend.mobilite.dto.RegisterChauffeurDto;
import com.techinnovsn.backend.mobilite.entity.User;
import com.techinnovsn.backend.mobilite.entity.enums.Role;
import org.springframework.stereotype.Component;

@Component
public class ChauffeurMapper {
    public User toEntity(RegisterChauffeurDto dto) {
        User chauffeur = new User();
        chauffeur.setName(dto.getName());
        chauffeur.setTelephone(dto.getTelephone());
        chauffeur.setNumeroDePermis(dto.getNumeroDePermis());
        chauffeur.setDateExpirationDuPermis(dto.getDateExpirationDuPermis());
        chauffeur.setRole(Role.CHAUFFEUR);
        return chauffeur;
    }
}
