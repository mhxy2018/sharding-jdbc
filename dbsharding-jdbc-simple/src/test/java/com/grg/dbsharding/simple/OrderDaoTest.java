package com.grg.dbsharding.simple;

import com.grg.dbsharding.simple.dao.DictDao;
import com.grg.dbsharding.simple.dao.OrderDao;
import com.grg.dbsharding.simple.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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
        for (int i = 10; i < 20; i++) {
            orderDao.insertOrder(new BigDecimal((i + 1) * 5), 1L, "WAIT_PAY");
        }
        for (int i = 10; i < 20; i++) {
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
        for (int i = 40; i < 50; i++) {
            Long id = i + 1L;
            userDao.insertUser(id, "姓名" + id, String.valueOf(i % 2 + 1));
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
        userIds.add(21L);
        userIds.add(22L);
        List<Map> users = userDao.selectUserInfobyIds(userIds);
        System.out.println(users);
    }

    @Test
    public void testInsertDict() {
        // dict为公共表，插入或更新数据时会操作所有实际库
        dictDao.insertDict(1L, "user_type", "1", "超级管理员");
        dictDao.insertDict(2L, "user_type", "2", "二级管理员");
    }

    @Test
    public void testDeleteDict() {
        dictDao.deleteDict(1L);
        dictDao.deleteDict(2L);
    }

}
