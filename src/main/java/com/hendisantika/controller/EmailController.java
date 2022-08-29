package com.hendisantika.controller;

import com.hendisantika.config.EmailConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sargue.mailgun.Configuration;
import net.sargue.mailgun.Mail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mailgun-sample
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 8/29/22
 * Time: 20:21
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class EmailController {
    private final EmailConfig emailConfig;

    @GetMapping("/sendEmail")
    public ResponseEntity<String> sendEmail() {
        // create mail sender
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(emailConfig.getHost());
        mailSender.setPort(emailConfig.getPort());
        mailSender.setUsername(emailConfig.getUsername());
        mailSender.setPassword(emailConfig.getPassword());

        // create an email instance
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        // email.getEmail()
        mailMessage.setFrom("Aktivasi anaonline <no-reply@anaonline.id>");
        mailMessage.setTo("hendi@yopmail.com");
        // email.getSubject()
        mailMessage.setSubject("SMTP - E-Voting Token Instruction Test subject");
        // email.getMessageText()
        mailMessage.setText("Test text !!!\nSend Email using SMTP - E-Voting Token Instruction Test subject");

        // send mail
        mailSender.send(mailMessage);
        log.info("Email already sent via SMTP! Please check your inbox for order confirmation!");
        return new ResponseEntity<>("Please check your inbox!", HttpStatus.OK);
    }

    @GetMapping("/sendEmail2")
    public ResponseEntity<String> sendEmail2() {
        // create mail sender
        Configuration configuration = new Configuration()
                .domain(emailConfig.getDomain())
                .apiKey(emailConfig.getApiKey())
                .from(emailConfig.getFrom(), emailConfig.getFromEmail());

        Mail.using(configuration)
                .to("hendi@yopmail.com")
                .subject("API KEY - This is the subject")
                .text("Hello world!\nSend Email using API KEY - This is the subject")
                .build()
                .send();
        log.info("Email already sent via API KEY! Please check your inbox for order confirmation!");
        return new ResponseEntity<>("Please check your inbox!", HttpStatus.OK);
    }

}
