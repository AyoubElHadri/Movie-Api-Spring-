package com.example.movieapi.service;

import com.example.movieapi.model.UserExtra;

import java.util.Optional;

public interface UserExtraService {
    UserExtra validateAndGetUserExtra(String username);
    Optional<UserExtra> getUserExtra(String username);
    UserExtra saveUserExtra(UserExtra userExtra);
}
