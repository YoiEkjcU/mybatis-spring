package org.mybatis.spring.sample;

import org.mybatis.spring.sample.config.SampleConfig;
import org.mybatis.spring.sample.domain.SysDept;
import org.mybatis.spring.sample.service.FooService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SampleJavaConfigTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SampleConfig.class);
        FooService fooService = ctx.getBean(FooService.class);
        SysDept sysDept = fooService.doSomeBusinessStuff(1297780912181121026L);
        System.out.println(sysDept);
    }
}