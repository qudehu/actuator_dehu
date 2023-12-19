package com.dehu.actuator_hu.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class DehuInfo implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        // 查询数据库
        builder.withDetail("topInfo", "哈哈哈哈");
    }
}
