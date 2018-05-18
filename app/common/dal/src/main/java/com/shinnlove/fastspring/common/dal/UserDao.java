/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.dal;

import com.shinnlove.fastspring.common.dal.model.User;

/**
 * @author shinnlove.jinsheng
 * @version $Id: UserDao.java, v 0.1 2017-11-25 下午10:39 shinnlove.jinsheng Exp $$
 */
public interface UserDao {

    void saveUser(User user);

    User getUserById(int id);

}