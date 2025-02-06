package com.korit.springboot_study.repository;

import com.korit.springboot_study.entity.books.Publisher;
import com.korit.springboot_study.exception.CustomDuplicateKeyException;
import com.korit.springboot_study.mapper.PublisherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class PublisherRepository {

    @Autowired
    private PublisherMapper publisherMapper;

    public Optional<List<Publisher>> findAllPublisher() {
        List<Publisher> foundPublisher = publisherMapper.selectAllPublisher();
        return Optional.ofNullable(foundPublisher);
    }

    public Optional<Publisher> savePublisher(Publisher publisher) throws DuplicateKeyException {
        try {
            publisherMapper.insertPublisher(publisher);
        }catch (DuplicateKeyException e){
            throw  new CustomDuplicateKeyException(
                    e.getMessage(),
                    Map.of("publisherName", "이미존재한느 출판사입니다.")
            );
        }
        return Optional.ofNullable(new Publisher(publisher.getPublisherId(), publisher.getPublisherName()));
    }
}
