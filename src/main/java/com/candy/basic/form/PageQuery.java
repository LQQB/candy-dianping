package com.candy.basic.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Classname PageQuery
 * @Description TODO
 * @Author liqb
        * @Date 2021/5/24 22:32
        */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageQuery implements Serializable {

    private Integer page = 1;

    private Integer size = 20;

}
