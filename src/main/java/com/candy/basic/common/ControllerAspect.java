package com.candy.basic.common;

import com.candy.basic.controller.admin.AdminController;
import com.candy.basic.enums.CbMsgEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Classname ControllerAspect
 * @Description TODO
 * @Author liqb
 * @Date 2021/1/7 0:06
 */
@Aspect
@Component
public class ControllerAspect {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private HttpServletResponse httpServletResponse;


    @Around("execution(* com.candy.basic.controller.admin.*.*(..)) " +
            "&& @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object adminControllerBeforeValidation(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
        AdminPermission adminPermission = method.getAnnotation(AdminPermission.class);
        if(adminPermission == null) {
            //公共方法
            return joinPoint.proceed();
        }
        //判断当前管理员是否登录
        String email = (String) httpServletRequest.getSession().getAttribute(AdminController.CURRENT_SESSION_ADMIN);
        if(email == null){
            if(adminPermission.produceType().equals("text/html")){
                httpServletResponse.sendRedirect("/admin/admin/loginPage");
                return null;
            }else{
                return CbMessage.error(CbMsgEnum.ADMIN_SHOULD_LOGIN, "管理员需要先登录");
            }

        }else{
            return joinPoint.proceed();
        }
    }

}
