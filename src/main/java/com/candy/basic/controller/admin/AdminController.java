package com.candy.basic.controller.admin;

import com.candy.basic.common.AdminPermission;
import com.candy.basic.common.BusinessException;
import com.candy.basic.enums.CbMsgEnum;
import com.candy.basic.utils.CBSHAUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Classname AdminController
 * @Description 管理后台
 * @Author liqb
 * @Date 2021/1/6 23:29
 */
@Controller
public class AdminController {

    @Value("${admin.email}")
    private String email;

    @Value("${admin.adminPassword}")
    private String adminPassword;

    @Resource
    private HttpServletRequest httpServletRequest;

    public final static String CURRENT_SESSION_ADMIN = "current_session_admin";


    @AdminPermission
    @RequestMapping("/admin/admin/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/admin/admin/index");
        return modelAndView;
    }

    @RequestMapping("/admin/admin/loginPage")
    public ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView("/admin/admin/login");
        return modelAndView;
    }


    @RequestMapping("/admin/admin/login")
    public String login(String email, String password) {
        if(StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
            throw new BusinessException(CbMsgEnum.PARAMETER_VALIDATION_ERROR);
        }
        if(email.equals(this.email) && CBSHAUtils.getSHA256StrJava(password).equals(adminPassword)) {
            httpServletRequest.getSession().setAttribute(CURRENT_SESSION_ADMIN, email);
            return "redirect:/admin/admin/index";
        } else {
            throw new BusinessException(CbMsgEnum.LOGIN_FAIL);
        }
    }
}
