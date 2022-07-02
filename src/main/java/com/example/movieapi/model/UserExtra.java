package com.example.movieapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "userextras")
public class UserExtra {
    private String username;
    private String avatar;
}
