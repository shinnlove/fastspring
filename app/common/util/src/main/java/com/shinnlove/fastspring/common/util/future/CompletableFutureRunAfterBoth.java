/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.future;

import java.util.concurrent.CompletableFuture;

/**
 * 在两个执行单元执行完成后运行一个异步任务。
 * 
 * A任务调用`runAfterBoth`，形参传入B任务，和一个`Runnable`的处理类。
 *
 * @author shinnlove.jinsheng
 * @version $Id: CompletableFutureRunAfterBoth.java, v 0.1 2018-05-22 下午3:15 shinnlove.jinsheng Exp $$
 */
public class CompletableFutureRunAfterBoth {

    public static void main(String[] args) throws Exception {

        String original = "Message";
        final StringBuilder sb = new StringBuilder();

        CompletableFuture firstTask = CompletableFuture.completedFuture(original).thenApply(
            String::toUpperCase);

        CompletableFuture secondTask = CompletableFuture.completedFuture(original).thenApply(
            String::toLowerCase);

        firstTask.runAfterBoth(secondTask, () -> sb.append(" done"));

        System.out.println(sb.toString());

        System.out.println(firstTask.get());
        System.out.println(secondTask.get());

    }

}