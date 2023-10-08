package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired //연관관계 연결
    public MemberService(MemberRepository memberRepository) { //디펜더지 인젝션 (DI)
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        //같은 이름이 있는 중복 회원 X
        ValidateDuplicatedMember(member); //중복된 회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    private void ValidateDuplicatedMember(Member member) {
        memberRepository.findByName(member.getName())//Optional이라는 것 안에 Member객체가 있음
            .ifPresent(member1 -> { //값이 있는 멤버에 관하여
                throw new IllegalStateException("이미 존재하는 회원입니다."); //예외 처리함
                });
    }
    /* 전체 회원조회 */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return  memberRepository.findById(memberId);
    }
}