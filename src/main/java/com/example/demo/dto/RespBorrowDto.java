package com.example.demo.dto;

import lombok.Data;

import java.util.List;

/**
 * @author 高跃斌
 * @create 2018-01-21 19:22
 **/
@Data
public class RespBorrowDto {
    List<BorrowDto> dtoList;
    int Total;
}
