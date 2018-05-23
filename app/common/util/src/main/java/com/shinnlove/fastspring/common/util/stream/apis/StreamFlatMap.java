/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.stream.apis;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 流转换层级结构扁平化。
 *
 * @author shinnlove.jinsheng
 * @version $Id: StreamFlatMap.java, v 0.1 2018-05-23 下午5:56 shinnlove.jinsheng Exp $$
 */
public class StreamFlatMap {

    public static void main(String[] args) throws Exception {

        Stream<List<Integer>> inputStream = Stream.of(Arrays.asList(1), Arrays.asList(2, 3),
            Arrays.asList(4, 5, 6));

        //        Stream<Integer> outputStream = inputStream.flatMap((childList) -> childList.stream());

        List<Integer> numberList = inputStream.flatMap(childList -> childList.stream()).collect(
            Collectors.toList());
        System.out.println(numberList);

    }

}