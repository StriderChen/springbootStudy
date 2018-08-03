package com.chenjie.springbootwebsocket.vo;

import lombok.Data;

/**
 * @Author chenjie
 * @Date 2018/8/3 11:20
 * @Description: message 实体类
 */
@Data
public class MessageVo {

    private Integer userNum;

    private Integer type;

    private String message;

}
