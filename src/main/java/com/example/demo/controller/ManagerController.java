package com.example.demo.controller;

import com.example.demo.dao.entity.vue.Manager;
import com.example.demo.dto.ManagerReqDto;
import com.example.demo.dto.ManagerResp;
import com.example.demo.dto.ManagerRespDto;
import com.example.demo.mapper.local.ManagerMapper;
import com.example.demo.mapper.local.ManagerMapperExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 高跃斌
 * @description 管理人员操作部分入口代码
 * @create 2018-01-26 16:43
 **/
@Controller
@RequestMapping(value = "/managerOperate")
public class ManagerController {

    @Autowired
    private ManagerMapperExt managerMapperExt;

    @Autowired
    private ManagerMapper managerMapper;

    @RequestMapping(value = "/query")
    @ResponseBody
    ManagerResp queryManagerInfo(@RequestBody ManagerReqDto managerReqDto){
        ManagerResp managerResp= new ManagerResp();
        List<ManagerRespDto> managerRespDtos= new ArrayList<>();
        managerReqDto.setPageNo(managerReqDto.getPageSize()*(managerReqDto.getPageNo()-1));
        managerRespDtos= managerMapperExt.queryManagerInfo(managerReqDto);
        int total =managerMapperExt.queryTotal(managerReqDto);
        managerResp.setRespList(managerRespDtos);
        managerResp.setTotal(total);
        return managerResp;
    }

    @RequestMapping(value = "/queryNames")
    @ResponseBody
    List<String> queryNameList(@RequestBody ManagerReqDto managerReqDto){
        List<Manager> managers=managerMapper.selectAll();
        return managers.stream().map(manager -> manager.getName()).collect(Collectors.toList());
    }

}
