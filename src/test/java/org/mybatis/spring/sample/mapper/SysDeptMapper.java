package org.mybatis.spring.sample.mapper;

import org.mybatis.spring.sample.domain.SysDept;

public interface SysDeptMapper {

    SysDept getById(Long id);
}