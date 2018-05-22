/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.common.util.stream;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 简单书本对象。
 *
 * @author shinnlove.jinsheng
 * @version $Id: Book.java, v 0.1 2018-05-21 下午9:00 shinnlove.jinsheng Exp $$
 */
public class Book {

    private String bookName;

    private String author;

    private int    order;

    public Book() {
    }

    public Book(String bookName, String author, int order) {
        this.bookName = bookName;
        this.author = author;
        this.order = order;
    }

    /**
     * Getter method for property bookName.
     *
     * @return property value of bookName
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * Setter method for property bookName.
     *
     * @param bookName value to be assigned to property bookName
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * Getter method for property author.
     *
     * @return property value of author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Setter method for property author.
     *
     * @param author value to be assigned to property author
     */
    public void setAuthor(String author) {
        this.author = author;
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