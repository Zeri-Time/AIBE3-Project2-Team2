package com.team2;

import com.team2.controller.PostController;
import com.team2.repository.PostRepository;
import com.team2.service.PostService;

import java.util.Scanner;

public class AppContext {

    public static Scanner scanner;
    public static PostRepository postRepository;
    public static PostService postService;
    public static PostController postController;

    public static void renew(Scanner _scanner) {
        scanner = _scanner;
        postRepository = new PostRepository();
        postService = new PostService();
        postController = new PostController();
    }

    public static void renew() {
        renew(new Scanner(System.in));
    }
}
