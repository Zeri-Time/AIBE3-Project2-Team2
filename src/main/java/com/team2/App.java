package com.team2;

import com.team2.controller.PostController;
import com.team2.global.Rq;

public class App {
    public void run() {
        System.out.println("== 게시판 ==");

        PostController postController = AppContext.postController;

        while (true) {
            System.out.print("명령) ");
            String cmd = AppContext.sc.nextLine().trim();
            Rq rq = new Rq(cmd);

            switch (rq.getActionName()) {
                case "등록" -> postController.actionWrite();
                case "목록" -> postController.actionList(rq);
                case "상세" -> postController.actionDetail(rq);
                case "수정" -> postController.actionModify(rq);
                case "삭제" -> postController.actionDelete(rq);
                case "종료" -> {
                    return;
                }
                default -> System.out.println("알 수 없는 명령어입니다.");
            }
        }

    }
}
