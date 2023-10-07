package hello.hellospring.repository;


import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional; // 값이 존재할 수도 있고 존재하지 않을 수도 있는 상황을 나타내는 컨테이너 객체
//null 관련 예외를 방지하고 코드를 안전하게 만듬.

public interface MemberRepository {
    Member save(Member member); //회원 저장
    Optional<Member> findById(Long id); //찾기 ID (Null 예외처리를 위한 Optional 클래스 삽입
    Optional<Member> findByName(String name); //찾기 이름 (Null 예외처리를 위한 Optional 클래스 삽입
    List<Member> findAll(); //저장된 모든 리스트 반환

}
