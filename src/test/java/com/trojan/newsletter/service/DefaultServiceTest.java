package com.trojan.newsletter.service;

import com.trojan.newsletter.model.News;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DefaultServiceTest {

    @Autowired
    private DefaultService defaultService;

    @Test
    void shouldGetSingleNewsTest() {
        //given
        //when
        News singleNews = defaultService.getSingleNews(1L);
        //then
        assertThat(singleNews).isNotNull();
        assertThat(singleNews.getId()).isEqualTo(1L);
    }
}