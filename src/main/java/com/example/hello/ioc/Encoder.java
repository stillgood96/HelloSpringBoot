package com.example.hello.ioc;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Encoder {
    private IEncoder iEncoder;

    public Encoder(@Qualifier("base64Encoder") IEncoder iEncoder) {
       //  this.iEncoder = new Base64Encoder();
        this.iEncoder = iEncoder;
    }

    public void setIEncoder(IEncoder iencoder) {
        this.iEncoder = iencoder;
    }


    public String encode(String message) {
        return iEncoder.encode(message);
    }
}
