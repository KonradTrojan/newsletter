package com.trojan.newsletter.controller;

import com.trojan.newsletter.controller.dto.NewsDto;
import com.trojan.newsletter.model.News;
import com.trojan.newsletter.service.DefaultService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DefaultController {

    private final DefaultService defaultService;

    @GetMapping("news/{id}")
    public NewsDto getSingleNews(@PathVariable final Long id){
        return NewsDtoMapper.mapToNewsDto(defaultService.getSingleNews(id));
    }

    @GetMapping("news/{id}/comments")
    public News getSingleNewsWithComments(@PathVariable final Long id){
        return defaultService.getSingleNews(id);
    }

    @GetMapping("/news")
    public List<NewsDto> getAllNews(@RequestParam(required = false) final Integer page, final Sort.Direction sort){
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return NewsDtoMapper.mapToNewsDtos(defaultService.getAllNews(pageNumber, sortDirection));
    }

    @GetMapping("/news/comments")
    public List<News> getAllNewsWithComments(@RequestParam(required = false) final Integer page, final Sort.Direction sort){
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return defaultService.getNewsWithComments(pageNumber, sortDirection);
    }

    @PostMapping("/news")
    public News addNews(@RequestBody final News news){
        return defaultService.addNews(news);
    }

    @PutMapping("/news")
    public News editNews(@RequestBody final News news) {
        return defaultService.editNews(news);
    }

    @DeleteMapping("/news/{id}")
    public void deleteNews(@PathVariable final long id){
        defaultService.deleteNews(id);
    }
}