package com.example.demo.controller;

import com.example.demo.dao.entity.vue.Book;
import com.example.demo.dto.BorrowDto;
import com.example.demo.dto.RequestDto;
import com.example.demo.dto.RespBorrowDto;
import com.example.demo.mapper.local.BookMapper;
import com.example.demo.mapper.local.BookMapperExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 高跃斌
 * @create 2017-09-01 9:14
 **/
@Controller
@RequestMapping("/bookOperate")
public class BookController {
    @Autowired
    private BookMapperExt bookMapperExt;
    @Autowired
    private BookMapper bookMapper;

    /**
     * 查询书籍列表
     * @param requestDto
     * @return
     */
    @RequestMapping(value = "/queryInfo")
    @ResponseBody
    public RespBorrowDto queryInfo(@RequestBody RequestDto requestDto){
        List<BorrowDto> resList=new ArrayList<>();
        //取出分页数据
        requestDto.setPageNo(requestDto.getPageSize()*(requestDto.getPageNo()-1));
        resList= bookMapperExt.queryInfo1(requestDto);
        //如果条件不为空，则查询时清空
        int size=bookMapperExt.queryTotal(requestDto);
        RespBorrowDto respBorrowDto=new RespBorrowDto();
        respBorrowDto.setDtoList(resList);
        respBorrowDto.setTotal(size);
        return respBorrowDto;
    }

    /**
     * 新增书籍信息
     * @param borrowDto
     * @return
     */
    @RequestMapping(value = "/insertBook")
    @ResponseBody
    public int insertBookInfo(@RequestBody BorrowDto borrowDto){
        Book book=new Book();
        book.setName(borrowDto.getName());
        book.setChargeperson(borrowDto.getChargePerson());
        return bookMapper.insert(book);
    }

    /**
     * 修改书籍信息
     * @param borrowDto
     * @return
     */
    @RequestMapping(value = "/updateBook")
    @ResponseBody
    public int updateBookInfo(@RequestBody BorrowDto borrowDto){
        Book book=new Book();
        book.setName(borrowDto.getName());
        book.setChargeperson(borrowDto.getChargePerson());
        book.setId(borrowDto.getBookId());
        return bookMapper.updateByPrimaryKeySelective(book);
    }

    /**
     * 删除书籍信息
     * @param borrowDto
     * @return
     */
    @RequestMapping(value = "/deleteBook")
    @ResponseBody
    public int deleteBookInfo(@RequestBody BorrowDto borrowDto){
        Book book=new Book();
        book.setId(borrowDto.getBookId());
        return bookMapper.delete(book);
    }

    /**
     * 批量删除
     * @param borrowDto
     * @return
     */
    @RequestMapping(value = "/amountDeleteBook")
    @ResponseBody
    public int amountDeleteBook(@RequestBody BorrowDto borrowDto){
        Book book=new Book();
        //return bookMapper.delete(book);
        return 1;
    }

}
