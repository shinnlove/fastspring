/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.stream.apis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream流转换成其他的数据结构。
 *
 * @author shinnlove.jinsheng
 * @version $Id: TransferDataStructure.java, v 0.1 2018-05-23 下午5:44 shinnlove.jinsheng Exp $$
 */
public class TransferDataStructure {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("hello");
        stringList.add("world");

        Stream<String> stream = stringList.stream();

        // 特别注意：一个流只能被循环操作一次，否则会报出错误：`stream has already been operated upon or closed`

        // 1. Array
        String[] strArray1 = stream.toArray(String[]::new);
        System.out.println(strArray1);

        // 2. Collection
        // 转成列表
        List<String> list1 = stream.collect(Collectors.toList());
        List<String> list2 = stream.collect(Collectors.toCollection(ArrayList::new));
        // 转成集合
        Set set1 = stream.collect(Collectors.toSet());
        // 转成栈
        Stack stack1 = stream.collect(Collectors.toCollection(Stack::new));
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(set1);
        System.out.println(stack1);

        // 3. String
        String str = stream.collect(Collectors.joining()).toString();
        System.out.println(str);
    }

}