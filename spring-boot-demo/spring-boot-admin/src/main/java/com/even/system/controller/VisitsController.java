package com.even.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.even.common.result.Result;
import com.even.common.result.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/1/23 0023.
 *
 * @author even
 */
@RestController
@RequestMapping("api")
public class VisitsController {
    @PostMapping(value = "/visits")
    public Result create(){

        return null;
    }

    @GetMapping(value = "/visits")
    public Result<JSONObject> get(){
        JSONObject jsonObject= JSONObject.parseObject("{\"newVisits\":180,\"newIp\":145,\"recentVisits\":2935,\"recentIp\":2102}");
        return ResultUtils.success(jsonObject);
    }

    @GetMapping(value = "/visits/chartData")
    public Result<JSONObject> getChartData(){
        JSONObject jsonObject= JSONObject.parseObject("{\"weekDays\":[\"Thu\",\"Fri\",\"Sat\",\"Sun\",\"Mon\",\"Tue\",\"Wed\"],\"ipData\":[239,201,110,75,238,1094,146],\"visitsData\":[411,336,156,102,347,1403,181]}");
        return ResultUtils.success(jsonObject);
    }
}
