package com.candy.basic.controller;

import com.candy.basic.common.AdminPermission;
import com.candy.basic.common.BusinessException;
import com.candy.basic.common.CbMessage;
import com.candy.basic.entity.Category;
import com.candy.basic.entity.Shop;
import com.candy.basic.enums.CbMsgEnum;
import com.candy.basic.form.PageQuery;
import com.candy.basic.form.ShopCreateForm;
import com.candy.basic.form.ShopForm;
import com.candy.basic.service.CategoryService;
import com.candy.basic.service.ShopService;
import com.candy.basic.utils.CBBeanUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname AdminController
 * @Description 管理后台
 * @Author liqb
 * @Date 2021/1/6 23:29
 */
@RestController
public class SysShopController {

    @Resource
    private ShopService shopService;

    @Resource
    private CategoryService categoryService;

    /**
     * 推荐服务 1.0
     * @param longitude
     * @param latitude
     * @return
     */
    @GetMapping("/shop/recommend")
    public CbMessage recommend(@RequestParam(name="longitude") BigDecimal longitude,
                               @RequestParam(name="latitude") BigDecimal latitude) {
        if(longitude == null || latitude == null){
            throw new BusinessException(CbMsgEnum.PARAMETER_VALIDATION_ERROR);
        }
        return CbMessage.ok(shopService.recommend(longitude, latitude));
    }


    /**
     * 搜索服务 1.0
     * @param longitude
     * @param latitude
     * @return
     */
    @PostMapping("/shop/search")
    public CbMessage search(@RequestParam(name="longitude") BigDecimal longitude,
                            @RequestParam(name="latitude") BigDecimal latitude,
                            @RequestParam(name = "keyword") String keyword,
                            @RequestParam(name="orderby",required = false)Integer orderby,
                            @RequestParam(name="categoryId",required = false)Integer categoryId,
                            @RequestParam(name="tags",required = false)String tags) {
        if(StringUtils.isEmpty(keyword) || longitude == null || latitude == null){
            throw new BusinessException(CbMsgEnum.PARAMETER_VALIDATION_ERROR);
        }

        List<ShopForm> shopModelList = shopService.search(longitude,latitude,keyword,orderby,categoryId,tags);
        List<Category> categoryModelList = categoryService.selectAll();
        List<Map<String,Object>> tagsAggregation = shopService.searchGroupByTags(keyword,categoryId,tags);

        Map<String,Object> resMap = new HashMap<>();
        resMap.put("shop",shopModelList);
        resMap.put("category",categoryModelList);
        resMap.put("tags",tagsAggregation);
        return CbMessage.ok(resMap);
    }

}
