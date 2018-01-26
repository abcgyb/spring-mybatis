package com.example.demo.dto;

import lombok.Data;

/**
 * 测试dto
 *
 * @author 高跃斌
 * @create 2018-01-19 11:06
 **/
@Data
public class BorrowDto {

    private long bookId;

    private String name;

    private String chargePerson;

    private String borrowTime;

    private String returnTime;

    private String  bookIds;//批量删除
}
