package com.candy.basic.controller;

import com.candy.basic.common.CbMessage;
import com.candy.basic.entity.Category;
import com.candy.basic.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("/category")
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ResponseBody
    @RequestMapping("/list")
    public CbMessage list(){
        List<Category> categoryModelList = categoryService.selectAll();
        return CbMessage.ok(categoryModelList);
    }

}
