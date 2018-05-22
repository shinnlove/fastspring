/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.web.config.schema.handler;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

import com.shinnlove.fastspring.web.config.schema.parser.SyncBeanDefinitionParser;

/**
 * 双写命名空间解析。
 *
 * @author shinnlove.jinsheng
 * @version $Id: SyncNamespaceHandler.java, v 0.1 2018-05-22 下午11:14 shinnlove.jinsheng Exp $$
 */
public class SyncNamespaceHandler extends NamespaceHandlerSupport {

    /**
     * @see org.springframework.beans.factory.xml.NamespaceHandlerSupport#init()
     */
    @Override
    public void init() {
        // 注册解析sync标签的解析器
        registerBeanDefinitionParser("sync", new SyncBeanDefinitionParser());
    }

}