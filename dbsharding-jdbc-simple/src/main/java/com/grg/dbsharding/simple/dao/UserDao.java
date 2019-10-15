package com.grg.dbsharding.simple.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 用户dao
 *
 * @author Lee
 * @version v1.0
 * @date 2019/9/29 14:32
 */
@Mapper
@Component
public interface UserDao {
    /**
     * 新增用户
     *
     * @param userId   用户id
     * @param fullName 用户姓名
     * @param userType 用户类型
     * @return 执行条数
     */
    @Insert("insert into t_user(user_id, fullname,user_type) value(#{userId},#{fullName},#{userType})")
    int insertUser(@Param("userId") Long userId, @Param("fullName") String fullName, @Param("userType") String userType);

    /**
     * 根据id列表查询多个用户
     *
     * @param userIds 用户id列表
     * @return 查询结果
     */
    @Select({"<script>",
            " select",
            " * ",
            " from t_user t ",
            " where t.user_id in",
            "<foreach collection='userIds' item='id' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</script>"
    })
    List<Map> selectUserbyIds(@Param("userIds") List<Long> userIds);

    /**
     * 根据id列表查询多个用户
     *
     * @param userIds 用户id列表
     * @return 查询结果
     */
    @Select({"<script>",
            " select",
            " * ",
            " from t_user t ,t_dict b",
            " where t.user_type = b.code and t.user_id in",
            "<foreach collection='userIds' item='id' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</script>"
    })
    List<Map> selectUserInfobyIds(@Param("userIds") List<Long> userIds);
}
