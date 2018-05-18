/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.thread.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 执行器测试
 *
 * @author shinnlove.jinsheng
 * @version $Id: ExecutorTest.java, v 0.1 2018-04-15 下午3:10 shinnlove.jinsheng Exp $$
 */
public class ExecutorTest {

    public static void main(String[] args){
        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "String";
            }
        });
    }

}