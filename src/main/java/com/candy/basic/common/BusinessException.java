package com.candy.basic.common;

import com.candy.basic.enums.CbMsgEnum;

/**
 * @Classname BusinessException
 * @Description TODO
 * @Author liqb
 * @Date 2021/1/3 14:56
 */
public class BusinessException extends RuntimeException{

    private CbMsgEnum cbMsgEnum;

    public BusinessException(CbMsgEnum cbMsgEnum) {
        super();
        this.cbMsgEnum = cbMsgEnum;
    }

    public CbMsgEnum getCbMsgEnum() {
        return cbMsgEnum;
    }

    public void setCbMsgEnum(CbMsgEnum cbMsgEnum) {
        this.cbMsgEnum = cbMsgEnum;
    }
}
