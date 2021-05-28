package com.candy.basic.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Shop implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.shop_id
     *
     * @mbggenerated
     */
    private Long shopId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.shop_name
     *
     * @mbggenerated
     */
    private String shopName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.remaker_score
     *
     * @mbggenerated
     */
    private BigDecimal remakerScore;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.price_par_man
     *
     * @mbggenerated
     */
    private Integer priceParMan;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.latitude
     *
     * @mbggenerated
     */
    private BigDecimal latitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.longitude
     *
     * @mbggenerated
     */
    private BigDecimal longitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.category_id
     *
     * @mbggenerated
     */
    private Long categoryId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.tags
     *
     * @mbggenerated
     */
    private String tags;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.start_time
     *
     * @mbggenerated
     */
    private String startTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.end_time
     *
     * @mbggenerated
     */
    private String endTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.address
     *
     * @mbggenerated
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.seller_id
     *
     * @mbggenerated
     */
    private Long sellerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.icon_url
     *
     * @mbggenerated
     */
    private String iconUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table shop
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.shop_id
     *
     * @return the value of shop.shop_id
     *
     * @mbggenerated
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.shop_id
     *
     * @param shopId the value for shop.shop_id
     *
     * @mbggenerated
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.create_time
     *
     * @return the value of shop.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.create_time
     *
     * @param createTime the value for shop.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.update_time
     *
     * @return the value of shop.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.update_time
     *
     * @param updateTime the value for shop.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.shop_name
     *
     * @return the value of shop.shop_name
     *
     * @mbggenerated
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.shop_name
     *
     * @param shopName the value for shop.shop_name
     *
     * @mbggenerated
     */
    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.remaker_score
     *
     * @return the value of shop.remaker_score
     *
     * @mbggenerated
     */
    public BigDecimal getRemakerScore() {
        return remakerScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.remaker_score
     *
     * @param remakerScore the value for shop.remaker_score
     *
     * @mbggenerated
     */
    public void setRemakerScore(BigDecimal remakerScore) {
        this.remakerScore = remakerScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.price_par_man
     *
     * @return the value of shop.price_par_man
     *
     * @mbggenerated
     */
    public Integer getPriceParMan() {
        return priceParMan;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.price_par_man
     *
     * @param priceParMan the value for shop.price_par_man
     *
     * @mbggenerated
     */
    public void setPriceParMan(Integer priceParMan) {
        this.priceParMan = priceParMan;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.latitude
     *
     * @return the value of shop.latitude
     *
     * @mbggenerated
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.latitude
     *
     * @param latitude the value for shop.latitude
     *
     * @mbggenerated
     */
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.longitude
     *
     * @return the value of shop.longitude
     *
     * @mbggenerated
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.longitude
     *
     * @param longitude the value for shop.longitude
     *
     * @mbggenerated
     */
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.category_id
     *
     * @return the value of shop.category_id
     *
     * @mbggenerated
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.category_id
     *
     * @param categoryId the value for shop.category_id
     *
     * @mbggenerated
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.tags
     *
     * @return the value of shop.tags
     *
     * @mbggenerated
     */
    public String getTags() {
        return tags;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.tags
     *
     * @param tags the value for shop.tags
     *
     * @mbggenerated
     */
    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.start_time
     *
     * @return the value of shop.start_time
     *
     * @mbggenerated
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.start_time
     *
     * @param startTime the value for shop.start_time
     *
     * @mbggenerated
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.end_time
     *
     * @return the value of shop.end_time
     *
     * @mbggenerated
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.end_time
     *
     * @param endTime the value for shop.end_time
     *
     * @mbggenerated
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.address
     *
     * @return the value of shop.address
     *
     * @mbggenerated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.address
     *
     * @param address the value for shop.address
     *
     * @mbggenerated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.seller_id
     *
     * @return the value of shop.seller_id
     *
     * @mbggenerated
     */
    public Long getSellerId() {
        return sellerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.seller_id
     *
     * @param sellerId the value for shop.seller_id
     *
     * @mbggenerated
     */
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.icon_url
     *
     * @return the value of shop.icon_url
     *
     * @mbggenerated
     */
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.icon_url
     *
     * @param iconUrl the value for shop.icon_url
     *
     * @mbggenerated
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", shopId=").append(shopId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", shopName=").append(shopName);
        sb.append(", remakerScore=").append(remakerScore);
        sb.append(", priceParMan=").append(priceParMan);
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", tags=").append(tags);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", address=").append(address);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", iconUrl=").append(iconUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}