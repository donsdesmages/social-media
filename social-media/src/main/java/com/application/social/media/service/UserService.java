package com.application.social.media.service;


import com.application.social.media.dto.UserDto;
import com.application.social.media.entity.UserEntity;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserDto findById(UUID id);

    List<UserDto> findAllSubscription();

    void saveUser(UserEntity userEntity);

    void deletePostById(UUID id);

    void updateDataPost(UserDto userDto, UUID id);
}
