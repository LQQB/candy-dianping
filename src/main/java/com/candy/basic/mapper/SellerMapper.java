package com.candy.basic.mapper;

import com.candy.basic.entity.Seller;
import java.util.List;

public interface SellerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seller
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long sellerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seller
     *
     * @mbggenerated
     */
    int insert(Seller record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seller
     *
     * @mbggenerated
     */
    Seller selectByPrimaryKey(Long sellerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seller
     *
     * @mbggenerated
     */
    List<Seller> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seller
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Seller record);

    Integer countSellerNum();
}
