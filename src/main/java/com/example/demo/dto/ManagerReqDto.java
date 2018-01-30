package com.example.demo.dto;

import lombok.Data;

/**
 * @author 高跃斌
 * @description 管理人员请求入参
 * @create 2018-01-26 16:47
 **/
@Data
public class ManagerReqDto {

    private String name;

    private int sex;

    private int age;

    private int pageNo;

    private int pageSize;

}
