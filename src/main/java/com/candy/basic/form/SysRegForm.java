package com.candy.basic.form;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Classname SysRegForm
 * @Description 注册
 * @Author liqb
 * @Date 2021/1/3 21:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRegForm  implements Serializable {

    @NotBlank(message = "手机号不为空")
    private String mobileNo;

    @NotBlank(message = "密码不为空")
    private String password;

    @NotBlank(message = "昵称不为空")
    private String nickName;

    @NotNull(message = "性别不为空")
    private Short gender;
}
