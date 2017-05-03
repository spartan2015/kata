package org.spring.java.springconfig;

import org.spring.java.DefaultHelloWorld;
import org.spring.java.HelloWorld;
import org.spring.java.MessageContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App 
{
    @Bean
    public HelloWorld helloWorld(){
    	return new DefaultHelloWorld();
    }
    
    @Bean
    MessageContainer messageContainer(){
    	return new MessageContainer("Hello World!");
    }
}
