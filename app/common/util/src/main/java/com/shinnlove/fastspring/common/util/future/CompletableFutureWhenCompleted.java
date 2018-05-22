/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * 当一个并发State结束的时候新建一个结束State。
 *
 * @author shinnlove.jinsheng
 * @version $Id: CompletableFutureWhenCompleted.java, v 0.1 2018-05-22 下午3:36 shinnlove.jinsheng Exp $$
 */
public class CompletableFutureWhenCompleted {

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();
        List<String> messages = Arrays.asList("a", "b", "c");

        List<CompletableFuture> futures = messages.stream()
        // 打开流进行循环
            .map(msg -> CompletableFuture.completedFuture(msg).thenApply(s -> s.toUpperCase()))
            // 然后收集成List，上一个里边返回的是`CompletableFuture`类型的对象，因此返回List<CompletableFuture>对象
            .collect(Collectors.toList());

        CompletableFuture.anyOf(futures.toArray(new CompletableFuture[futures.size()]))
        // 使用`whenComplete`返回一个`CompletableFuture`对象
            .whenComplete((res, throwable) -> {
                // 一个是结果，一个是ex，anyOf所以第一个a结束就传入了
                System.out.println(throwable);
                System.out.println(res);
                if (throwable == null) {
                    sb.append(res);
                } else {
                    throw new RuntimeException(throwable);
                }
            });

        System.out.println(sb.toString());

    }

}