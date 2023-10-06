package hello.hellospring.repository;


import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원 저장
    Optional<Member> findById(Long id); //찾기 ID
    Optional<Member> findByName(String name); //찾기 이름
    List<Member> findAll(); //저장된 모든 리스트 반환

}
