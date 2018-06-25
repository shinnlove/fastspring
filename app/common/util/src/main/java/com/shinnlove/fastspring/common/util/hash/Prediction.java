/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.hash;

import java.util.Random;

/**
 * @author shinnlove.jinsheng
 * @version $Id: Prediction.java, v 0.1 2018-06-25 下午7:53 shinnlove.jinsheng Exp $$
 */
public class Prediction {

    private static Random rand   = new Random(47);

    private boolean       shadow = rand.nextDouble() > 0.5;

    @Override
    public String toString() {
        if (shadow) {
            return "Six more weeks of Winter!";
        } else {
            return "Early Spring!";
        }
    }
}