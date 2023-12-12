package com.trojan.newsletter.controller;

import com.trojan.newsletter.controller.dto.NewsDto;
import com.trojan.newsletter.model.News;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class NewsDtoMapper {

    public static List<NewsDto> mapToNewsDtos(final List<News> newsList){

        return newsList.stream()
                .map(news -> mapToNewsDto(news))
                .collect(Collectors.toList());
    }

    public static NewsDto mapToNewsDto(final News news){

        return NewsDto.builder()
                .id(news .getId())
                .title(news.getTitle())
                .content(news.getContent())
                .created(news.getCreated())
                .build();
    }
}