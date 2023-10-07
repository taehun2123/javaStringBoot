package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

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

    public Optional<Member> findOne(long memberId){
        return  memberRepository.findById(memberId);
    }
}