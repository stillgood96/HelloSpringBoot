package com.example.hello.controller;


// 스프링에는 @RestController를 통해 rest api 통신을 하는 컨트롤러도 있지만
// 그냥 @Controller도 존재한다. 이 컨트롤러는
// html 리소스 파일을 찾게된다.
import com.example.hello.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// page Controller 에서는 페이지 관련된 컨트롤러만
// api Controller 에서느 api controller만 관련되도록 분리하는 것이 좋다.
@Controller
public class PageController {

    // 단순하게 api를 만드는 서버를 만들 수 있지만
    // 페이지를 만드는 api도 만들 수 있다.
    // 그리고 이때 자료형을 String을 이용하면
    // 자동으로 리소스에 있는 해당하는 파일을 찾아주게 된다.
    @RequestMapping("/main")
    public String main() {
        return "main.html";
    }

    // 그럼 이 부분에서 json을 어떻게 내려줄 것인지 확인해보자.
    // ResponseEntity

    // Controller라는 어노테이션은 String을 리턴하게되면 리소스를 찾게 되지만
    // ResponseBody라는 어노테이션을 사용하면 리소스를 찾지 않고 ResponseBody를 만들어서 내려주게 된다.
    @ResponseBody
    @GetMapping("/user")
    public User user() {
        var user = new User(); // Java 11부터 추가된 타입추론 ver
        user.setName("steve");
        user.setAddress("패스트 캠퍼스");
        return user;
    }
}
