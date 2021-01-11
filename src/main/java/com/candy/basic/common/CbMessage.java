package com.candy.basic.common;

/**
 * @Classname 消息实体
 * @Description TODO
 * @Author liqb
 * @Date 2021/1/3 14:08
 */

import com.candy.basic.enums.CbMsgEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回对象实体
 * @param <T>
 */
@Data
@NoArgsConstructor
public class CbMessage<T> {

    private Integer code;

    private String msg;

    private T data;

    CbMessage(CbMsgEnum msgEnum, T data) {
        this.code = msgEnum.getCode();
        this.msg = msgEnum.getMsg();
        this.data = data;
    }

    public CbMessage(CbMsgEnum msgEnum) {
        this.code = msgEnum.getCode();
        this.msg = msgEnum.getMsg();
    }


    /**
     * 成功
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CbMessage ok(T data) {
        return new CbMessage(CbMsgEnum.SUCCESS, data);
    }


    /**
     * 失败
     * @param msgEnum
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CbMessage error(CbMsgEnum msgEnum, T data) {
        return new CbMessage(msgEnum, data);
    }


}
