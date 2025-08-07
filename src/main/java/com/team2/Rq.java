package com.team2;

import java.util.Arrays;
import java.util.Map;

public class Rq {
    private final String cmd;
    private final String[] cmdBits;

    public Rq(String cmd) {
        this.cmd = cmd;
        cmdBits = cmd.split(" ", 2);
    }

    public String[] getCmdBits() {
        return cmdBits;
    }

    public int getParamAsInt() {
        return Integer.parseInt(cmdBits[1]);
    }

    public String getActionName() {
        return cmdBits[0];
    }

}
