/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.future;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * 对任意一个结束单元的结果进行处理——`applyToEither`使用方法。
 *
 * 两个计算单元A和B，只要一个执行完了就把结果传入`applyToEither`的处理函数中进行处理。
 *
 * @author shinnlove.jinsheng
 * @version $Id: CompletableFutureApplyEither.java, v 0.1 2018-05-22 下午2:54 shinnlove.jinsheng Exp $$
 */
public class CompletableFutureApplyEither {

    public static void main(String[] args) throws Exception {

        String original = "Message";

        // 第一个随机任务
        CompletableFuture firstTask = CompletableFuture.completedFuture(original).thenApplyAsync(
            s -> {

                // 随机睡一会
                Random r = new Random(System.currentTimeMillis());
                int seconds = r.nextInt(3) + 1;
                try {
                    Thread.sleep(seconds * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return s.toUpperCase();
            });

        // 第二个随机任务
        CompletableFuture secondTask = CompletableFuture.completedFuture(original).thenApplyAsync(
            s -> {

                // 随机睡一会
                Random r = new Random(System.currentTimeMillis());
                int seconds = r.nextInt(2) + 1;
                try {
                    Thread.sleep(seconds * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return s.toLowerCase();
            });

        // applyToEither传入一个处理函数，对firstTask或secondTask只要一个完成就进行处理
        CompletableFuture cf2 = firstTask.applyToEither(secondTask, s -> s + " from applyToEither");

        // 返回MESSAGE/message from applyToEither
        System.out.println(cf2.join());
    }

}