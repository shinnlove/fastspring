/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.future;

import java.util.concurrent.CompletableFuture;

/**
 * 可编排任务接受两个并发结果，并且使用`BiConsumer`进行处理。
 *
 * @author shinnlove.jinsheng
 * @version $Id: CompletableFutureAcceptBoth.java, v 0.1 2018-05-22 下午3:29 shinnlove.jinsheng Exp $$
 */
public class CompletableFutureAcceptBoth {

    public static void main(String[] args) throws Exception {

        String original = "Message";
        StringBuilder sb = new StringBuilder();

        // 第二个并行单元
        CompletableFuture secondTask = CompletableFuture.completedFuture(original).thenApply(
            String::toLowerCase);

        // 定义一个并行单元转大写，自己并且第二个并行单元都完成，则使用`BiConsumer`进行处理。
        CompletableFuture.completedFuture(original).thenApply(String::toUpperCase)
            .thenAcceptBoth(secondTask, (s1, s2) -> sb.append(s1 + "," + s2));

        System.out.println(sb.toString());

    }

}