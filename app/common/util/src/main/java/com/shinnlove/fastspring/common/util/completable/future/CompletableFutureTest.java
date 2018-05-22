/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.completable.future;

import java.util.concurrent.CompletableFuture;

/**
 * 可编排的Future测试。
 *
 * @author shinnlove.jinsheng
 * @version $Id: CompletableFutureTest.java, v 0.1 2018-05-21 下午10:56 shinnlove.jinsheng Exp $$
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("future1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("future2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("future3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        CompletableFuture.allOf(future1, future2, future3)
            .thenRun(() -> System.out.println("任务结束"));

        Thread.sleep(5000);

    }
}