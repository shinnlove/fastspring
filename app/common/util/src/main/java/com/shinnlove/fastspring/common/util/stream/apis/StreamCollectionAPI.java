/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.stream.apis;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.shinnlove.fastspring.common.util.stream.Transaction;

/**
 * JAVA8的Stream流式API操作。
 *
 * @author shinnlove.jinsheng
 * @version $Id: StreamCollectionAPI.java, v 0.1 2018-05-23 下午5:04 shinnlove.jinsheng Exp $$
 */
public class StreamCollectionAPI {

    public static void main(String[] args) throws Exception {
        // 原始列表
        List<Transaction> transactions = getTransactionList();

        // 流式操作：并行处理流、过滤、排序、循环、收集(去掉`.reversed()`可以让集合正着排序)
        List<Integer> transactionsIds = transactions.parallelStream()
            .filter(t -> t.getType() == Transaction.GROCERY)
            .sorted(Comparator.comparing(Transaction::getValue).reversed()).map(Transaction::getId)
            .collect(Collectors.toList());

        // 输出结果[2,4]，因为反向排序了
        System.out.println(transactionsIds);
    }

    private static List<Transaction> getTransactionList() {
        // 原始列表
        List<Transaction> transactions = new ArrayList<>();
        Transaction t1 = new Transaction(1, "ADAM", "6000");
        Transaction t2 = new Transaction(2, "SHINN", "3000");
        Transaction t3 = new Transaction(3, "GREEN", "2000");
        Transaction t4 = new Transaction(4, "SHINN", "1000");
        transactions.add(t1);
        transactions.add(t2);
        transactions.add(t3);
        transactions.add(t4);
        return transactions;
    }

}