package com.example.hello;

import com.example.hello.ioc.Base64Encoder;
import com.example.hello.ioc.Encoder;
import com.example.hello.ioc.UrlEncoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class HelloApplication {
    // IoC 예제
    // @Component 어노테이션을 이용해서 명시하고 스프링에게 객체 (bean)을 생성하도록 제어를 넘겨준다.
    //  그리고 이렇게 생성된 bean들을 유연하게 넘겨주기 위해 ApplicationContextProvider를 생성해서
    // ApplicationContext 멤버변수에 set 해주고 return 해주는 메서드를 생성한다

    public static void main(String[] args) {


        SpringApplication.run(HelloApplication.class, args);

        // context 객체에 빈 context 객체를 할당
        ApplicationContext context = ApplicationContextProvider.getContext();

        // Base64Encoder / urlEncoder 클래스의 객체를 bean을 주입받는다.
        // 이 때 new 생성자를 이용하지 않고 객체를 관리하는 점을 알 수 있다.
//        Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
//        UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);

        // 생성된 bean을 encoder에 넘겨준다.
        // 이 때는 new 생성자를 이용해서 이용했지만 이또한 사용을 안하려면 Encoder 또한 @Component로 관리해주면 된다.
        // 그리고 주입받는 bean이 무엇인지 @Qualifier를 통해 지정해주어야 한다.
//        Encoder encoder = context.getBean(Encoder.class);
        Encoder encoder = context.getBean("base74Encode", Encoder.class);

        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";
        String result = encoder.encode(url);
        System.out.println(result);

//        encoder.setIEncoder(urlEncoder);
//        result = encoder.encode(url);
//        System.out.println(result);



    }


    // 두개의 인코드를 쓰고 싶을때 사용하는 방법
    // 미리 빈을 등록해놓는 것.
    @Configuration
    class AppConfig {

        @Bean("base74Encode")
        public Encoder encoder(Base64Encoder base64Encoder) {
            return new Encoder(base64Encoder);
        }

        @Bean("urlEncode")
        public Encoder encoder(UrlEncoder urlEncoder) {
            return new Encoder(urlEncoder);
        }



    }

}
