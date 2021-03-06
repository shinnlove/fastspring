/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.dal.mybatis;

import com.shinnlove.fastspring.common.dal.model.User;

/**
 * mybatis接口，对于mybatis，DAO就是Mapper接口，会由mybatis托管生成具体的Impl。
 *
 * @author shinnlove.jinsheng
 * @version $Id: UserDaoMapper.java, v 0.1 2017-12-31 下午6:48 shinnlove.jinsheng Exp $$
 */
public interface UserDaoMapper {

    User getUser(User user);

    User getUserById(int id);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

}