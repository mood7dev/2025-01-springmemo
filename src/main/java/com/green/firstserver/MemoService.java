package com.green.firstserver;

import com.green.firstserver.model.MemoGetRes;
import com.green.firstserver.model.MemoPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //빈등록 : 대리로 객체화 해 달라고 맡김
@RequiredArgsConstructor
public class MemoService {
    //Persistence DB 작업 처리(로직 + DB작업)

    //생성자로 주입
    private final MemoMapper memoMapper;

    public int insMemo(MemoPostReq req) {
        return memoMapper.insMemo(req);
    }
    public List<MemoGetRes> selMemoList() {
        return memoMapper.selMemoList();
    }
}
