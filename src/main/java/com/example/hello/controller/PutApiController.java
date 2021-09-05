package com.example.hello.controller;


import com.example.hello.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiTest")
public class PutApiController {

    // 요청시 콘솔을 확인해보면 carList는 null 값이 들어가는 것을 확인할 수 있는데 이는
    // dto 클래스에서는 carList가 camel case로 작성이 되었지만
    // requestBody에 carList를 snake case인 car_list로 보냈기 때문이다.
    // 여기서 우리가 필요한 작업은 requestBody로 온 key 값을 원하는 방식으로 변경해주는 작업이 필요하다.
    // PutRequestDto에서 확인을 해보자.
    @PutMapping("/put")
    public PutRequestDto put(@RequestBody PutRequestDto prdto) {

        System.out.println(prdto);
        // 핵심!!  request에 대한 것은 잘받아왔는데 이제는 resoponse를 어떻게 내려줄 것인가 ?
        // @RestController 같은 경우에는 오브젝트 자체를 리턴시키면
        // 스프링부트 자체적으로 Object를 가지고 ObjectMapper를 통해서 Json으로 변환시켜준다고 한다.
        return prdto;

        // 요청에 담긴 바디가 그대로 응답으로 넘어오는 것을 확인할 수 있다.

    }


    // path-variable 값 받아오기
    @PutMapping("/put/{userid}")
    public PutRequestDto put (@RequestBody PutRequestDto prdto, @PathVariable Long userid) {
        System.out.println(userid);

        return prdto;
    }


}
