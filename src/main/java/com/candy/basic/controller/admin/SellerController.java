package com.candy.basic.controller.admin;

import com.candy.basic.common.AdminPermission;
import com.candy.basic.common.BusinessException;
import com.candy.basic.common.CbMessage;
import com.candy.basic.entity.Seller;
import com.candy.basic.enums.CbMsgEnum;
import com.candy.basic.form.PageQuery;
import com.candy.basic.form.SellerCreateForm;
import com.candy.basic.service.SellerService;
import com.candy.basic.service.SysUserService;
import com.candy.basic.utils.CBSHAUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @Classname AdminController
 * @Description 管理后台
 * @Author liqb
 * @Date 2021/1/6 23:29
 */
@Controller
public class SellerController {

    @Resource
    private SellerService sellerService;

    @AdminPermission
    @RequestMapping("/admin/seller/index")
    public ModelAndView index(PageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getPage(),pageQuery.getSize());
        List<Seller> sellerModelList = sellerService.selectAll();
        PageInfo<Seller> sellerModelPageInfo = new PageInfo<>(sellerModelList);
        ModelAndView modelAndView = new ModelAndView("/admin/seller/index.html");
        modelAndView.addObject("data",sellerModelPageInfo);
        modelAndView.addObject("CONTROLLER_NAME","seller");
        modelAndView.addObject("ACTION_NAME","index");
        return modelAndView;
    }


    @RequestMapping("/admin/seller/createpage")
    @AdminPermission
    public ModelAndView createPage(){
        ModelAndView modelAndView = new ModelAndView("/admin/seller/create.html");
        modelAndView.addObject("CONTROLLER_NAME","seller");
        modelAndView.addObject("ACTION_NAME","create");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/seller/create",method = RequestMethod.POST)
    @AdminPermission
    public String create(@Valid SellerCreateForm sellerCreateForm, BindingResult bindingResult) throws BusinessException {
        if(bindingResult.hasErrors()) {
            throw new BusinessException(CbMsgEnum.PARAMETER_VALIDATION_ERROR);
        }
        Seller seller = new Seller();
        seller.setSellerName(sellerCreateForm.getName());
        sellerService.create(seller);
        return "redirect:/admin/seller/index";


    }


    @RequestMapping(value="/admin/seller/down",method = RequestMethod.POST)
    @AdminPermission
    @ResponseBody
    public CbMessage down(@RequestParam(value="id")Long id) throws BusinessException {
        Seller seller = sellerService.changeStatus(id,0);
        return CbMessage.ok(seller);
    }

    @RequestMapping(value="/admin/seller/up",method = RequestMethod.POST)
    @AdminPermission
    @ResponseBody
    public CbMessage up(@RequestParam(value="id")Long id) throws BusinessException {
        Seller seller = sellerService.changeStatus(id,1);
        return CbMessage.ok(seller);
    }
}
