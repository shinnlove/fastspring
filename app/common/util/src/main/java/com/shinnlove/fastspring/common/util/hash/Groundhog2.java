/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.hash;

/**
 * 重写hashCode()和equals()方法的第二种土拨鼠。
 *
 * @author shinnlove.jinsheng
 * @version $Id: Groundhog2.java, v 0.1 2018-06-25 下午8:07 shinnlove.jinsheng Exp $$
 */
public class Groundhog2 extends Groundhog {

    public Groundhog2(int number) {
        super(number);
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        // 使用`instanceof`关键字，隐式检测了对象为null的情况，
        // null instanceof X类，一定返回false!!
        return o instanceof Groundhog2 && (number == ((Groundhog2) o).number);
    }

    @Override
    public String toString() {
        return "Groundhog2{" + "number=" + number + '}';
    }

}