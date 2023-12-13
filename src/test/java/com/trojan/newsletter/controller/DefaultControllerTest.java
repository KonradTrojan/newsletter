package com.trojan.newsletter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trojan.newsletter.model.News;
import com.trojan.newsletter.repository.NewsRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class DefaultControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private NewsRepository newsRepository;

    @Test
    @Transactional
    void shouldGetSinglePost() throws Exception {
        //given
        News testNews = new News();
        testNews.setTitle("test title");
        testNews.setContent("test content");
        testNews.setCreated(LocalDateTime.now());

        newsRepository.save(testNews);

        //when
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/news/" + testNews.getId()))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();

        //then
        News news = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), News.class);
        assertThat(news).isNotNull();
        assertThat(news.getId()).isEqualTo(testNews.getId());
        assertThat(news.getTitle()).isEqualTo(testNews.getTitle());
        assertThat(news.getContent()).isEqualTo(testNews.getContent());

    }
}