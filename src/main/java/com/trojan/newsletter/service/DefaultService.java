package com.trojan.newsletter.service;

import com.trojan.newsletter.model.News;
import com.trojan.newsletter.repository.NewsRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultService {

    private final NewsRepository newsRepository;

    public List<News> getNews(){
        return newsRepository.findAll();
    }
}
