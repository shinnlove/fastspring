/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.hash;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shinnlove.jinsheng
 * @version $Id: SpringDetector.java, v 0.1 2018-06-25 下午7:54 shinnlove.jinsheng Exp $$
 */
public class SpringDetector {

    /**
     * 检测spring到来，泛型擦除到边界土拨鼠。
     *
     * @param type
     * @param <T>
     * @throws Exception
     */
    public static <T extends Groundhog> void detectedSpring(Class<T> type) throws Exception {
        // 获取构造器的一种方式
        Constructor<T> ghog = type.getConstructor(int.class);
        Map<Groundhog, Prediction> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(ghog.newInstance(i), new Prediction());
        }
        System.out.println("map=" + map);

        Groundhog gh = ghog.newInstance(3);
        System.out.println("Looking up prediction for " + gh);
        // Groundhog自动继承自基类Object，当使用Object的hashCode()方法生成散列码，默认使用对象的地址计算散列码！(Object.equals()比较地址)
        // 因此后边找的对象跟前面放入map中的对象不同
        // 如果编写适当的的hashCode()方法覆盖，仍然无法找到：除非同时覆盖equals()方法，因为HashMap只用equals()判断当前的是否与表中存在的相同(找到了也不同)。
        // equals特性：
        // 1、自反性(自己对自己)、
        // 2、对称性(两两互相)、
        // 3、传递性(三者传导)、
        // 4、一致性(等价比较信息不变无论多少次都相等)、
        // 5、对任何不是null的x，x.equals(null)一定返回false。
        // 因此如果要使用自己的类作为HashMap的键，必须同时重载hashCode()和equals()! !
        if (map.containsKey(gh)) {
            System.out.println("Key has been found!");
            System.out.println(map.get(gh));
        } else {
            System.out.println("Key not found: " + gh);
        }
    }

    public static void main(String[] args) throws Exception {
        detectedSpring(Groundhog.class);
        detectedSpring(Groundhog2.class);
    }

}