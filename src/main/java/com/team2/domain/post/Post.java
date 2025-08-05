package com.team2.domain.post;

public class Post {
    public int id;
    public String title;
    public String content;
    public String regDate;

    public Post(int id, String title, String content, String regDate){
        this.id = id;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
    }
}
