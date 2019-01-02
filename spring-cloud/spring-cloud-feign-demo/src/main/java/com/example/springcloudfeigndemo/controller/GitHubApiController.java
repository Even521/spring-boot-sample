package com.example.springcloudfeigndemo.controller;

import com.example.springcloudfeigndemo.service.GitHubApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2019/1/2 0002.
 *
 * @author even
 */
@RestController
public class GitHubApiController {
    @Autowired
    private GitHubApiService gitHubApiService;


   @GetMapping("/search/github/{queryStr}")
    public String search(@PathVariable String queryStr){
        return gitHubApiService.searchRepo(queryStr);
    }
}
