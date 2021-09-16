package cn.jwm.community;

import cn.jwm.community.util.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.swing.text.html.HTML;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTests {
    @Autowired
    private MailClient mailClient;
    @Autowired
    private TemplateEngine templateEngine; // 发送html邮件，不在controller 中，需要主动调用模板引擎。
    @Test
    public void testTextMail(){
        mailClient.sendMail("jwm236240@163.com","test","welcome");
    }
    @Test
    public void testHtmlMail(){
        // 将动态内容context传入模板
        Context context = new Context();
        context.setVariable("username","sunday");
        String content = templateEngine.process("/mail/demo",context);
        System.out.println(content);
        // 发送邮件的过程仍然一样
        mailClient.sendMail("jwm236240@163.com", "HTML",content);
    }


}
