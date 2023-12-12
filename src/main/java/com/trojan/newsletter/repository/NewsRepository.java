package com.trojan.newsletter.repository;

import com.trojan.newsletter.model.News;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

    @Query("Select n From News n")
    List<News> findAllNews(PageRequest id);
}
