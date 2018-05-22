/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.future;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * 对任意一个结束单元的结果进行消费(区别于处理)——`AcceptEither`方法。
 *
 * @author shinnlove.jinsheng
 * @version $Id: CompletableFutureAcceptEither.java, v 0.1 2018-05-22 下午3:09 shinnlove.jinsheng Exp $$
 */
public class CompletableFutureAcceptEither {

    public static void main(String[] args) throws Exception {
        String original = "Message";
        final StringBuilder sb = new StringBuilder();

        // 第一个任务（转成大写）
        CompletableFuture firstTask = CompletableFuture.completedFuture(original).thenApplyAsync(
            s -> {

                // 随机睡一会
                Random r = new Random(System.currentTimeMillis());
                int seconds = r.nextInt(2) + 1;
                try {
                    Thread.sleep(seconds * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return s.toUpperCase();
            });

        // 第二个任务（转成小写）
        CompletableFuture secondTask = CompletableFuture.completedFuture(original).thenApplyAsync(
            s -> {

                // 随机睡一会
                Random r = new Random(System.currentTimeMillis());
                int seconds = r.nextInt(1) + 1;
                try {
                    Thread.sleep(seconds * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return s.toLowerCase();
            });

        firstTask.acceptEither(secondTask, s -> sb.append(s).append(" acceptEither."));

        firstTask.join();

        System.out.println(sb.toString());
    }

}