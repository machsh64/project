package com.ren.price.service.impl;

import com.ren.price.service.GoldService;
import com.sun.istack.internal.NotNull;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.Properties;


/**
 * @program: gitRep
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-13 22:31
 * @description:
 **/
@Service
public class GoldServiceImpl implements GoldService {


    /**
     * 设置高低区间返回msg
     *
     * @param highPrice
     * @param lowPrice
     * @return
     * @throws InterruptedException
     */
    @Override
    public void getMsgInfo(Boolean isGet, String email, Double highPrice, Double lowPrice) throws InterruptedException, GeneralSecurityException, MessagingException {
        if (isGet) {
            Thread.sleep(800);
            String msg = null;
            if (getGoldPrice() > highPrice) {
                msg = "价格高于 ： " + highPrice + "  请准备进行抛投处理";
            }
            if (getGoldPrice() <= lowPrice) {
                msg = "价格低于 ： " + lowPrice + "  请准备进行加仓处理";
            }
            if (msg != null) {
                sendMsgToEmail(email, msg);
            }
        }
    }

    /**
     * 将邮件发送到我的账户
     *
     * @param
     * @throws MessagingException
     * @throws GeneralSecurityException
     */
    @Override
    public void sendMsgToEmail(String email, String msg) throws MessagingException, GeneralSecurityException {
        //创建一个配置文件并保存
        Properties properties = new Properties();

        properties.setProperty("mail.host", "smtp.qq.com");

        properties.setProperty("mail.transport.protocol", "smtp");

        properties.setProperty("mail.smtp.auth", "true");


        //QQ存在一个特性设置SSL加密
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);

        //创建一个session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("3256772458@qq.com", "huptdaydqkbvchfj");
            }
        });

        //开启debug模式
        session.setDebug(true);

        //获取连接对象
        Transport transport = session.getTransport();

        //连接服务器
        transport.connect("smtp.qq.com", "3256772458@qq.com", "huptdaydqkbvchfj");

        //创建邮件对象
        MimeMessage mimeMessage = new MimeMessage(session);

        //邮件发送人
        mimeMessage.setFrom(new InternetAddress("3256772458@qq.com"));

        //邮件接收人
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));

        //邮件标题
        mimeMessage.setSubject("谷仓有变动！！！");

        //邮件内容
        mimeMessage.setContent(msg, "text/html;charset=UTF-8");

        //发送邮件
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());

        //关闭连接
        transport.close();
    }

    /**
     * 调用priceapi查询价格
     *
     * @return
     */
    @Override
    public Double getGoldPrice() {
        String param = "location=108.62 ,21.95&key=写你自己的key";
        StringBuilder sb = new StringBuilder();
        InputStream is = null;
        BufferedReader br = null;
        PrintWriter out = null;
        Double price = null;
        try {
            //接口地址
            String url = "https://api.jdjygold.com/gw/generic/hj/h5/m/latestPrice";
            URL uri = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
            connection.setRequestMethod("POST");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(10000);
            connection.setRequestProperty("accept", "*/*");
            //发送参数
            connection.setDoOutput(true);
            out = new PrintWriter(connection.getOutputStream());
            out.print(param);
            out.flush();
            //接收结果
            is = connection.getInputStream();
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line;
            //缓冲逐行读取
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            String backStr = sb.toString();

            JSONObject parseObject = JSONArray.parseObject(backStr);
            JSONObject obj = parseObject.getJSONObject("resultData");
            String uid = obj.getString("datas");
            JSONObject parseObjects = JSONArray.parseObject(uid);
            String price1 = parseObjects.getString("price");
            price = Double.valueOf(price1);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //关闭流
            try {
                if (is != null) {
                    is.close();
                }
                if (br != null) {
                    br.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (Exception ignored) {
                System.out.println(ignored);
            }
        }
        return price;
    }
}
