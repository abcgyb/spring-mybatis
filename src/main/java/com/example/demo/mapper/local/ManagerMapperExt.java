package com.example.demo.mapper.local;

import com.example.demo.dto.ManagerReqDto;
import com.example.demo.dto.ManagerRespDto;

import java.util.List;

/**
 * Created by gao on 2018/1/29.
 */
public interface ManagerMapperExt {

    List<ManagerRespDto> queryManagerInfo(ManagerReqDto managerReqDto);

    int queryTotal(ManagerReqDto managerReqDto);
}
