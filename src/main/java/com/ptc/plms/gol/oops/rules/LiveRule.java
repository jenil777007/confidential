package com.ptc.plms.gol.oops.rules;

import com.ptc.plms.gol.oops.constants.State;

public class LiveRule implements Rule {

    @Override
    public State nextState(State currentState, int liveNeighbours) {

        if (liveNeighbours == 2 || liveNeighbours == 3) {
            return State.LIVE;
        }

        return State.DEAD;
    }
}
