package com.even;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootThreadPoolApplicationTests {

    @Test
    public void contextLoads() {
        LocalDate today = LocalDate.now();

        LocalDate kssj = today.with(TemporalAdjusters.firstDayOfMonth());
    }

}
