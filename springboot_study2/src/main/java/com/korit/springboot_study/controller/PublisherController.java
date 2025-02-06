package com.korit.springboot_study.controller;

import com.korit.springboot_study.dto.request.books.ReqAddPublisherDto;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.books.Publisher;
import com.korit.springboot_study.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/api/books/publishers")
    public ResponseEntity<SuccessResponseDto<List<Publisher>>> getAllPublishers() {
        return ResponseEntity.ok().body(publisherService.getAllPublishers());
    }

    @PostMapping("/api/books/publisher")
    public ResponseEntity<SuccessResponseDto<Optional<Publisher>>> addPublisher(ReqAddPublisherDto reqAddPublisherDto) throws DuplicateKeyException {
        return ResponseEntity.ok().body(publisherService.AddPublisher(reqAddPublisherDto));
    }
}
