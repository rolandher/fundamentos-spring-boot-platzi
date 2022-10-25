package com.creandoUnaApiRest.bean;

public class MybeanNameImplement implements MyBeanName{
    @Override
    public String name() {
        System.out.println("EL nombre es rolando");
        return name();
    }
}
