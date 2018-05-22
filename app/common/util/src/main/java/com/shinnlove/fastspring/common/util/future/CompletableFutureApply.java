/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.future;

import java.util.concurrent.CompletableFuture;

/**
 * 如果下一个Stage接收了当前Stage的结果但是在计算中无需返回值（比如其返回值为void），
 * 那么它将使用方法thenAccept并传入一个Consumer接口。
 *
 * @author shinnlove.jinsheng
 * @version $Id: CompletableFutureApply.java, v 0.1 2018-05-22 下午2:13 shinnlove.jinsheng Exp $$
 */
public class CompletableFutureApply {

    public static void main(String[] args) throws Exception {

        // 同步阻塞转型
        CompletableFuture syncTask = CompletableFuture.completedFuture("shinnlove").thenApply(
            s -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return s.toUpperCase();
            });
        System.out.println(syncTask.getNow(null));

        // 异步转型与连接
        CompletableFuture asyncTask = CompletableFuture.completedFuture("message").thenApplyAsync(
            s -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return s.toUpperCase();
            });
        System.out.println(asyncTask.getNow(null));
        asyncTask.join();
        System.out.println(asyncTask.getNow(null));

    }

}