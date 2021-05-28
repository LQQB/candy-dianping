package com.candy.basic.service;

import com.candy.basic.common.BusinessException;
import com.candy.basic.entity.Shop;
import com.candy.basic.enums.CbMsgEnum;
import com.candy.basic.form.CategoryForm;
import com.candy.basic.form.SellerForm;
import com.candy.basic.form.ShopForm;
import com.candy.basic.mapper.ShopMapper;
import com.candy.basic.utils.CBBeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Classname ShopService
 * @Description TODO
 * @Author liqb
 * @Date 2021/5/27 22:27
 */
@Slf4j
@Service
public class ShopService {

    @Resource
    private ShopMapper shopMapper;

    @Resource
    private CategoryService categoryService;

    @Resource
    private SellerService sellerService;

    public ShopForm getId(Long id) {
        Shop shop = Optional.ofNullable(shopMapper.selectByPrimaryKey(id))
                .orElseThrow(() -> new BusinessException(CbMsgEnum.NO_OBJECT_FOUND));
        ShopForm shopForm = CBBeanUtils.beanToForm(shop, ShopForm.class);

        // 品类实体
        shopForm.setCategoryForm(categoryService.getId(shopForm.getCategoryId()));

        // 商家实体
        shopForm.setSellerForm(CBBeanUtils.beanToForm(sellerService.get(shopForm.getSellerId()), SellerForm.class));
        return shopForm;
    }


    public List<ShopForm> selectAll() {
        List<Shop> shops = shopMapper.selectAll();
        List<ShopForm> shopForms = CBBeanUtils.parseBeansToForms(shops, ShopForm.class);

        shopForms.forEach(shopForm -> {
            shopForm.setCategoryForm(categoryService.getId(shopForm.getCategoryId()));
            shopForm.setSellerForm(CBBeanUtils.beanToForm(sellerService.get(shopForm.getSellerId()), SellerForm.class));
        });
        return shopForms;
    }


    @Transactional(rollbackFor = Exception.class)
    public void create(Shop shop) {
        shop.setCreateTime(new Date());
        shop.setUpdateTime(new Date());

        // 品类名是否存在
        CategoryForm category = categoryService.getId(shop.getCategoryId());
        if(category == null) {
            throw new BusinessException(CbMsgEnum.NO_OBJECT_FOUND);
        }

        // 商家是否存在
        SellerForm sellerForm = CBBeanUtils.beanToForm(sellerService.get(shop.getSellerId()), SellerForm.class);
        if(sellerForm == null) {
            throw new BusinessException(CbMsgEnum.NO_OBJECT_FOUND);
        }
        if(sellerForm.getDisable() == 0) {
            throw new BusinessException(CbMsgEnum.NO_OBJECT_FOUND);
        }

        shopMapper.insert(shop);

    }


    public Integer countShopNum() {
        return shopMapper.countShopNum();
    }
}
