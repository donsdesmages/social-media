package com.application.social.media.service.impl;

import com.application.social.media.dto.PostDto;
import com.application.social.media.entity.PostEntity;
import com.application.social.media.repository.PostRepository;
import com.application.social.media.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostDto findById(Long id) {
        return postRepository.findById(id).map(post ->
            PostDto.builder().namePost(post.getNamePost()).build()).orElse(null);
    }

    public List<PostDto> findAll() {
        List<PostEntity> entities = postRepository.findAll();

        return entities.stream().map(post -> PostDto.builder()
            .namePost(post.getNamePost()).build()).collect(Collectors.toList());
    }

    public void savePost(PostEntity postEntity) {
        postRepository.save(postEntity);
    }

    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }

    public void updateDataPost(PostDto postDto, Long id) {
        postRepository.findById(id).ifPresent(post -> {
            post.setNamePost(postDto.getNamePost());
            postRepository.save(post);
        });
    }
}
