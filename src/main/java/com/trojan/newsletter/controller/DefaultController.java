package com.trojan.newsletter.controller;

import com.trojan.newsletter.model.News;
import com.trojan.newsletter.service.DefaultService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DefaultController {

    private final DefaultService defaultService;

    @GetMapping("/news")
    public List<News> getAllNews(){
        return defaultService.getNews();
    }
}
