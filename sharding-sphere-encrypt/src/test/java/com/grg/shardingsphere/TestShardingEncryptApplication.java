package com.grg.shardingsphere;

import com.grg.shardingsphere.dao.UserDao;
import com.grg.shardingsphere.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TestShardingEncryptApplication
 *
 * @author Lee
 * @version v1.0
 * @date 2019-10-24 08:50:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShardingEncryptApplication.class})
public class TestShardingEncryptApplication {

    @Autowired
    private UserService userService;

    @Test
    public void insertUser() {
//        for (int i = 0; i < 10; i++) {
//            Long id = i + 1L;
//            userDao.insertUser(id, "姓名" + id,"姓名" + id, String.valueOf(i % 2 + 1), "user_pwd" + String.valueOf(id));
//        }
        int i=120;
        Long id = i + 1L;
        userService.insertUser(id, "姓名" + id,"姓名" + id, String.valueOf(i % 2 + 1), "user_pwd" + String.valueOf(id));
    }

}
