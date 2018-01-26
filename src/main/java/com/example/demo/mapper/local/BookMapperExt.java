package com.example.demo.mapper.local;

import com.example.demo.dto.BorrowDto;
import com.example.demo.dto.RequestDto;
import com.example.demo.dto.RespBorrowDto;

import java.util.List;

/**
 * Created by gao on 2018/1/21.
 */
public interface BookMapperExt {

    List<BorrowDto> queryInfo1 (RequestDto requestDto);

    int queryTotal (RequestDto requestDto);
}
