package com.candy.basic.controller.admin;

import com.candy.basic.common.AdminPermission;
import com.candy.basic.common.BusinessException;
import com.candy.basic.entity.Category;
import com.candy.basic.entity.Shop;
import com.candy.basic.enums.CbMsgEnum;
import com.candy.basic.form.CategoryCreateForm;
import com.candy.basic.form.PageQuery;
import com.candy.basic.form.ShopCreateForm;
import com.candy.basic.form.ShopForm;
import com.candy.basic.service.CategoryService;
import com.candy.basic.service.ShopService;
import com.candy.basic.utils.CBBeanUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @Classname AdminController
 * @Description 管理后台
 * @Author liqb
 * @Date 2021/1/6 23:29
 */
@Controller
public class ShopController {

    @Resource
    private ShopService shopService;

    @AdminPermission
    @RequestMapping("/admin/shop/index")
    public ModelAndView index(PageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getPage(),pageQuery.getSize());
        List<ShopForm> shopForms = shopService.selectAll();
        PageInfo<ShopForm> shopFormPageInfo = new PageInfo<>(shopForms);
        ModelAndView modelAndView = new ModelAndView("/admin/shop/index.html");
        modelAndView.addObject("data",shopFormPageInfo);
        modelAndView.addObject("CONTROLLER_NAME","shop");
        modelAndView.addObject("ACTION_NAME","index");
        return modelAndView;
    }


    @RequestMapping("/admin/shop/createpage")
    @AdminPermission
    public ModelAndView createPage(){
        ModelAndView modelAndView = new ModelAndView("/admin/shop/create.html");
        modelAndView.addObject("CONTROLLER_NAME","shop");
        modelAndView.addObject("ACTION_NAME","create");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/shop/create",method = RequestMethod.POST)
    @AdminPermission
    public String create(@Valid ShopCreateForm shopCreateForm, BindingResult bindingResult) throws BusinessException {
        if(bindingResult.hasErrors()) {
            throw new BusinessException(CbMsgEnum.PARAMETER_VALIDATION_ERROR);
        }
        Shop shop = CBBeanUtils.beanToForm(shopCreateForm, Shop.class);
        shopService.create(shop);
        return "redirect:/admin/shop/index";
    }

}
