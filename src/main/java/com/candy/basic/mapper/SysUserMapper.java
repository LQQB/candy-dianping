package com.candy.basic.mapper;

import com.candy.basic.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sysuser
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sysuser
     *
     * @mbggenerated
     */
    int insert(SysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sysuser
     *
     * @mbggenerated
     */
    SysUser selectByPrimaryKey(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sysuser
     *
     * @mbggenerated
     */
    List<SysUser> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sysuser
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysUser record);


    SysUser findUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}