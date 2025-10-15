package com.techinnovsn.mapper;

import com.techinnovsn.dto.RegisterClientDto;
import com.techinnovsn.entity.User;
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
