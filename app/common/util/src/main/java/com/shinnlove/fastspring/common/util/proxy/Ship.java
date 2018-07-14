/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.proxy;

/**
 * 普通的非final、给CGLIB代理的类。
 *
 * @author shinnlove.jinsheng
 * @version $Id: Ship.java, v 0.1 2018-07-14 上午11:32 shinnlove.jinsheng Exp $$
 */
public class Ship {

    public void travel() {
        System.out.println("轮船正在行驶");
    }

}