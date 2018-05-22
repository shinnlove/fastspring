/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 测试JDK8的Stream用法。
 *
 * @author shinnlove.jinsheng
 * @version $Id: StreamTest.java, v 0.1 2018-05-21 下午8:59 shinnlove.jinsheng Exp $$
 */
public class StreamTest {

    public static void main(String[] args) {
        Book book1 = new Book("JAVA编程思想", "布鲁斯艾可儿", 2);
        Book book2 = new Book("Netty", "林", 1);
        Book book3 = new Book("Mina", "林", 3);
        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.stream().filter(book -> book.getAuthor().equals("林")).collect(Collectors.toList())
            .forEach(book -> System.out.println(book));

        //        new Thread(() -> System.out.println("hello"));

        System.out.println(bookList);

        Collections.sort(bookList, (o1, o2) -> o1.getOrder() - o2.getOrder());

        System.out.println(bookList);

        int t = new UsePlus((a, b) -> a * b + a + b).realPlus(10, 20);

        System.out.println(t);

    }

}