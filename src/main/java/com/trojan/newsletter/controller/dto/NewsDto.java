package com.trojan.newsletter.controller.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class NewsDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime created;
}
