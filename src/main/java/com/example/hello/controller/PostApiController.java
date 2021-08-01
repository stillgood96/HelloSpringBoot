package com.example.hello.controller;


import com.example.hello.dto.PostRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {


    @PostMapping("/post") // Get에서는 @RequestParam Post에서는 @RequestBody
    public void post(@RequestBody Map<String, Object> requestData) {
        //방법1
        requestData.entrySet().forEach(s -> {
            System.out.println("key => " +s.getKey() );
            System.out.println("value => " +s.getValue() );
        });

        //방법2
//        requestData.forEach((key, value) -> {
//            System.out.println("key => " + key);
//            System.out.println("value => " + value);
//        });

    }

    // 하지만 매번 Map으로 받아서 코딩하기에는 역부족 이 역시 dto를 생성해서 진행할 수 있도록 한다.
    @PostMapping("/post02")
    public void post02(@RequestBody PostRequestDto dto) {
        System.out.println(dto.toString());
//        잘나오는걸 확인할 수 있다
//        추후 데이터를 가져올때 dto.get 메서드를 이용해서 값을 이용할 수 있다.

        // 추가로 dto 클래스에 phoneNumber를 추가하고
        // json에는 phone_number로 POST 하게 되면 null 값이 들어가는걸 알 수 있다.
        // 이때 camel 표기법과 snake표기법을 매칭해주는 여러가지 방법이 있는데
        // dto클래스 내부 멤버변수에 @JsonPropertiy("phone_number") 어노테이션을 추가해주는 것.

    }
}
