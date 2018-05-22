/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.web.config.schema.handler;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

import com.shinnlove.fastspring.web.config.schema.parser.StudentBeanDefinitionParser;

/**
 * 学生类命名空间属性处理器。
 *
 * @author shinnlove.jinsheng
 * @version $Id: StudentNamespaceHandler.java, v 0.1 2018-05-22 下午10:48 shinnlove.jinsheng Exp $$
 */
public class StudentNamespaceHandler extends NamespaceHandlerSupport {

    /**
     * @see org.springframework.beans.factory.xml.NamespaceHandlerSupport#init()
     */
    @Override
    public void init() {
        // 注册解析student标签的解析器
        registerBeanDefinitionParser("student", new StudentBeanDefinitionParser());
    }

}