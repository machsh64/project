package com.ren.price.service;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;

/**
 * @program: gitRep
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-13 22:31
 * @description:
 **/
public interface GoldService {

    /**
     * 获取实时黄金价格
     * @return
     */
    Double getGoldPrice();

    /**
     * 获取黄金的消息
     * @param isGet
     * @param email
     * @param highPrice
     * @param lowPrice
     * @return
     */
    void getMsgInfo(Boolean isGet, String email, Double highPrice, Double lowPrice) throws InterruptedException, GeneralSecurityException, MessagingException;

    /**
     * 向特定邮箱发送信息
     * @param msg
     * @param email
     */
    void sendMsgToEmail(String email, String msg) throws MessagingException, GeneralSecurityException;

}
