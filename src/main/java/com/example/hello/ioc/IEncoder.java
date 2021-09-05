package com.example.hello.ioc;


import org.springframework.stereotype.Component;


public interface IEncoder {
    String encode(String message);
}
