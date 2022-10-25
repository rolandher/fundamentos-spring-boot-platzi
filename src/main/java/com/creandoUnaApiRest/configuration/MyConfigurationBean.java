package com.creandoUnaApiRest.configuration;


import com.creandoUnaApiRest.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class MyConfigurationBean {

    @Bean

    public MyBean beanOperation(){
        return new MyBeanImplement();
    }
    @Bean
    public MyOperation beanMyOperation(){
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency beanMyOperationWithDependency(MyOperation myOperation){
        return new MyBeanWithDependencyImplement(myOperation);
    }
    @Bean
    public MyBeanName beanMyName(){
        return new MybeanNameImplement();
    }

}
