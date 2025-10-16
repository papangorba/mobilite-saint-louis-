package com.techinnovsn.backend.mobilite.mapper;

import com.techinnovsn.backend.mobilite.dto.RegisterClientDto;
import com.techinnovsn.backend.mobilite.entity.User;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public RegisterClientDto toDto(User client){
        if (client == null) return null;
        RegisterClientDto clientDto = new RegisterClientDto();
        clientDto.setTelephone(client.getTelephone());
        return clientDto;
    }

    public User toEntity(RegisterClientDto clientDto){
        if (clientDto == null) return null;
        User user = new User();
        user.setTelephone(clientDto.getTelephone());
        return user;
    }

}
