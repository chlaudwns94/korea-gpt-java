package com.korit.springboot_study.mapper;

import com.korit.springboot_study.entity.books.Publisher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PublisherMapper {
    List<Publisher> selectAllPublisher();

    int insertPublisher(Publisher publisher);

    List<Publisher> selectAllPublisherByName(@Param(value = "publisher") String publisherName);
}
