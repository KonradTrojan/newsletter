package com.trojan.newsletter.model;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private LocalDateTime created;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "newsId", updatable = false, insertable = false)
    private List<Comment> comments;
}

