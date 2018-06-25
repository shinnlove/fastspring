/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.hash;

/**
 * Groundhog自动继承自基类Object，当使用Object的hashCode()方法生成散列码，默认使用对象的地址计算散列码！
 *
 * @author shinnlove.jinsheng
 * @version $Id: Groundhog.java, v 0.1 2018-06-25 下午7:51 shinnlove.jinsheng Exp $$
 */
public class Groundhog {

    protected int number;

    public Groundhog(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Groundhog #" + number;
    }

}