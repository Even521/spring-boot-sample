package com.sample;

//import com.even.EnableRedisLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Administrator on 2018/12/7 0007.
 *
 * @author even
 */
@SpringBootApplication
//@EnableRedisLock
public class SpringBootLockApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLockApplication.class, args);
    }
}
