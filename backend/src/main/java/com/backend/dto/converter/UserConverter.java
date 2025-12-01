package com.backend.dto.converter;

import com.backend.dto.UserDto;
import com.backend.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserDto toDto(User user){

        if(user == null) return null;

        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getName(),
                user.getSurname(),
                user.getRole()
        );
    }
}
