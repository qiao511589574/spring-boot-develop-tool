package com.timocode.storage.entity;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "timo_user")
public class TimoUser {
    @Id
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 用户名称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * email
     */
    @Column(name = "user_email")
    private String userEmail;

    /**
     * 用户密码
     */
    @Column(name = "user_password")
    private String userPassword;

    /**
     * 用户年龄
     */
    @Column(name = "user_age")
    private Integer userAge;

    /**
     * 身高单位cm
     */
    @Column(name = "user_height")
    private BigDecimal userHeight;

    /**
     * 体重kg
     */
    @Column(name = "user_weight")
    private BigDecimal userWeight;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取用户名称
     *
     * @return user_name - 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名称
     *
     * @param userName 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取email
     *
     * @return user_email - email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * 设置email
     *
     * @param userEmail email
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    /**
     * 获取用户密码
     *
     * @return user_password - 用户密码
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 设置用户密码
     *
     * @param userPassword 用户密码
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * 获取用户年龄
     *
     * @return user_age - 用户年龄
     */
    public Integer getUserAge() {
        return userAge;
    }

    /**
     * 设置用户年龄
     *
     * @param userAge 用户年龄
     */
    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    /**
     * 获取身高单位cm
     *
     * @return user_height - 身高单位cm
     */
    public BigDecimal getUserHeight() {
        return userHeight;
    }

    /**
     * 设置身高单位cm
     *
     * @param userHeight 身高单位cm
     */
    public void setUserHeight(BigDecimal userHeight) {
        this.userHeight = userHeight;
    }

    /**
     * 获取体重kg
     *
     * @return user_weight - 体重kg
     */
    public BigDecimal getUserWeight() {
        return userWeight;
    }

    /**
     * 设置体重kg
     *
     * @param userWeight 体重kg
     */
    public void setUserWeight(BigDecimal userWeight) {
        this.userWeight = userWeight;
    }
}