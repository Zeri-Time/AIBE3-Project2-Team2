package com.team2.repository;

import com.team2.domain.post.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostRepository {
    private static final List<Post>  postList = new ArrayList<>();
    private int lastId = 0;
    public void save(Post post) {
        post.setId(++lastId);
        post.setCreateDate(LocalDateTime.now());
        postList.add(post);
    }

    public List<Post> getPostList() {
        return postList;
    }

    public static Post findById(int id) {
        for(Post post : postList) {
            if(post.getId() == id) {
                return post;
            }
        }

        return null;
    }


    public void update(Post post) {
        for(int i = 0; i < postList.size(); i++) {
            if(postList.get(i).getId() == post.getId()) {
                postList.set(i, post);
                return;
            }
        }
    }

    public static void delete(Post post) {
        for (int i = 0; i <postList.size() ; i++) {
            if(postList.get(i).getId() == post.getId()){
                postList.remove(i);
                return;
            }
        }
    }
}
