package com.team2.domain.post;

import com.team2.AppContext;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString
public class Post {
    private int id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private final DateTimeFormatter formatter;
    private int count; // 조회수

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
        this.formatter = AppContext.formatter;
        this.count = 0;
    }

    public boolean isNew() {
        return id == 0;
    }

    public void increaseCount() {
        this.count++;
    }
}
