package com.dehu.actuator_hu.endpoint;


import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
public class DehuHealthIndicator extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {

        try {
            boolean ischeck = check();

            if (ischeck) {
                builder.up().withDetail("total", "1");
            } else {
                builder.down();
            }
        } catch (Exception ex) {
            builder.down().withException(ex);
        }
    }

    // 自己去连接mongdb 如果连不上说明状态down
    // 根据自己项目的业务需求定制
    private boolean check() {
        // TODO: 验证逻辑
        int a = 1 / 0;
        return true;
    }
}
