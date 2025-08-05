package com.team2;

import com.team2.controller.PostController;
import com.team2.repository.PostRepository;
import com.team2.service.PostService;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AppContext {
    public static final Scanner sc;
    public static final DateTimeFormatter formatter;
    public static final PostRepository postRepository;
    public static final PostService postService;
    public static final PostController postController;

    static {
        sc = new Scanner(System.in);
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        postRepository = new PostRepository();
        postService = new PostService();
        postController = new PostController();
    }
}
