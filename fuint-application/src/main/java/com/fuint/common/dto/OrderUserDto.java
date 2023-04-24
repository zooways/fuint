package com.fuint.common.dto;

import java.io.Serializable;

/**
 * 下单用户DTO
 *
 * Created by FSQ
 * CopyRight https://www.fuint.cn
 */
public class OrderUserDto implements Serializable {

    /**
     * 会员ID
     * */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机
     * */
    private String mobile;

    /**
     * 证件类型
     * */
    private String cardType;

    /**
     * 证件号
     * */
    private String cardNo;

    /**
     * 地址
     * */
    private String address;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCardType() {
        return cardType;
    }
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNo() {
        return cardNo;
    }
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
