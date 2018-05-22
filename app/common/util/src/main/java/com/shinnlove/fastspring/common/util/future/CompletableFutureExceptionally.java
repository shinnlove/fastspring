/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.future;

import java.util.concurrent.CompletableFuture;

/**
 * 可编排任务抛出异常的处理，异常处理也是一个编排单元。
 *
 * @author shinnlove.jinsheng
 * @version $Id: CompletableFutureExceptionally.java, v 0.1 2018-05-22 下午2:37 shinnlove.jinsheng Exp $$
 */
public class CompletableFutureExceptionally {

    public static void main(String[] args) throws Exception {

        CompletableFuture<Integer> exHandleTask = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int a = 10;
            int b = 20;
            return (a + b) / 0;
        }).exceptionally(e -> {
            // 处理异常(如果在链上，则也要有返回结果的)
            System.out.println(e.getMessage());
            e.printStackTrace();
            return 30;
        });

        System.out.println(exHandleTask.get());

        System.out.println("使用exceptionally后不会阻断main线程执行。");

        CompletableFuture<Integer> originTask = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int a = 10;
            int b = 20;
            return (a + b) / 0;
        });

        // 这样子会将错误带出来
        System.out.println(originTask.get());

        System.out.println("不使用exceptionally会阻断main线程执行！");

    }

}