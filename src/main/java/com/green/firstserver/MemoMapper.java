package com.green.firstserver;

import com.green.firstserver.model.MemoGetOneRes;
import com.green.firstserver.model.MemoGetRes;
import com.green.firstserver.model.MemoPostReq;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
//인터페이스가 implements한 클래스가 만들어지고 
// 그 클래스를 객체화(주소값) 주소값을 스프링 컨테이너가 들고 있음.
// 스프링 컨테이너가 객체 주소값을 들고 있을 수 있는 건 빈등록이 되었기 때문

@Mapper
public interface MemoMapper {
    //insert, update, delete는 return 타입 int
    // insert 메서드, 요청 DTO를 받아서 int 반환 (삽입된 행 수)
    int insMemo(MemoPostReq req);   // 메모 저장
    List<MemoGetRes> selMemoList(); // 메모 목록 조회
    MemoGetOneRes selMemo(int id);  // 단일 메모 조회
}

/*
연동 흐름 요약
클라이언트 → Controller: POST /memo + JSON 바디(MemoPostReq)
Controller → Service: insMemo 호출
Service → Mapper: insMemo 호출
Mapper → DB: SQL 실행(INSERT)
DB → Mapper → Service → Controller → 클라이언트: 처리 결과 반환
*/