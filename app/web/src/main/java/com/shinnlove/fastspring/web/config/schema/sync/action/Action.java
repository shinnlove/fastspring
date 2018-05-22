/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.web.config.schema.sync.action;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 双写同步处理类。
 *
 * @author shinnlove.jinsheng
 * @version $Id: Action.java, v 0.1 2018-05-22 下午11:16 shinnlove.jinsheng Exp $$
 */
public class Action {

    private String item;

    private String handler;

    private String transfer;

    private String callback;

    private String mode;

    public Action() {
    }

    public Action(String item, String handler, String transfer, String callback, String mode) {
        this.item = item;
        this.handler = handler;
        this.transfer = transfer;
        this.callback = callback;
        this.mode = mode;
    }

    /**
     * Getter method for property item.
     *
     * @return property value of item
     */
    public String getItem() {
        return item;
    }

    /**
     * Setter method for property item.
     *
     * @param item value to be assigned to property item
     */
    public void setItem(String item) {
        this.item = item;
    }

    /**
     * Getter method for property handler.
     *
     * @return property value of handler
     */
    public String getHandler() {
        return handler;
    }

    /**
     * Setter method for property handler.
     *
     * @param handler value to be assigned to property handler
     */
    public void setHandler(String handler) {
        this.handler = handler;
    }

    /**
     * Getter method for property transfer.
     *
     * @return property value of transfer
     */
    public String getTransfer() {
        return transfer;
    }

    /**
     * Setter method for property transfer.
     *
     * @param transfer value to be assigned to property transfer
     */
    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    /**
     * Getter method for property callback.
     *
     * @return property value of callback
     */
    public String getCallback() {
        return callback;
    }

    /**
     * Setter method for property callback.
     *
     * @param callback value to be assigned to property callback
     */
    public void setCallback(String callback) {
        this.callback = callback;
    }

    /**
     * Getter method for property mode.
     *
     * @return property value of mode
     */
    public String getMode() {
        return mode;
    }

    /**
     * Setter method for property mode.
     *
     * @param mode value to be assigned to property mode
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}