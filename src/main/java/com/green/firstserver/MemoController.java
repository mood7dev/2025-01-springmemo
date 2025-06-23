package com.green.firstserver;

import com.green.firstserver.model.MemoPostReq;
import org.springframework.web.bind.annotation.*;

@RestController//빈(Bean) 등록, 스플이 컨테이너 객체 생성을 대리로 맡긴다. 요청/응답 담당자
    public class MemoController {
        @GetMapping("/memo")
        public String getMemo() {
            return "Hello Board!";
        }
        @GetMapping("/memo/{board_id}")
        public String getMemo(@PathVariable("board_id") int boardId) {
            System.out.println("boardId: " + boardId);
            return "Hello Board! - boardId: " + boardId;
        }
        @PostMapping("/memo")
        public String postMemo(@RequestBody MemoPostReq req) { //@RequestBody는 JSON 데이터 받을꼬얌
            System.out.println("postMemo: " + req);
            return "Post Board!";
        }
    }
