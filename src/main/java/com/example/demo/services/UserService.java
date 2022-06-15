package com.example.demo.services;

import com.example.demo.model.UserEntity;
import com.example.demo.persistence.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity create(final UserEntity userEntity) {
        if (userEntity == null || userEntity.getEmail() == null) {
            throw new RuntimeException("Invalid args");

        }
        final String email = userEntity.getEmail();
        if (userRepository.existsByEmail(email)) {
            log.warn("{} already exists", email);
            throw new RuntimeException("Email already exists");
        }
        return userRepository.save(userEntity);
    }

    public UserEntity getByCredentials(final String email, final String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

}
