package com.application.social.media.service;

import com.application.social.media.dto.RelationDto;

import java.util.List;

public interface RelationService {

    RelationDto findAllApplication();

    List<RelationDto> findApplicationById(Long id);

    void rejectApplication(Long id);



}
