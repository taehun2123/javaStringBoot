package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){ //독립적 테스트 실행을 위해 한 메소드 테스트 시작 전 각각의 인스턴스 생성
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository); //같은 MemberRespository 사용
    }

    @AfterEach //아래 메소드가 끝나고 동작하는 콜백 메소드
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void join() { //테스트코드는 한글로 이름 작성해도 무관.
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member); //long과 Long은 다름 - long = 일반 데이터 기본 타입 / Long = 데이터 타입 포장형 객체 클래스
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복회원예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        try {
//            memberService.join(member2);
//            fail("이미 중복하는 회원입니다.");
//        } catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재함");
//        }

        //then
    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}