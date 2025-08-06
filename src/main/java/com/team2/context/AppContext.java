package com.team2.context;

import com.team2.controller.PostController;
import com.team2.repository.PostRepository;
import com.team2.service.PostService;

public class AppContext {
    private PostController postController;
    private PostService postService;
    private PostRepository postRepository;

    public void init() {
        postRepository = new PostRepository();
        postService = new PostService(postRepository);
        postController = new PostController(postService);
    }

    public PostController getPostController() {
        return postController;
    }
}
