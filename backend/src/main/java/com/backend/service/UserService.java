package com.backend.service;

import com.backend.dto.UserDto;
import com.backend.dto.converter.UserConverter;
import com.backend.dto.request.UserPostRequest;
import com.backend.exception.MailWithUserAlreadyExistsException;
import com.backend.model.User;
import com.backend.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(UserPostRequest userPostRequest) {
        Optional<User> user = userRepository.findByEmail(userPostRequest.getEmail());

        if(user.isPresent()) {
            throw new MailWithUserAlreadyExistsException("User with this email already exists");
        }

        userRepository.save(new User(userPostRequest.getUsername(),
                passwordEncoder.encode(userPostRequest.getPassword()),
                userPostRequest.getEmail(), userPostRequest.getName(),
                userPostRequest.getSurname(),
                userPostRequest.getRole()));
    }

    public void changePassword(long id, String newPassword) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found!"));
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }
}
