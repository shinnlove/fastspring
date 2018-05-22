/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.future;

import java.util.concurrent.CompletableFuture;

/**
 * 等待任务完全执行完成或者有一个执行完成。
 *
 * AllOf会阻塞直到所有任务都返回结果；
 *
 * AnyOf场景：任何一个任务都是相同类型任务，这样返回结果都一样的类型，否则不同任务AnyOf不太好处理，维度也不统一。
 *
 * @author shinnlove.jinsheng
 * @version $Id: CompletableFutureAllOfAnyOf.java, v 0.1 2018-05-22 上午11:35 shinnlove.jinsheng Exp $$
 */
public class CompletableFutureAllOfAnyOf {

    public static void main(String[] args) throws Exception {

        CompletableFuture<String> firstTask = CompletableFuture.supplyAsync(() -> {
            //模拟执行耗时任务
            System.out.println("task1 doing...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //返回结果
            return "我是第一个任务，做完了";
        });

        CompletableFuture<String> secondTask = CompletableFuture.supplyAsync(() -> {
            //模拟执行耗时任务
            System.out.println("task2 doing...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //返回结果
            return "我是第二个任务，做完了";
        });

        // 任何一个执行完(结果是Object类型的)
        CompletableFuture<Object> anyResult = CompletableFuture.anyOf(firstTask, secondTask);
        System.out.println("第一个做完的任务是:" + anyResult.get());

        // 所有都执行完：allOf的结果是Void的，意味着get()会返回null
        CompletableFuture<Void> allResult = CompletableFuture.allOf(firstTask, secondTask);

        // 阻塞等待所有任务执行完成
        allResult.join();

        System.out.println("所有任务执行完成");

    }

}