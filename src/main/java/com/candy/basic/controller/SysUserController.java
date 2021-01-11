package com.candy.basic.controller;

import com.candy.basic.common.CbMessage;
import com.candy.basic.entity.SysUser;
import com.candy.basic.form.SysLoginForm;
import com.candy.basic.form.SysRegForm;
import com.candy.basic.form.SysUserForm;
import com.candy.basic.service.SysUserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Classname SysUserController
 * @Description TODO
 * @Author liqb
 * @Date 2021/1/3 22:07
 */
@RestController
public class SysUserController {

    @Resource
    private SysUserService sysUserService;
    @Resource
    private HttpServletRequest httpServletRequest;

    public final static String CURRENT_SESSION_USER = "current_session_user";

    /**
     * 注册
     * @param sysRegForm
     * @return
     */
    @PostMapping("/user/register")
    public CbMessage register(@Validated @RequestBody SysRegForm sysRegForm ) {
        sysUserService.register(sysRegForm);
        return CbMessage.ok(null);
    }



    /**
     * 登录
     * @param sysLoginForm
     * @return
     */
    @PostMapping("/user/login")
    public CbMessage login(@Validated @RequestBody SysLoginForm sysLoginForm) {
        SysUserForm sysUserForm = sysUserService.login(sysLoginForm.getMobileNo(), sysLoginForm.getPassword());
        httpServletRequest.getSession().setAttribute(CURRENT_SESSION_USER, sysUserForm);
        return CbMessage.ok(sysUserForm);
    }


    /**
     * 注銷
     * @param
     * @return
     */
    @PostMapping("/user/logout")
    public CbMessage logout() {
        httpServletRequest.getSession().invalidate();
        return CbMessage.ok(null);
    }


    /**
     * 获取个人信息
     * @return
     */
    @PostMapping("/user/getCurrentUser")
    public CbMessage getCurrentUser() {
        SysUserForm  sysUserForm = (SysUserForm) httpServletRequest.getSession().getAttribute(CURRENT_SESSION_USER);
        return CbMessage.ok(sysUserForm);
    }

}
