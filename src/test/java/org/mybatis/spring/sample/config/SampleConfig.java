package org.mybatis.spring.sample.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.sample.mapper.SysDeptMapper;
import org.mybatis.spring.sample.service.FooService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class SampleConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.30.128:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("jitadmin");

        SqlSessionFactoryBean ss = new SqlSessionFactoryBean();
        ss.setDataSource(dataSource);
        ClassPathResource resource = new ClassPathResource("org/mybatis/spring/sample/mapper/SysDeptMapper.xml");
        ss.setMapperLocations(resource);
        SqlSessionFactory sessionFactory = ss.getObject();
        return sessionFactory;
    }

    @Bean
    public SysDeptMapper sysDeptMapper() throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
        return sqlSessionTemplate.getMapper(SysDeptMapper.class);
    }

    @Bean
    public FooService fooService(SysDeptMapper sysDeptMapper) throws Exception {
        return new FooService(sysDeptMapper);
    }
}
