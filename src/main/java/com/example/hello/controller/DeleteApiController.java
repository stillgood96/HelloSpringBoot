package com.example.hello.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiTest02")
public class DeleteApiController {

    @DeleteMapping("/delete/{userid}")
    public void delete(@PathVariable String userid , @RequestParam String account) {

        System.out.println(userid);
        System.out.println(account);


        // delete -> 리소스 삭제 200 ok
        // 리소스가 있든 없든 삭제후 200이 리턴이 된다 .
    }
}
