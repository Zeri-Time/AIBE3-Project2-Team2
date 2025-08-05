package com.team2.domain.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {
    private int id;
    private String title;
    private String content;
    private String regDate;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
