package org.mybatis.spring.sample.service;

import org.mybatis.spring.sample.domain.SysDept;
import org.mybatis.spring.sample.mapper.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * FooService simply receives a userId and uses a mapper to get a record from the database.
 */
@Transactional
public class FooService {

    @Autowired
    private SysDeptMapper mapper;

    public SysDept doSomeBusinessStuff(Long id) {
        return this.mapper.getById(id);
    }
}
