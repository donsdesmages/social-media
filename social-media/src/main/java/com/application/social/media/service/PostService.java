package com.application.social.media.service;

import com.application.social.media.dto.PostDto;
import com.application.social.media.entity.PostEntity;
import com.application.social.media.entity.UserEntity;

import java.util.List;

public interface PostService {

    PostDto findById(Long id);

    List<PostDto> findAll();

    void savePost(PostEntity postEntity);

    void deletePostById(Long id);

    void updateDataPost(PostDto postDto, Long id);

}
