package com.grg.shardingsphere.service.impl;

import com.grg.shardingsphere.dao.UserDao;
import com.grg.shardingsphere.service.UserService;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * UserServiceImpl
 *
 * @author Lee
 * @version v1.0
 * @date 2019-10-24 10:06:53
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * ---ShardingTransactionType: 需要同Spring的@Transactional配套使用，事务才会生效
     * ---TransactionType.LOCAL 本地事务
     * ---TransactionType.XA 两阶段事务（支持夸库事务）
     * ---TransactionType.BASE 柔性事务
     *
     * @param userId        用户id
     * @param userNamePlain 用户姓名
     * @param userName      密文列
     * @param userType      用户类型
     * @param pwd           密文列
     * @return
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public int insertUser(Long userId, String userNamePlain, String userName, String userType, String pwd) {
        try {
            TransactionTypeHolder.set(TransactionType.XA);
            int i = userDao.insertUser(userId, userNamePlain, userName, userType, pwd);
            int j = 1 / 0;
            return i;
        } catch (Exception e) {
            // 使用io.shardingsphere的ShardingTransaction需要加上下面方法调用，不然会回滚失败
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.error(NestedExceptionUtils.buildMessage("添加新用户[userId={}]异常：", e), userId);
        }
        return 0;
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public int insertUser1(Long userId, String userNamePlain, String userName, String userType, String pwd) {
        TransactionTypeHolder.set(TransactionType.XA);
        int i = userDao.insertUser(userId, userNamePlain, userName, userType, pwd);
        int j = 1 / 0;
        return i;
    }
}
