package com.creandoUnaApiRest.bean;

public class MyBeanImplement implements MyBean{
    @Override
    public void print() {
        System.out.println("Hola desde mi implementación del bean");
    }
}
