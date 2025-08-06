package com.team2;

import com.team2.controller.PostController;
import com.team2.repository.PostRepository;
import com.team2.service.PostService;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AppContext {
    public static final Scanner scanner;
    public static final DateTimeFormatter forPrintDateTimeFormatter;
    public static final PostRepository postRepository;
    public static final PostService postService;
    public static final PostController postController;

    static {
        scanner = new Scanner(System.in);
        forPrintDateTimeFormatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
        postRepository = new PostRepository();
        postService = new PostService();
        postController = new PostController();
    }
}