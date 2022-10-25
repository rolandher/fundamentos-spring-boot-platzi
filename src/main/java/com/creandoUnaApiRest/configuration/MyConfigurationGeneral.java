package com.creandoUnaApiRest.configuration;

import com.creandoUnaApiRest.bean.MyBeanWithProperties;
import com.creandoUnaApiRest.bean.MyBeanWithPropertiesImplement;
import com.creandoUnaApiRest.pogo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(UserPojo.class)
public class MyConfigurationGeneral {
        @Value("Rolando")

        private String name;

        @Value("Hernandez")

        private String lastname;

        @Value("${value.random}")
        private String random;

        @Value("${jdbc.url}")
        private String jdbcUrl;
        @Value("${driver}")
        private String driver;
        @Value("${username}")
        private String userName;
        @Value("${password}")
        private String password;

        @Bean
        public MyBeanWithProperties function(){
            return new MyBeanWithPropertiesImplement(name, lastname);
        }

        @Bean
        public DataSource dataSource() {
                DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
                dataSourceBuilder.driverClassName(driver);
                dataSourceBuilder.url(jdbcUrl);
                dataSourceBuilder.username(userName);
                dataSourceBuilder.password(password);
                return dataSourceBuilder.build();
        }
}
