package com.team2.global;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class Rq {

    @Getter
    private final String actionName;
    private final Map<String, Integer> paramMap = new HashMap<>();

    public Rq(String cmd) {
        String[] split = cmd.split(" ");
        actionName = split[0];
        if (split.length > 1) paramMap.put("id", Integer.parseInt(split[1]));
    }

    public int getParamAsInt(String paramName, int defaultValue) {
        return paramMap.getOrDefault(paramName, defaultValue);
    }
}
