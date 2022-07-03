package com.example.movieapi.controller;

import com.example.movieapi.model.UserExtra;
import com.example.movieapi.service.UserExtraService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/userextras")
public class UserExtraController {

    private final UserExtraService userExtraService;

    @GetMapping("/me")
    public UserExtra getUserExtra(Principal principal) {
        return userExtraService.validateAndGetUserExtra(principal.getName());
    }

/*    @PostMapping("/me")
    public UserExtra saveUserExtra(@Valid @RequestBody UserExtraRequest updateUserExtraRequest, Principal principal) {
        Optional<UserExtra> userExtraOptional = userExtraService.getUserExtra(principal.getName());
        UserExtra userExtra = userExtraOptional.orElseGet(() -> new UserExtra(principal.getName()));
        userExtra.setAvatar(updateUserExtraRequest.getAvatar());
        return userExtraService.saveUserExtra(userExtra);
    }*/
}
