package com.sample;

import com.sample.service.JobTimerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootQuartzApplicationTests {
	@Resource
	private JobTimerService jobTimerService;

	@Test
	public void contextLoads() throws Exception {
		jobTimerService.test();
	}

}
