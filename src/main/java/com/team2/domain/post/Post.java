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
    private final LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private final DateTimeFormatter formatter;

    public Post(int id, String title, String content, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.formatter = AppContext.formatter;
    }


}
