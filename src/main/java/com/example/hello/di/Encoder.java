package com.example.hello.di;

public class Encoder {
    private IEncoder iEncoder;

    public Encoder(IEncoder iEncoder) {
       //  this.iEncoder = new Base64Encoder();
        this.iEncoder = iEncoder;
    }


    public String encode(String message) {
        return iEncoder.encode(message);
    }
}
