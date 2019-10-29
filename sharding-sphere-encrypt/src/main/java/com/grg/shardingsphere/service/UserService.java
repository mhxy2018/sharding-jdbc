package com.grg.shardingsphere.service;


/**
 * UserService
 *
 * @author Lee
 * @version v1.0
 * @date 2019-10-24 10:05:32
 */
public interface UserService {

    /**
     * 新增用户
     *
     * @param userId        用户id
     * @param userNamePlain 用户姓名
     * @param userName      密文列
     * @param userType      用户类型
     * @param pwd           密文列
     * @return 执行条数
     */
    int insertUser(Long userId, String userNamePlain, String userName, String userType, String pwd);

    /**
     * 新增用户
     *
     * @param userId        用户id
     * @param userNamePlain 用户姓名
     * @param userName      密文列
     * @param userType      用户类型
     * @param pwd           密文列
     * @return 执行条数
     */
    int insertUser1(Long userId, String userNamePlain, String userName, String userType, String pwd);
}
