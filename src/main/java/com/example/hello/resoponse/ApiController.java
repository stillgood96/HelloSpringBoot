package com.example.hello.resoponse;

import com.example.hello.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/responseApi")
public class ApiController {

    // response를 해주는 것은 여러가지의 방법이 있다.
    // 이 중 많이쓰이는 것과 모범적인 사례를 통해 알아보자.

    // Text 를 response 해주는 방법
    @GetMapping("/text")
    public String text(@RequestParam String account) {
        return account;
    }

    // Json을 response 해주는 방법
    // 가장 많이 사용되는 방법
    // object mapper = object -> json or json -> object
    // req -> object mapper -> object -> method -> object -> object mapper -> json -> response
    @PostMapping("/json")
    public User json(@RequestBody User user) {
        return user; // 200 ok
    }


    // 응답에 대한 커스터마이징을 해야할 때는 ResponseEntity를 이용해서 작업을 한다.
    // 요청 코드도 지정을 해줄 수 있고 body에 데이터도 넣어줄 수 있기 때문에 좋다.
    // 추가적으로 헤더도 꾸며줄 수 있다고 한다. .
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user) {

        return ResponseEntity.status(HttpStatus.CREATED).body(user); // 201에 대한 요청을 하기 위해서
    }
}
