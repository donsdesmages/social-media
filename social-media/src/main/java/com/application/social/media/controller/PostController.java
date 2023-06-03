package com.application.social.media.controller;

import com.application.social.media.dto.PostDto;
import com.application.social.media.dto.util.ResponseBuilderService;
import com.application.social.media.entity.PostEntity;

import com.application.social.media.service.PostService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseBuilderService.DefaultResponseDto savePost(@RequestBody PostEntity postEntity) {
        postService.savePost(postEntity);

        return ResponseBuilderService.DefaultResponseDto.builder().date(LocalDateTime.now()).build();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDto getUserPost(@PathVariable Long id) {

        return postService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostDto> getAllUserPosts() {
        return postService.findAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseBuilderService.DefaultResponseDto updatePost(@PathVariable Long id, @RequestBody PostDto postDto) {
        postService.updateDataPost(postDto, id);

        return ResponseBuilderService.DefaultResponseDto.builder().date(LocalDateTime.now()).build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseBuilderService.DefaultResponseDto deletePost(@PathVariable Long id) {
        postService.deletePostById(id);
        return ResponseBuilderService.DefaultResponseDto.builder().date(LocalDateTime.now()).build();
    }
}
