package com.example.demo.mapper.local;

import com.example.demo.dao.entity.vue.Manager;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface ManagerMapper extends Mapper<Manager>, MySqlMapper<Manager> {
}