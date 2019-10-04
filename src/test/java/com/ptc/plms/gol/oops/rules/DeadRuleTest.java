package com.ptc.plms.gol.oops.rules;

import com.ptc.plms.gol.oops.constants.State;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeadRuleTest {

    DeadRule rule;

    @Before
    public void setUp() {
        rule = new DeadRule();
    }

    @Test
    public void shouldReturnCurrentStateWhenLiveNeighbourCountIsNot3() {
        assertEquals(State.DEAD, rule.nextState(State.DEAD, 2));
        assertEquals(State.LIVE, rule.nextState(State.LIVE, 5));
    }

    @Test
    public void shouldReturnLiveStateWhenLiveNeighbourCountIsEqualTo3() {
        assertEquals(State.LIVE, rule.nextState(State.DEAD, 3));
        assertEquals(State.LIVE, rule.nextState(State.LIVE, 3));
    }
}