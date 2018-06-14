/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author shinnlove.jinsheng
 * @version $Id: CompletableFutureCombineAnother.java, v 0.1 2018-06-14 下午6:43 shinnlove.jinsheng Exp $$
 */
public class CompletableFutureCombineAnother {

    public static void main(String[] args) throws Exception {

        // 定义第一个带返回值的异步任务
        CompletableFuture<String> firstTask = CompletableFuture.supplyAsync(() -> {
            //模拟执行耗时任务
            System.out.println("task1 doing...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //返回结果
            return "hello";
        });

        // 定义第二个带返回值的异步任务
        CompletableFuture<Integer> secondTask = CompletableFuture.supplyAsync(() -> {
            //模拟执行耗时任务
            System.out.println("task2 doing...");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //返回结果
            return 2000;
        });

        // 将第二个任务合并到第一个任务上，两者的结果由`BiFunction`进行处理，最终返回一个合并后的任务替换第一个任务。
        CompletableFuture combineStep = firstTask.thenCombineAsync(secondTask,
                (result1, result2) -> {
                    List<String> allResult = new ArrayList<>();
                    allResult.add(result1);
                    allResult.add(String.valueOf(result2));
                    return allResult;
                });

        System.out.println(combineStep.get());

    }

}