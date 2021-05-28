package com.candy.basic.controller.admin;

import com.candy.basic.common.AdminPermission;
import com.candy.basic.common.BusinessException;
import com.candy.basic.common.CbMessage;
import com.candy.basic.entity.Category;
import com.candy.basic.entity.Seller;
import com.candy.basic.enums.CbMsgEnum;
import com.candy.basic.form.CategoryCreateForm;
import com.candy.basic.form.PageQuery;
import com.candy.basic.form.SellerCreateForm;
import com.candy.basic.service.CategoryService;
import com.candy.basic.service.SellerService;
import com.candy.basic.utils.CBBeanUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @AdminPermission
    @RequestMapping("/admin/category/index")
    public ModelAndView index(PageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getPage(),pageQuery.getSize());
        List<Category> categories = categoryService.selectAll();
        PageInfo<Category> categoryPageInfo = new PageInfo<>(categories);
        ModelAndView modelAndView = new ModelAndView("/admin/category/index.html");
        modelAndView.addObject("data",categoryPageInfo);
        modelAndView.addObject("CONTROLLER_NAME","category");
        modelAndView.addObject("ACTION_NAME","index");
        return modelAndView;
    }


    @RequestMapping("/admin/category/createpage")
    @AdminPermission
    public ModelAndView createPage(){
        ModelAndView modelAndView = new ModelAndView("/admin/category/create.html");
        modelAndView.addObject("CONTROLLER_NAME","category");
        modelAndView.addObject("ACTION_NAME","create");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/category/create",method = RequestMethod.POST)
    @AdminPermission
    public String create(@Valid CategoryCreateForm categoryCreateForm, BindingResult bindingResult) throws BusinessException {
        if(bindingResult.hasErrors()) {
            throw new BusinessException(CbMsgEnum.PARAMETER_VALIDATION_ERROR);
        }
        Category category = CBBeanUtils.beanToForm(categoryCreateForm, Category.class);
        categoryService.create(category);
        return "redirect:/admin/category/index";
    }

}
