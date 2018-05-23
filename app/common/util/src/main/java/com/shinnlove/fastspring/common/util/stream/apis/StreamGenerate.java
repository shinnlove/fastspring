/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.stream.apis;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream流生成的方式。
 *
 * @author shinnlove.jinsheng
 * @version $Id: StreamGenerate.java, v 0.1 2018-05-23 下午5:39 shinnlove.jinsheng Exp $$
 */
public class StreamGenerate {

    public static void main(String[] args) throws Exception {
        // 1. Individual values
        // 从独立的元素创建stream流
        Stream stream = Stream.of("a", "b", "c");

        // 2. Arrays
        // 从数组创建stream流
        String[] strArray = new String[] { "a", "b", "c" };
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);

        // 3. Collections
        // 从集合元素创建stream流
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();
    }

}