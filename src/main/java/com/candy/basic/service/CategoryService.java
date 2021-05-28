package com.candy.basic.service;

import com.candy.basic.common.BusinessException;
import com.candy.basic.entity.Category;
import com.candy.basic.entity.Seller;
import com.candy.basic.enums.CbMsgEnum;
import com.candy.basic.form.CategoryForm;
import com.candy.basic.mapper.CategoryMapper;
import com.candy.basic.utils.CBBeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Classname SysUserService
 * @Description TODO
 * @Author liqb
 * @Date 2021/1/2 0:04
 */
@Slf4j
@Service
public class CategoryService {

    @Resource
    private CategoryMapper categoryMapper;



    public CategoryForm getId(Long id) {
        Category category = Optional.ofNullable(categoryMapper.selectByPrimaryKey(id))
                .orElseThrow(() -> new BusinessException(CbMsgEnum.NO_OBJECT_FOUND));
        return CBBeanUtils.beanToForm(category, CategoryForm.class);
    }


    public List<Category> selectAll() {
        return categoryMapper.selectAll();
    }


    @Transactional(rollbackFor = Exception.class)
    public void create(Category category) {
        category.setCreateTime(new Date());
        category.setUpdateTime(new Date());
        try {
            categoryMapper.insert(category);
        } catch (DuplicateKeyException e) {
            log.error("保存错误:", e);
            throw new BusinessException(CbMsgEnum.CATEGORY_NAME_DUPLICATED);
        }
    }

    public Integer countCategoryNum() {
        return categoryMapper.countCategoryNum();
    }
}
