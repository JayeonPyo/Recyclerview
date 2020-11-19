package com.example.recyclerview;

public class Person {
    String name;
    String mobile; //전화번호

    //생성자
    public Person(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    //클래스 내의 변수 갑을 세팅하고 리턴해주는 메소드 생성
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
