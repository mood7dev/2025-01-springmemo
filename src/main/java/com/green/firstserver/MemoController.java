package com.green.firstserver;

import com.green.firstserver.model.MemoGetOneRes;
import com.green.firstserver.model.MemoGetRes;
import com.green.firstserver.model.MemoPostReq;
import com.green.firstserver.model.MemoPutReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//빈(Bean) 등록, 스플이 컨테이너 객체 생성을 대리로 맡긴다. 요청/응답 담당자
@RequiredArgsConstructor
//롬북 : final이거나 @NonNull이 붙은 필드만 포함, 생성자가 하나만  필요할 때 유용
public class MemoController {

    private final MemoService memoService;

    //DI 받는 방법 3가지
    //1. 필드 주입
    //2. setter 주입(메소드 주입)
    //3. 생성자 주입

    @GetMapping("/memo")
    public List<MemoGetRes> getMemo() {
        return memoService.selMemoList();
    }

    @GetMapping("/memo/{id}")
    public MemoGetOneRes getMemo(@PathVariable int id) {
        System.out.println("getMemo: " + id);
        return memoService.selMemo(id);
    }

    @PostMapping("/memo")
    public String postMemo(@RequestBody MemoPostReq req) { //@RequestBody는 JSON 데이터 받을꼬얌
        System.out.println("postMemo: " + req);
        int result = memoService.insMemo(req);
        return result == 1 ? "성공" : "실패";
    }

    @PutMapping("/memo/{id}")
    public String putMemo(@PathVariable int id, @RequestBody MemoPutReq req) {
        System.out.println("putMemo: " + req);
        req.setId(id);
        int result = memoService.updMemo(req);
        return result == 1 ? "성공" : "실패";
    }

    @DeleteMapping("/memo/{id}")
    public String deleteMemo(@PathVariable int id) {
        System.out.println("deleteMemo: " + id);
        int result = memoService.delMemo(id);
        return result == 1 ? "성공" : "실패";
    }
}
