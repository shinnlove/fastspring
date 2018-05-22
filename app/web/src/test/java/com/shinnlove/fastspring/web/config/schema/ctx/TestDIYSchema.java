/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.fastspring.web.config.schema.ctx;

import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shinnlove.fastspring.web.config.schema.student.Student;

/**
 * 测试自定义schema。
 *
 * @author shinnlove.jinsheng
 * @version $Id: TestDIYSchema.java, v 0.1 2018-05-22 下午11:04 shinnlove.jinsheng Exp $$
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:/META-INF/spring/*.xml")
public class TestDIYSchema {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
            "classpath:/META-INF/spring/fastspring-web.xml");
        Student student1 = (Student) ctx.getBean("student1");
        Student student2 = (Student) ctx.getBean("student2");
        Student student3 = (Student) ctx.getBean("student3");

        System.out.println("name: " + student1.getName() + " age :" + student1.getAge());
        System.out.println("name: " + student2.getName() + " age :" + student2.getAge());
        System.out.println("name: " + student3.getName() + " age :" + student3.getAge());
    }

}