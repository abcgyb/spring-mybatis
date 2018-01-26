package com.example.demo.dao.entity.vue;

import java.util.Date;
import javax.persistence.*;

@Table(name = "book")
public class Book {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 书名
     */
    private String name;

    /**
     * 管理者
     */
    @Column(name = "chargePerson")
    private String chargeperson;

    @Column(name = "borrowTime")
    private Date borrowtime;

    @Column(name = "returnTime")
    private Date returntime;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取书名
     *
     * @return name - 书名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置书名
     *
     * @param name 书名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取管理者
     *
     * @return chargePerson - 管理者
     */
    public String getChargeperson() {
        return chargeperson;
    }

    /**
     * 设置管理者
     *
     * @param chargeperson 管理者
     */
    public void setChargeperson(String chargeperson) {
        this.chargeperson = chargeperson;
    }

    /**
     * @return borrowTime
     */
    public Date getBorrowtime() {
        return borrowtime;
    }

    /**
     * @param borrowtime
     */
    public void setBorrowtime(Date borrowtime) {
        this.borrowtime = borrowtime;
    }

    /**
     * @return returnTime
     */
    public Date getReturntime() {
        return returntime;
    }

    /**
     * @param returntime
     */
    public void setReturntime(Date returntime) {
        this.returntime = returntime;
    }
}