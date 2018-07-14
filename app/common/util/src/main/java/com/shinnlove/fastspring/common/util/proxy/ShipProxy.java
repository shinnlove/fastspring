/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * CGLIB代理类，主要实现{@link MethodInterceptor}的方法`intercept`，然后设置拦截调用。
 * {@link MethodInterceptor}继承自{@link Callback}，所以当前的代理类也是一个`Callback`，要设置给`Enhancer`。
 *
 * @author shinnlove.jinsheng
 * @version $Id: ShipProxy.java, v 0.1 2018-07-14 上午11:32 shinnlove.jinsheng Exp $$
 */
public class ShipProxy implements MethodInterceptor {

    /** cglib enhancer 字节码 增强 */
    private Enhancer enhancer = new Enhancer();

    /**
     * 根据目标Class获取一个cglib代理类。
     *
     * @param c
     * @return
     */
    public Object getProxy(Class c) {
        // 设置cglib代理创建子类的目标类
        enhancer.setSuperclass(c);
        // 设置回调
        enhancer.setCallback(this);
        // 创建cglib代理类
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
                                                                                        throws Throwable {
        System.out.println("日志开始...");
        //代理类调用父类的方法
        proxy.invokeSuper(obj, args);
        System.out.println("日志结束...");
        return null;
    }

}