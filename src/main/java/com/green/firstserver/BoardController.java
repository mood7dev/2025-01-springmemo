package com.green.firstserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController//빈(Bean) 등록, 스플이 컨테이너 객체 생성을 대리로 맡긴다. 요청/응답 담당자
    public class BoardController {
        @GetMapping("/board")
        public String board() {
            return "Hello Board!";
        }
        @GetMapping("/board/{board_id}")
        public String board(@PathVariable("board_id") int boardId) {
            System.out.println("boardId: " + boardId);
            return "Hello Board! - boardId: " + boardId;
        }
        @PostMapping("/board")
        public String postBoard() {
            return "Post Board!";
        }
    }
