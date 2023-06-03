package com.application.social.media.service.impl;

import com.application.social.media.dto.RelationDto;
import com.application.social.media.service.RelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RelationServiceImpl implements RelationService {

    @Override
    public RelationDto findAllApplication() {
        return null;
    }

    @Override
    public List<RelationDto> findApplicationById(Long id) {
        return null;
    }

    @Override
    public void rejectApplication(Long id) {

    }
}
