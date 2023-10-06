package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    //컨트롤러와 뷰 방식
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "spring!"); //키와 값 세팅
        return "hello"; //tamplates의 hello.html을 실행시켜라 (컨트롤러에서 리턴값으로 문자반환)
        // viewResolver가 화면을 처리함 `resources/templates/+{ViewName}+.html`
    }

    //MVC 방식
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    //문자값 그대로 전송하는 방식
    @GetMapping("hello-spring")
    @ResponseBody
    public String helloSpring(@RequestParam("name") String name){
        return "hello " +name; //hello spring!!
    }

    // API 방식 (JSON 형태로 전송해 줌)
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{ // Hello 클래스 API 생성
        private String name; //직접 호출 못하도록

        public String getName(){ //인스턴스의 getName임
            return name;
        }

        public void setName(String name){ //인스턴스의 setName
            this.name = name;
        }
    }
}