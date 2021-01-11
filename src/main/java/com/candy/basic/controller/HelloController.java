package com.candy.basic.controller;

import com.candy.basic.common.CbMessage;
import com.candy.basic.entity.SysUser;
import com.candy.basic.enums.CbMsgEnum;
import com.candy.basic.service.SysUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @Classname HelloController
 * @Description TODO
 * @Author liqb
 * @Date 2021/1/1 17:21
 */
@RestController
public class HelloController {

    @Resource
    private SysUserService sysUserService;

    @GetMapping("/hello")
    public String hello() {
        return "ddddd";
    }


    @GetMapping("/getId")
    public CbMessage getId(@RequestParam Long id) {
        return CbMessage.ok(sysUserService.getId(id));
    }


    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/index.html");
        modelAndView.addObject("name", "LQQB");
        return modelAndView;
    }

}
