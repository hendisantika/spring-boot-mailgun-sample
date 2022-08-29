package com.hendisantika.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mailgun-sample
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 8/29/22
 * Time: 20:20
 * To change this template use File | Settings | File Templates.
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailConfig {
    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port}")
    private int port;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;
}
