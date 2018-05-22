/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.future;

import java.util.concurrent.CompletableFuture;

/**
 * 组合传递结果`thenCompose`测试。
 *
 * 场景：两个异步任务A和B，要A执行完成后向B传递结果，B任务为了等待A的结果，会在A.thenCompose方法上阻塞!!!
 *
 * **`thenCompose`形参会传入匿名内部类(lambda表达式)中。**
 *
 * **`thenCompose`方法不会阻塞直到`Function`执行完成，因为只是组合，所以A任务还是A任务，完成就调用`thenAccept`方法了。**
 *
 * @author shinnlove.jinsheng
 * @version $Id: CompletableFutureCompose.java, v 0.1 2018-05-22 上午11:16 shinnlove.jinsheng Exp $$
 */
public class CompletableFutureCompose {

    public static void main(String[] args) throws Exception {

        // supplyAsync提交一个有返回值的任务
        CompletableFuture<FutureModel> firstTask = CompletableFuture.supplyAsync(() -> {
            //模拟执行耗时任务
            System.out.println("task1 doing...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //返回结果

            return new FutureModel("这是第一个任务的结果", "测试用", 1);
        });

        firstTask.thenAccept(r -> System.out.println("第一个任务做完了，order值是=" + r.getOrder()));

        // 等第一个任务完成后，将任务结果传给参数result，异步执行后面的任务并返回一个代表任务的completableFuture
        CompletableFuture<Integer> composeTask = firstTask.thenCompose(result -> CompletableFuture
            .supplyAsync(() -> {
                //模拟执行耗时任务
                System.out.println("task2 doing...");

                System.out.println("传递进Future2中的result=" + result);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return result.getOrder() + 1000000000;
            }));

        System.out.println(composeTask.get());

    }
}