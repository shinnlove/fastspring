/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.stream;

/**
 * 使用lambda表达式的类。
 *
 * @author shinnlove.jinsheng
 * @version $Id: UsePlus.java, v 0.1 2018-05-21 下午10:14 shinnlove.jinsheng Exp $$
 */
public class UsePlus {

    private PlusNumber plusNumber;

    public UsePlus(PlusNumber plusNumber) {
        this.plusNumber = plusNumber;
    }

    public int realPlus(int a, int b) {
        return plusNumber.plus(a, b);
    }

}