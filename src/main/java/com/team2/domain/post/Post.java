package com.team2.domain.post;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Post {
    private int id;
    private String title;
    private String content;
    private LocalDateTime regDate;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
