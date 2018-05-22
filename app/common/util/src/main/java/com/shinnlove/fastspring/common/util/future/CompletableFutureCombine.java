/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.future;

import java.util.concurrent.CompletableFuture;

/**
 * 合并Future结果`thenCombine`测试。
 *
 * 场景：将两个异步计算的结果组合起来，无论A和B哪个更快，都会在A.thenCombine方法上阻塞直到拿到结果。
 *
 * **将第二个任务合并到第一个任务上，两者的结果由`BiFunction`进行处理，最终返回一个合并后的任务替换第一个任务。**
 *
 * @author shinnlove.jinsheng
 * @version $Id: CompletableFutureCombine.java, v 0.1 2018-05-22 上午11:05 shinnlove.jinsheng Exp $$
 */
public class CompletableFutureCombine {

    public static void main(String[] args) throws Exception {

        // 定义第一个带返回值的异步任务
        CompletableFuture<Integer> firstTask = CompletableFuture.supplyAsync(() -> {
            //模拟执行耗时任务
            System.out.println("task1 doing...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //返回结果
            return 100;
        });

        // 定义第二个带返回值的异步任务
        CompletableFuture<Integer> secondTask = CompletableFuture.supplyAsync(() -> {
            //模拟执行耗时任务
            System.out.println("task2 doing...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //返回结果
            return 2000;
        });

        // 将第二个任务合并到第一个任务上，两者的结果由`BiFunction`进行处理，最终返回一个合并后的任务替换第一个任务。
        CompletableFuture<Integer> combineStep = firstTask.thenCombine(secondTask,
            (result1, result2) -> result1 + result2);

        System.out.println(combineStep.get());

    }

}