package com.dehu.actuator_hu.endpoint;


import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "dehu")
public class DehuEndPoint {

    public Map<String, Object> dehuInfo = new HashMap<String, Object>();

    public DehuEndPoint() {
        dehuInfo.put("old", 18);
        dehuInfo.put("like", "吴彦祖");
    }

    @ReadOperation
    public Map show() {
        return dehuInfo;
    }

    @WriteOperation
    public void write(String key, String value) {
        dehuInfo.put(key, value);
    }

}
