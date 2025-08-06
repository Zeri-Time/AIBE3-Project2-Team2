package com.team2.app;

import com.team2.domain.post.Post;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 클래스 선언
public class App {
    private final Scanner sc;
    private final List<Post> posts;
    private int lastPostId;

    // 필드 초기화
    public App() {
        this.sc = new Scanner(System.in);
        this.posts = new ArrayList<>();
        this.lastPostId = 0;
    }

    public void run() {
        while (true) {
            System.out.println("명령: ");
            String command = sc.nextLine().trim();

            // case: 을 case -> 로 변경. break 필요 없이 해당 case가 실행되면 알아서 메서드 종료됨.
            switch (command) {
                case "end" ->
                    System.out.println("종료 합니다");
                case "write" ->
                    writePost();
                case "list" ->
                    listPosts();
                case "delete" ->
                    deletePost();
                default ->
                    System.out.println("명령어를 확인 해주세요");
            }
        }
    }

    // 게시물 작성 메서드
    public void writePost() {
        System.out.println("제목: ");
        String title = sc.nextLine();

        System.out.println("내용: ");
        String content = sc.nextLine();

        lastPostId++;
        String regDate = LocalDate.now().toString();

        Post newPost = new Post(lastPostId, title, content, regDate);
        posts.add(newPost);

        System.out.printf("%d번 게시글이 등록되었습니다.\n", lastPostId);
        // printf 메서드 참고 -> println과 혼동x
        // %d: 여기에 정수형 변수의 값이 들어감
        // **printf 사용 시 포맷 지정자(%d)에 대응하는 값을 반드시 제공해야함
        // 만약 정수형 변수가 두개 이상이면 차례대로 들어가니까 %d를 두번 이상 사용해도 됨
        // \n: printf 에는 줄바꿈 원하는 곳에 수동으로 넣어주면 됨
    }

    // 게시물 조회 메서드
    public void listPosts() {
        if (posts.isEmpty()) {
            System.out.println("게시글이 없습니다.");
            return;
        }
        System.out.println("--게시글 목록--");
        System.out.println("번호 / 제목 / 내용 / 등록일");

        for (int i = posts.size() - 1; i >= 0; i--) {
            Post post = posts.get(i);
//            System.out.println(post.id + " / " +  post.title + " / " + post.content + " / " + post.regDate);
            System.out.printf("%d / %s / %s / %s\n", post.id, post.title, post.content, post.regDate);
        }
    }

    public void deletePost() {
        System.out.println("삭제할 게시물 번호: ");
        int idDelete = sc.nextInt();
        sc.nextLine();

        Post foundPost = null;
        for (Post post : posts) {
            if (post.id == idDelete) {
                foundPost = post;
                break;
            }
        }
        if (foundPost != null) {
            posts.remove(foundPost);
            System.out.printf("%d번 게시글 삭제.\n", idDelete);
        } else {
            System.out.printf("%d번 게시글을 찾을 수 없음.\n", idDelete);
        }
    }
}
