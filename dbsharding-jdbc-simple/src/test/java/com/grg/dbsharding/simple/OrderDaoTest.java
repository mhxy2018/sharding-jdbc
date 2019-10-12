package com.grg.dbsharding.simple;

import com.grg.dbsharding.simple.dao.DictDao;
import com.grg.dbsharding.simple.dao.OrderDao;
import com.grg.dbsharding.simple.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 分库分表测试
 *
 * @author Lee
 * @version v1.0
 * @date 2019/9/29 14:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShardingJdbcSimpleBootstrap.class})
public class OrderDaoTest {

    @Autowired
    OrderDao orderDao;

    @Autowired
    UserDao userDao;

    @Autowired
    DictDao dictDao;

    @Test
    public void testInsertOrder() {
        for (int i = 0; i < 10; i++) {
            orderDao.insertOrder(new BigDecimal((i + 1) * 5), 1L, "WAIT_PAY");
        }
        for (int i = 0; i < 10; i++) {
            orderDao.insertOrder(new BigDecimal((i + 1) * 10), 2L, "WAIT_PAY");
        }
    }

    @Test
    public void testSelectOrderbyIds() {
        List<Long> ids = new ArrayList<>();
        ids.add(384024742576783361L);
        ids.add(384024742560006144L);
        ids.add(384024818896338945L);
        ids.add(384024818879561728L);

        List<Map> maps = orderDao.selectOrderbyIds(ids);
        System.out.println(maps);
    }

    @Test
    public void testInsertUser() {
        for (int i = 0; i < 10; i++) {
            Long id = i + 1L;
            userDao.insertUser(id, "姓名" + id);
        }

    }

    @Test
    public void testSelectUserbyIds() {
        List<Long> userIds = new ArrayList<>();
        userIds.add(1L);
        userIds.add(2L);
        List<Map> users = userDao.selectUserbyIds(userIds);
        System.out.println(users);
    }

    @Test
    public void testSelectUserInfobyIds() {
        List<Long> userIds = new ArrayList<>();
        userIds.add(11L);
        userIds.add(12L);
        List<Map> users = userDao.selectUserInfobyIds(userIds);
        System.out.println(users);
    }

    @Test
    public void testInsertDict() {
        dictDao.insertDict(3L, "user_type", "2", "超级管理员");
        dictDao.insertDict(4L, "user_type", "3", "二级管理员");
    }

    @Test
    public void testDeleteDict() {
        dictDao.deleteDict(3L);
        dictDao.deleteDict(4L);
    }

}
