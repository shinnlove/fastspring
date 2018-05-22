/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.future;

import java.util.concurrent.CompletableFuture;

/**
 * 提供一个生产者异步执行任务，返回一个可编排Future。
 *
 * 使用forkJoinPool执行任务。
 *
 * @author shinnlove.jinsheng
 * @version $Id: CompletableFutureSupplyAsync.java, v 0.1 2018-05-22 上午11:32 shinnlove.jinsheng Exp $$
 */
public class CompletableFutureSupplyAsync {

    public static void main(String[] args) throws Exception {

        // supplyAsync内部使用ForkJoinPool线程池执行任务
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            //模拟执行耗时任务
            System.out.println("task doing...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //返回结果
            return "supplyAsync方法产生模型";
        });

        System.out.println("输出结果:" + future.get());

        CompletableFuture f = future.thenApply(r -> new FutureModel(r, "测试apply", 1));
        System.out.println(f.get());

    }

}