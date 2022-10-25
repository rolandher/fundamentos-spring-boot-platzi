package com.creandoUnaApiRest.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency{

    @Override
    public void say() {
        System.out.println("Hola mundo desde mi componente");
    }
}
