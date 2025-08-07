package com.team2.domain.post;

public class Post {
    private String title;
    private String content;
    private int id;

    public Post(String title, String content) {
        this. title = title;
        this.content= content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
