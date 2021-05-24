package com.candy.basic.service;

import com.candy.basic.common.BusinessException;
import com.candy.basic.entity.Seller;
import com.candy.basic.enums.CbMsgEnum;
import com.candy.basic.mapper.SellerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Classname SysUserService
 * @Description TODO
 * @Author liqb
 * @Date 2021/1/2 0:04
 */
@Slf4j
@Service
public class SellerService {

    @Resource
    private SellerMapper sellerMapper;

    public List<Seller> selectAll() {
        return sellerMapper.selectAll();
    }


    @Transactional(rollbackFor = Exception.class)
    public void create(Seller seller) {
        seller.setCreateDate(new Date());
        seller.setUpdateDate(new Date());
        seller.setRemakerScore(new BigDecimal(0));
        seller.setDisable((short) 0);
        sellerMapper.insert(seller);
    }

    public Seller get(Long id) {
        return sellerMapper.selectByPrimaryKey(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public Seller changeStatus(Long id, int disabledFlag) {
        Seller sellerModel = get(id);
        if(sellerModel == null){
            throw new BusinessException(CbMsgEnum.PARAMETER_VALIDATION_ERROR);
        }
        sellerModel.setDisable((short) disabledFlag);
        sellerMapper.updateByPrimaryKey(sellerModel);
        return sellerModel;
    }
}
