package com.candy.basic.service;

import com.candy.basic.common.BusinessException;
import com.candy.basic.common.CbMessage;
import com.candy.basic.entity.SysUser;
import com.candy.basic.enums.CbMsgEnum;
import com.candy.basic.form.SysRegForm;
import com.candy.basic.form.SysUserForm;
import com.candy.basic.mapper.SysUserMapper;
import com.candy.basic.utils.CBBeanUtils;
import com.candy.basic.utils.CBSHAUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Optional;

/**
 * @Classname SysUserService
 * @Description TODO
 * @Author liqb
 * @Date 2021/1/2 0:04
 */
@Slf4j
@Service
public class SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;



    public SysUserForm getId(Long id) {
        SysUser sysUser = Optional.ofNullable(sysUserMapper.selectByPrimaryKey(id))
                .orElseThrow(() -> new BusinessException(CbMsgEnum.NO_OBJECT_FOUND));
        return CBBeanUtils.beanToForm(sysUser, SysUserForm.class);
    }


    /**
     * 注册
     * @param sysRegForm
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public void register(SysRegForm sysRegForm) {
        SysUser sysUser = CBBeanUtils.beanToForm(sysRegForm, SysUser.class);
        sysUser.setCreateDate(new Date());
        sysUser.setUpdateDate(new Date());
        // sha 256 加密
        sysUser.setPassword(CBSHAUtils.getSHA256StrJava(sysUser.getPassword()));
        try {
            sysUserMapper.insert(sysUser);
        } catch (DuplicateKeyException e) {
            throw new BusinessException(CbMsgEnum.REGISTER_DUP_FAIL);
        }

    }

    /**
     * 登录
     * @param username
     * @param password
     */
    public SysUserForm login(String username, String password) {
        SysUser sysUser = sysUserMapper.findUsernameAndPassword(username, CBSHAUtils.getSHA256StrJava(password));
        if(sysUser == null) {
            throw new BusinessException(CbMsgEnum.LOGIN_FAIL);
        }
        return CBBeanUtils.beanToForm(sysUser, SysUserForm.class);
    }

}
