package com.example.hello;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("------------");
        System.out.println("hello");


        // Object Mappper
        // Object -> Text JSON

        // controller req json(text) -> object
        // response oject -> json(text)

        var objectMapper = new ObjectMapper();


        // object -> text
        // object mapper get method 를 활용한다.
        var user = new User("sunwoo", 15);

        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        // text -> object
        // object mapper는 default 생성자를 필요로 한다.
        // + object mapper가 참조하는 클래스의 경우 get method를 참조하기 때문에
        // 다른 메서드에 get이 존재하면 안된다.
        var objectUser = objectMapper.readValue(text, User.class);
        System.out.println(objectUser);
     }

}
