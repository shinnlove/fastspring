/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.web.config.schema.parser;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

import com.shinnlove.fastspring.web.config.schema.student.Student;

/**
 * 自定义模型bean定义的解析器。
 *
 * @author shinnlove.jinsheng
 * @version $Id: StudentBeanDefinitionParser.java, v 0.1 2018-05-22 下午10:49 shinnlove.jinsheng Exp $$
 */
public class StudentBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    /**
     * @see org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser#getBeanClass(Element) 
     */
    @Override
    protected Class getBeanClass(Element element) {
        return Student.class;
    }

    /**
     * @see org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser#doParse(Element, BeanDefinitionBuilder) 
     */
    @Override
    protected void doParse(Element element, BeanDefinitionBuilder bean) {
        String name = element.getAttribute("name");
        bean.addPropertyValue("name", name);

        String age = element.getAttribute("age");
        if (StringUtils.hasText(age)) {
            bean.addPropertyValue("age", Integer.valueOf(age));
        }
    }

}