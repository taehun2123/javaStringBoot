package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "spring!"); //키와 값 세팅
        return "hello"; //tamplates의 hello.html을 실행시켜라 (컨트롤러에서 리턴값으로 문자반환)
        // viewResolver가 화면을 처리함 `resources/templates/+{ViewName}+.html`
    }
}
