/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.future;

import java.util.concurrent.CompletableFuture;

/**
 * thenCombine影响任务完成度，从而影响thenAccept方法。
 *
 * @author shinnlove.jinsheng
 * @version $Id: CompletableFutureAcceptAfterCombine.java, v 0.1 2018-05-22 下午2:26 shinnlove.jinsheng Exp $$
 */
public class CompletableFutureAcceptAfterCombine {

    public static void main(String[] args) throws Exception {
        // 为两个异步单元注册完成钩子
        CompletableFuture<FutureModel> firstTask = CompletableFuture.supplyAsync(() -> {
            //模拟执行耗时任务
            System.out.println("task1 doing...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //返回结果
            return new FutureModel("firstTask", "测试用", 1000);
        });

        // firstTask产生的计算结果再进行无结果的处理(并没有接收返回值)
        firstTask.thenAccept(result -> System.out.println("task1 done,result:" + result));

        // 第二个任务
        CompletableFuture<FutureModel> secondTask = CompletableFuture.supplyAsync(() -> {
            //模拟执行耗时任务
            System.out.println("task2 doing...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //返回结果
            return new FutureModel("secondTask", "测试用", 20000);
        });

        // secondTask产生的计算结果再进行无结果的处理(并没有接收返回值)
        secondTask.thenAccept(result -> System.out.println("task2 done,result:" + result));

        //将第一个任务与第二个任务组合一起执行，都执行完成后，将两个任务的结果合并
        CompletableFuture<Integer> combineResult = firstTask.thenCombine(secondTask,
        //合并函数
            (result1, result2) -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return result1.getOrder() + result2.getOrder();
            });

        // 因为进行了任务`thenCombine`，所以直到合并的get被输出，才认为firstTask完成，thenAccept才被调用
        System.out.println(combineResult.get());
    }

}