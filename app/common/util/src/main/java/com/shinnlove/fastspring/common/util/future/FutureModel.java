/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.future;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 一个Future模型，传递参数用。
 *
 * @author shinnlove.jinsheng
 * @version $Id: FutureModel.java, v 0.1 2018-05-22 上午11:19 shinnlove.jinsheng Exp $$
 */
public class FutureModel {

    private String modelName;

    private String usage;

    private int    order;

    public FutureModel() {
    }

    public FutureModel(String modelName, String usage, int order) {
        this.modelName = modelName;
        this.usage = usage;
        this.order = order;
    }

    /**
     * Getter method for property modelName.
     *
     * @return property value of modelName
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Setter method for property modelName.
     *
     * @param modelName value to be assigned to property modelName
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * Getter method for property usage.
     *
     * @return property value of usage
     */
    public String getUsage() {
        return usage;
    }

    /**
     * Setter method for property usage.
     *
     * @param usage value to be assigned to property usage
     */
    public void setUsage(String usage) {
        this.usage = usage;
    }

    /**
     * Getter method for property order.
     *
     * @return property value of order
     */
    public int getOrder() {
        return order;
    }

    /**
     * Setter method for property order.
     *
     * @param order value to be assigned to property order
     */
    public void setOrder(int order) {
        this.order = order;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}