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

            switch (command) {
                case "end":
                    System.out.println("종료 합니다");
                    return;
                case "write":
                    writePost();
                    break;
                default:
                    System.out.println("명령어를 확인 해주세요");
                    break;
            }
        }
    }

    public void writePost() {
        System.out.println("제목: ");
        String title = sc.nextLine();

        System.out.println("내용: ");
        String content = sc.nextLine();

        lastPostId++;
        String regDate = LocalDate.now().toString();

        Post newPost = new Post(lastPostId, title, content, regDate);
        posts.add(newPost);

        System.out.println("%d번 게시글이 등록되었습니다.\n");
        // printf 메서드 참고
            // %d: 여기에 정수형 변수의 값이 들어감
                // 만약 정수형 변수가 두개 이상이면 차례대로 들어가니까 %d를 두번 이상 사용해도 됨
            // \n: 줄바꿈. println 내부에서도 사용 가능하네
    }
}
