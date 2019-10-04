package com.ptc.plms.gol.oops.rules;

import com.ptc.plms.gol.oops.constants.State;

public class RuleFactory {

    public static Rule getRule(State state) {

        if (state.equals(State.LIVE))
            return new LiveRule();
        else
            return new DeadRule();

    }

}
