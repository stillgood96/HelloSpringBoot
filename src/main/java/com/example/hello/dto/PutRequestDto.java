package com.example.hello.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

// 기존에는 JsonProperty를 이용해서 따로 변환이 필요한 항목에 대해서 개별적으로 적용을 했지만
// JsonNaming을 이용하면 전체적인 항목에 일괄적용을 할 수 있다.
// 아래의 방법으로는 전체적인 항목에 대해서 SnakeCase를 적용 시킨 부분.
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PutRequestDto {

    private String name;
    private int age;
    private List<CarDto> carList;


    @Override
    public String toString() {
        return "PutPostRequestDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", carList=" + carList +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<CarDto> getCarList() {
        return carList;
    }

    public void setCarList(List<CarDto> carList) {
        this.carList = carList;
    }
}
