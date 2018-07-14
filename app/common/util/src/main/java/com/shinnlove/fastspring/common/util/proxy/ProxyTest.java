/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.proxy;

/**
 * 测试CGLIB代理。
 *
 * @author shinnlove.jinsheng
 * @version $Id: ProxyTest.java, v 0.1 2018-07-14 上午11:31 shinnlove.jinsheng Exp $$
 */
public class ProxyTest {

    public static void main(String[] args) {
        Ship ship = new Ship();
        ship.travel();

        ShipProxy cglibProxy = new ShipProxy();
        Ship sProxy = (Ship) cglibProxy.getProxy(Ship.class);
        sProxy.travel();
    }

}