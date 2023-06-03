package com.application.social.media.service.impl;

import com.application.social.media.dto.UserDto;
import com.application.social.media.entity.UserEntity;
import com.application.social.media.repository.UserRepository;
import com.application.social.media.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto findById(UUID id) {
        return userRepository.findById(id)
            .map(user -> UserDto.builder()
                .id(user.getUserId()).build()).orElse(null);
    }

    @Override
    public List<UserDto> findAllSubscription() {
        List<UserEntity> entities = userRepository.findAll();

        return entities.stream().map(user ->
            UserDto.builder()
                .id(user.getUserId()).build()).collect(Collectors.toList());
    }

    @Override
    public void saveUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    @Override
    public void deletePostById(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateDataPost(UserDto userDto, UUID id) {
        userRepository.findById(id).ifPresent(post -> {
            post.setUserId(userDto.getId());
            userRepository.save(post);
        });
    }
}
