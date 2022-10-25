package com.creandoUnaApiRest.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);
    MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("hemos ingresado al metodo WithDependency");
        int number = 1;
        LOGGER.debug("El numero enviado a la dependencia es: " + number);
        System.out.println(myOperation.suma(number));
        System.out.println("Hola desde la implementación de un bean con dependencia");


    }
}
