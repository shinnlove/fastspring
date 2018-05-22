/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.future;

import java.util.concurrent.CompletableFuture;

/**
 * 当异步编排任务结束的时候，注册一个completed的钩子，使用`thenAccept`。
 *
 * 特别注意：
 * 1、如果只是提交生产者任务，则`thenAccept`在执行完成任务之后就触发；
 * 2、如果一个任务A`thenCombine`另一个任务B，则A和B并发执行，阻塞在`thenCombine`的地方；
 *      当A和B有结果了，就执行`BiFunction`中的代码；
 *      当`BiFunction`中的代码执行完成，才去执行A任务的`thenAccept`方法。
 *
 * **所以：`thenCombine`就是将任务合并了，谁调用的`thenCombine`，就合并到谁身上。有点类似join方法，会阻塞`thenAccept`的执行。**
 *
 * @author shinnlove.jinsheng
 * @version $Id: CompletableFutureAccept.java, v 0.1 2018-05-22 上午11:48 shinnlove.jinsheng Exp $$
 */
public class CompletableFutureAccept {

    public static void main(String[] args) throws Exception {

        // 第一个结算单元提交了一个异步任务返回1000，第二个计算单元处理这个结果，但是不返回任何内容用`thenAccept`
        CompletableFuture f = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1000;
        }).thenAcceptAsync(r -> System.out.println("OK，输出" + r))
            .thenRunAsync(() -> System.out.println("我是第二个异步任务"))
            .thenAccept((r) -> System.out.println("这个r是null：" + r));

        f.join();

    }

}