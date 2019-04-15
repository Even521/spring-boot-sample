package com.even;

import com.even.service.AsyncService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class SpringBootThreadPoolApplicationTests {

    @Autowired
    private AsyncService asyncService;

    @Test
    public void contextLoads() {
        asyncService.asyncRequest(list());
        asyncService.printInLog();

    }

    private List<Integer> list(){
        List list=new ArrayList();
        for (int i = 0; i <10000 ; i++) {
            list.add(i);
        }
        return list;
    }










}
