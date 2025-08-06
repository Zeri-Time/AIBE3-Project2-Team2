package com.team2;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private final String actionName;
    private final Map<String, String> params = new HashMap<>();

    public Rq(String cmd) {
        String[] cmdBits = cmd.split(" ", 2);
        actionName = cmdBits[0].trim();

        String queryString = cmdBits.length == 2 ? cmdBits[1].trim() : "";

        params.put(actionName, queryString);
    }

    public String getActionName() {
        return actionName;
    }

    public int getParamsAsInt() {
        String value = getParam(actionName, "");

        if(value == null) return -1;

        try {
            return Integer.parseInt(value);
        } catch(NumberFormatException e) {
            return -1;
        }

    }

    public String getParam(String name, String defaultValue) {
        return params.getOrDefault(name, defaultValue);
    }
}
