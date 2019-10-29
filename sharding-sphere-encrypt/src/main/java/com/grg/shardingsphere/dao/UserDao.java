package com.grg.shardingsphere.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * UserDao
 *
 * @author Lee
 * @version v1.0
 * @date 2019-10-24 08:48:06
 */
@Mapper
@Component
public interface UserDao {
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
    @Insert("insert into t_user(user_id, user_name_plain,user_name,user_type,pwd) value(#{userId},#{userNamePlain},#{userName},#{userType},#{pwd})")
    int insertUser(@Param("userId") Long userId, @Param("userNamePlain") String userNamePlain,
                   @Param("userName") String userName, @Param("userType") String userType, @Param("pwd") String pwd);
}
