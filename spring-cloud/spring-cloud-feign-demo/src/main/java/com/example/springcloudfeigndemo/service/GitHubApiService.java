package com.example.springcloudfeigndemo.service;

import com.example.springcloudfeigndemo.config.FeignConfiguration;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2019/1/2 0002.
 *
 * @author even
 */

@FeignClient(value ="github-client",url = "https://api.github.com",configuration = FeignConfiguration.class)
public interface GitHubApiService {
    /**
     * 搜索仓库项目
     * @param queryStr
     * @return
     */
    @GetMapping("/search/repositories?q={str}")
    String searchRepo(@PathVariable("str") String queryStr);
}
