/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

/**
 * 可编排任务异步run，执行任务同时注册钩子。
 *
 * @author shinnlove.jinsheng
 * @version $Id: CompletableFutureRunAsync.java, v 0.1 2018-05-22 下午1:28 shinnlove.jinsheng Exp $$
 */
public class CompletableFutureRunAsync {

    public static void main(String[] args) throws Exception {

        // 使用`forkJoinPool`守护线程池
        CompletableFuture future = CompletableFuture.runAsync(() -> {

            // forkJoinPool是守护线程池
            System.out.println(Thread.currentThread().isDaemon());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务执行完毕");
        }).thenAccept(r -> System.out.println("future-accept方法执行"));

        System.out.println(future.get());

        // 使用自定义线程池
        CompletableFuture task = CompletableFuture.runAsync(() -> {

            // forkJoinPool是守护线程池
            System.out.println(Thread.currentThread().isDaemon());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务执行完毕");
        }, Executors.newCachedThreadPool()).thenAccept(r -> System.out.println("task-accept方法执行"));

        System.out.println(task.get());

    }

}