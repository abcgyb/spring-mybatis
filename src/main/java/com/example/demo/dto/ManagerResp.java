package com.example.demo.dto;

import lombok.Data;

import java.util.List;

/**
 * @author 高跃斌
 * @description
 * @create 2018-01-30 16:30
 **/
@Data
public class ManagerResp {
    private int total;
    private List<ManagerRespDto> respList;
}
