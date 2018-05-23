/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.stream.apis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.shinnlove.fastspring.common.util.stream.Transaction;

/**
 * JAVA8以前的集合遍历和排序。
 *
 * @author shinnlove.jinsheng
 * @version $Id: OriginCollectionRetrieveAndSort.java, v 0.1 2018-05-23 下午4:44 shinnlove.jinsheng Exp $$
 */
public class OriginCollectionRetrieveAndSort {

    public static void main(String[] args) throws Exception {

        // 原始列表
        List<Transaction> transactions = getTransactionList();

        // 过滤
        List<Transaction> groceryTransactions = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getType() == Transaction.GROCERY) {
                groceryTransactions.add(t);
            }
        }

        // 字符串字典序-排序
        Collections.sort(groceryTransactions, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction t1, Transaction t2) {
                return t1.getValue().compareTo(t2.getValue());
            }
        });

        // 排序后的id
        List<Integer> transactionIds = new ArrayList<>();
        for (Transaction t : groceryTransactions) {
            transactionIds.add(t.getId());
        }

        // 4的value1000在2的2000前面，输出[4, 2]
        System.out.println(transactionIds);

    }

    private static List<Transaction> getTransactionList() {
        // 原始列表
        List<Transaction> transactions = new ArrayList<>();
        Transaction t1 = new Transaction(1, "ADAM", "60000");
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