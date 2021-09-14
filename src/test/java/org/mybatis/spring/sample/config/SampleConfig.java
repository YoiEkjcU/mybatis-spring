package org.mybatis.spring.sample.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.sample.service.FooService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@MapperScan(basePackages = "org.mybatis.spring.sample.mapper")
public class SampleConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.30.128:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("jitadmin");

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("org/mybatis/spring/sample/mapper/SysDeptMapper.xml"));
        SqlSessionFactory sessionFactory = sqlSessionFactoryBean.getObject();
        return sessionFactory;
    }

    @Bean
    public FooService fooService() throws Exception {
        return new FooService();
    }
}
