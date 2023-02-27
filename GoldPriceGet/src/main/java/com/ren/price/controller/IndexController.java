package com.ren.price.controller;

import com.ren.price.service.GoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.security.GeneralSecurityException;

/**
 * @program: gitRep
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-13 22:30
 * @description:
 **/
@Controller
public class IndexController {

    @Autowired
    private GoldService goldService;

    @GetMapping(value = {"/","/index"})
    public String indexPage(){
        return "index";
    }

    @PostMapping("/setInfo")
    public String setInfo(String email, String highPrice,String lowPrice) throws InterruptedException, GeneralSecurityException, MessagingException {
        Double highPriceD = Double.parseDouble(highPrice);
        double lowPriceD = Double.parseDouble(lowPrice);
        goldService.getMsgInfo(true,email,highPriceD,lowPriceD);
        return "index";
    }

    @ResponseBody
    @GetMapping("/giveUpSetInfo")
    public String GiveUpSetInfo() throws InterruptedException, GeneralSecurityException, MessagingException {

        goldService.getMsgInfo(false,"",0.0,0.0);
        return "成功放弃推送";
    }
}
