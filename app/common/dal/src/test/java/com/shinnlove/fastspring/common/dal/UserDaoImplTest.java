/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.dal;

import com.shinnlove.fastspring.common.dal.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 用户仓储测试类
 *
 * @author shinnlove.jinsheng
 * @version $Id: UserDaoImplTest.java, v 0.1 2017-11-25 下午10:50 shinnlove.jinsheng Exp $$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/*.xml")
public class UserDaoImplTest {

    private static Logger logger = LoggerFactory.getLogger(UserDaoImplTest.class);

    @Autowired
    private UserDao       userDao;

    @Test
    public void getUserById() {

        logger.info("测试slf4j打印log4j类型日志");

        User user = userDao.getUserById(5);
        Assert.assertEquals("evelyn", user.getName());

        System.out.println(user);
    }

}