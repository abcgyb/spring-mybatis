package com.example.demo.mapper.local;

import com.example.demo.dao.entity.vue.Book;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface BookMapper extends Mapper<Book>, MySqlMapper<Book> {
}