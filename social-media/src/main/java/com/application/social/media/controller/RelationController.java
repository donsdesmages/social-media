package com.application.social.media.controller;

import com.application.social.media.entity.UserEntity;
import com.application.social.media.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/relation/user")
@RequiredArgsConstructor
public class RelationController {

    private final UserRepository userRepository;

    @PostMapping
    public String sendApplication(@RequestParam UUID uuid, @RequestParam UUID uuid1) {
        Optional<UserEntity> me = userRepository.findById(uuid);
        Optional<UserEntity> friend = userRepository.findById(uuid1);

        me.get().getSubscriptions().add(friend.get());

        userRepository.save(me.get());

        return "Заявка будет рассмотрена";
    }
}
