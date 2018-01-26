package com.example.demo.controller;

import com.example.demo.dao.entity.vue.Manager;
import com.example.demo.dto.ManagerReqDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 高跃斌
 * @description 管理人员操作部分入口代码
 * @create 2018-01-26 16:43
 **/
@Controller
@RequestMapping(value = "/managerOperate")
public class ManagerController {

    @RequestMapping(value = "/query")
    @ResponseBody
    List<Manager> queryManagerInfo(ManagerReqDto managerReqDto){
        return null;
    }
}
