package com.example.hello.di;


public class Main {

    // DI (Dependency Injection) 예제
    // IEncoder 인터페이스에는 encode 메서드가 있고 이를
    // Base64Encoder와 UrlEncoder에서 오버라이딩을 한다.
    // Encode 클래스에서는 인터페이스를 멤버변수로 갖고
    // Base64Encoder와 UrlEncoder를 매개변수로 받는 함수가 존재
    // 이 함수를 이용해서 상황에 맞는 encoder를 DI 주입받아서
    // 상황에 맞는 encoding을 하게 된다.
    public static void main(String[] args) {
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";


        // Base 64 encoding

        // url encoding
        Encoder encoder = new Encoder(new UrlEncoder());
        String result = encoder.encode(url);
        System.out.println(result);
    }
}
