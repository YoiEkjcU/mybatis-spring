package org.mybatis.spring.sample;

import org.mybatis.spring.sample.config.SampleConfig;
import org.mybatis.spring.sample.domain.SysDept;
import org.mybatis.spring.sample.mapper.SysDeptMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SampleJavaConfigTest {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SampleConfig.class);

        SysDeptMapper sysDeptMapper = ctx.getBean(SysDeptMapper.class);
        SysDept sysDept = sysDeptMapper.getById(1297780912181121026L);
        System.out.println(sysDept);
    }
}
