package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class   GetApiController {


    // GET 방법1
    // path로 지정해주어도 되고 바로 "/hello"라 적어도 된다.
    @GetMapping(path="/hello") // http://localhost:9090/api/get/hello
    public String getHello(){
        return "get Hello";
    }

    // GET 방법2
    // get / post / put / delete 모두 작동하게됨
    // 그래서 path, method를 따로 지정해주어야 함.
    @RequestMapping(path= "/hi", method = RequestMethod.GET )
    public String h1() {
        return "hi";
    }

    // http:/localhost:9090/api/get/path-variable/{name}
    // 여기서 GetMapping의 /{name} 과 @PathVariable의 변수명이랑 같아야한다.
    // 달라야하는 경우 @PathVariable(name = "name") String pathName
    // 이런식으로 선언할 수 있다.
    @GetMapping("/path-variable/{name}")
    public String pahVariable(@PathVariable String name) {
        System.out.println("PathVariable : " + name);
        return name;
    }


    // QueryParameter : 검색을할때 여러가지의 매개변수들
    // Google에 IntelliJ 검색시 나오는 parameters
    //search?q = intellij
    // &rlz = 1C5CHFA_enKR942KR942
    // &oq = intellij&aqs=chrome..69i57j69i59j0i433i512l2j0i512l2j69i60l2.1053j0j4
    // &sourceid = chrome
    // &ie = UTF-8
    // 시작엔 ? 가있고 parameter들을 &로 구분하고 =로 key value를 나타낸다.  ?key=value&key2=value2

    //http://localhost:9090/api/get/query-param?user=steve&email=sunwoo866@naver.com&age=26

    @GetMapping(path="query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+ " = " + entry.getValue() + "\n");
        });

        return sb.toString();
    }

    // 방법02
    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name+email+age;
    }

    // 방법03 현업에서 가장 많이 쓰는 방법
    // dto(package) - UserRequest에 받아올 변수 선언 및 getter / setter 생성 후
    // @RequestParam 대신 UserRequest 객체를 매개변수로 넣는다.
    @GetMapping("query-param03")
    public String queryParam02(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}
