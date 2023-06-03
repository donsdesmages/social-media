package com.application.social.media.controller;

import com.application.social.media.entity.UserEntity;

import com.application.social.media.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public String saveUser() {
        UserEntity userEntity = new UserEntity();

        userEntity.setUserId(UUID.randomUUID());
        userService.saveUser(userEntity);
        log.info("user added");
        return "Пользователь сохранен";
    }

}
