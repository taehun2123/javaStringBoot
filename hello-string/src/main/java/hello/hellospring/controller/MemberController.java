package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired //디펜던시 인젝션 - 의존관계를 주입해 줌.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
