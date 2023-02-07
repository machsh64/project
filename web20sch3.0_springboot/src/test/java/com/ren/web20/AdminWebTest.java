package com.ren.web20;

import com.ren.web20.pojo.AdminWeb;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @program: web20sch1.2
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-07 11:25
 * @description:
 **/
@Slf4j
@SpringBootTest
public class AdminWebTest {

    @Test
    public void test() throws IOException {
        AdminWeb instance = AdminWeb.getInstance();

        log.info("#### adminWeb :  {}  ######",instance);
    }
}
