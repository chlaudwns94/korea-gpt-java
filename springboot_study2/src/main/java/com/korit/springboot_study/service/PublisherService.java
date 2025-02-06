package com.korit.springboot_study.service;

import com.korit.springboot_study.dto.request.books.ReqAddPublisherDto;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.books.Publisher;
import com.korit.springboot_study.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Transactional(rollbackFor = Exception.class)
    public SuccessResponseDto<List<Publisher>> getAllPublishers() {
        List<Publisher> foundPublisher = publisherRepository.findAllPublisher().orElseThrow();
        return new SuccessResponseDto<>(foundPublisher);
    }

    @Transactional(rollbackFor = Exception.class)
    public SuccessResponseDto<Optional<Publisher>> AddPublisher(ReqAddPublisherDto reqAddPublisherDto) throws DuplicateKeyException {
        return new SuccessResponseDto<>(
                publisherRepository.savePublisher(new Publisher(0, reqAddPublisherDto.getPublisherName()))
        );
    }
}
