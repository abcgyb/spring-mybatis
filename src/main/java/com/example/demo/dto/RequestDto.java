package com.example.demo.dto;

import lombok.Data;

/**
 * @author 高跃斌
 * @create 2018-01-19 16:30
 **/
@Data
public class RequestDto {

    private String bookname;

    private String manager;

    private int pageNo;

    private int pageSize;

}
