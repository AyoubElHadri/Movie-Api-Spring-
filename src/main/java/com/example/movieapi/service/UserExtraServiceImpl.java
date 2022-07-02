package com.example.movieapi.service;

import com.example.movieapi.exceptions.UserExtraNotFoundException;
import com.example.movieapi.model.UserExtra;
import com.example.movieapi.repository.UserExtraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserExtraServiceImpl implements UserExtraService{
    private final UserExtraRepository userExtraRepository;


    @Override
    public UserExtra validateAndGetUserExtra(String username) {
        return getUserExtra(username).orElseThrow(()-> new UserExtraNotFoundException(username));
    }

    @Override
    public Optional<UserExtra> getUserExtra(String username) {
        return userExtraRepository.findById(username);
    }

    @Override
    public UserExtra saveUserExtra(UserExtra userExtra) {
        return userExtraRepository.save(userExtra);
    }
}
