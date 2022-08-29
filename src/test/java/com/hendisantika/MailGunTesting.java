package com.hendisantika;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mailgun-sample
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 8/29/22
 * Time: 20:48
 * To change this template use File | Settings | File Templates.
 */
public class MailGunTesting {
    @Test
    public void givenUsingJava8_whenGeneratingRandomAlphanumericString_thenCorrect() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 8;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(generatedString);
    }

    @Test
    public void givenUsingApache_whenGeneratingRandomAlphanumericString_thenCorrect() {
        String generatedString = RandomStringUtils.randomAlphanumeric(8);
        System.out.println(generatedString);
    }

    static String usingUUID() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString().replaceAll("-", "");
    }

    public static String generateRandomPassword(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    @Test
    public void givenUsingUUID_whenGeneratingRandomAlphanumericString_thenCorrect() {
        String randomString = usingUUID();
        System.out.println("Random string is: " + randomString);
        System.out.println("Random string of 8 characters is: " + randomString.substring(0, 8));

        for (int i = 0; i < 10; i++) {
            System.out.println("String " + i + " : " + generateRandomPassword(8));
        }
    }
}
