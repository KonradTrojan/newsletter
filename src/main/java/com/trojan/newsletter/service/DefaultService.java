package com.trojan.newsletter.service;

import com.trojan.newsletter.model.Comment;
import com.trojan.newsletter.model.News;
import com.trojan.newsletter.repository.CommentRepository;
import com.trojan.newsletter.repository.NewsRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultService {

    private static final int PAGE_SIZE = 10;
    private final NewsRepository newsRepository;
    private final CommentRepository commentRepository;

    public News getSingleNews(final long id){
        return newsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + id));
    }

    public List<News> getAllNews(final int page, final Sort.Direction sort){
        return newsRepository.findAllNews(
                PageRequest.of(page,
                        PAGE_SIZE,
                        Sort.by(sort, "id")
                )
        );
    }

    public List<News> getNewsWithComments(final int page, final Sort.Direction sort){

        List<News> allNews = newsRepository.findAllNews(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id")));
        List<Long> ids = allNews.stream()
                .map(news -> news.getId())
                .collect(Collectors.toList());

        List<Comment> comments = commentRepository.findAllByNewsIdIn(ids);
        allNews.forEach(news -> news.setComments(extractCommnet(comments, news.getId())));
        return allNews;
    }

    public News addNews(final News news){
        return newsRepository.save(news);
    }

    @Transactional
    public News editNews(final News news){
        News editedNews = newsRepository.findById(news.getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + news.getId()));
        editedNews.setTitle(news.getTitle());
        editedNews.setContent(news.getContent());
        return editedNews;
    }

    public void deleteNews(long id){
        newsRepository.deleteById(id);
    }

    private List<Comment> extractCommnet(final List<Comment> comments, final Long newsId){
        return comments.stream()
                .filter(comment -> comment.getNewsId() == newsId)
                .collect(Collectors.toList());
    }
}