package com.dehu.actuator_hu.controller;

import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Timer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/sayHi")
    public String sayHi(String username) throws InterruptedException {
// 线程长请求
        // Thread.sleep(5000);
        // 定制基于Metrics的计数器
        Metrics.counter("qudehu.counter", "username", username).increment();

        // 定制基于Metrics的定时器
        Timer timer = Metrics.timer("qudehu.timer");

        timer.record(() -> {
            System.out.println("success");
        });

        // 定制基于Metrics的仪表  记录单个值  一般集合数量
        Metrics.gauge("qudehu.gauge", 1);

        // 定制基于Metrics的摘要 一般用来记录 百分比数值（缓存命中率)
        DistributionSummary summary = Metrics.summary("test.summary");
        summary.record(1.5);
        return "success";
    }

}
