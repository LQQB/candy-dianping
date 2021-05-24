package com.candy.basic.form;

import javax.validation.constraints.NotBlank;

/**
 * @Classname SellerCreateForm
 * @Description TODO
 * @Author liqb
 * @Date 2021/5/24 22:38
 */
public class SellerCreateForm {

    @NotBlank(message = "商户名不能为空")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
