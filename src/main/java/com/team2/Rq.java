package com.team2;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String command;
    private Map<String, String> params;

    public Rq(String commandStr) {
        String[] commandBits = commandStr.split("\\?", 2);
        this.command = commandBits[0];
        this.params = new HashMap<>();

        if (commandBits.length > 1) {
            String[] paramBits = commandBits[1].split("&");
            for (String paramBit : paramBits) {
                String[] param = paramBit.split("=", 2);
                if (param.length == 2) {
                    this.params.put(param[0], param[1]);
                }
            }
        }
    }

    public String getCommand() {
        return command;
    }

    public int getParamAsInt(String name, int defaultValue) {
        try {
            return Integer.parseInt(params.getOrDefault(name, String.valueOf(defaultValue)));
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
