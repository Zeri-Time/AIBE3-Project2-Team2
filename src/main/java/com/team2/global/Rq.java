package com.team2.global;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;


public class Rq {
    private final String actionName;
    private final Map<String, String> params;

    public Rq(String cmd) {
        String[] cmdBits = cmd.split("\\?", 2);
        actionName = cmdBits[0];
        String queryString = cmdBits.length == 2 ? cmdBits[1].trim() : "";

        params = Arrays
                .stream(queryString.split("&"))
                .map(e -> e.split("=", 2))
                .filter(e -> e.length == 2 && !e[0].isBlank() && !e[1].isBlank())
                .collect(Collectors.toMap(e -> e[0].trim(), e -> e[1].trim()));
    }

    // IntelliJ는 Getter를 쓰라고 하지만 쓰지 않음 이유는 PR에서 서술
    public String getActionName() {
        return actionName;
    }

    public String getParam(String name, String defaultValue) {
        return params.getOrDefault(name, defaultValue);
    }

    public int getParamAsInt(String name, int defaultValue) {
        String value = getParam(name, "");

        if (value.isEmpty()) return defaultValue;
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
