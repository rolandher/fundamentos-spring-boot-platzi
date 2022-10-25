package com.creandoUnaApiRest.component;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ComponentImplement2 implements ComponentDependency2 {

    @Override
    public void speak() {
        System.out.println("Hola mundo desde mi componente 2");
    }
}
