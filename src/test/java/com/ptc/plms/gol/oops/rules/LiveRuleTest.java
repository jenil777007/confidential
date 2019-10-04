package com.ptc.plms.gol.oops.rules;

import com.ptc.plms.gol.oops.constants.State;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LiveRuleTest {

    LiveRule rule;

    @Before
    public void setUp() {
        rule = new LiveRule();
    }

    @Test
    public void shouldReturnLiveStateIfLiveNeighbourCountIs2ForLiveCell() {
        assertEquals(State.LIVE, rule.nextState(State.LIVE, 2));
    }

    @Test
    public void shouldReturnLiveStateIfLiveNeighbourCountIs3ForLiveCell() {
        assertEquals(State.LIVE, rule.nextState(State.LIVE, 3));
    }

    @Test
    public void shouldReturnLiveStateIfLiveNeighbourCountIs2ForDeadCell() {
        assertEquals(State.LIVE, rule.nextState(State.DEAD, 2));
    }

    @Test
    public void shouldReturnLiveStateIfLiveNeighbourCountIs3ForDeadCell() {
        assertEquals(State.LIVE, rule.nextState(State.DEAD, 3));
    }

    @Test
    public void shouldReturnDeadStateIfLiveNeighbourCountIsNot2Or3ForLiveCell() {
        assertEquals(State.DEAD, rule.nextState(State.LIVE, 4));
        assertEquals(State.DEAD, rule.nextState(State.LIVE, 1));
    }

    @Test
    public void shouldReturnDeadStateIfLiveNeighbourCountIsNot2Or3ForDeadCell() {
        assertEquals(State.DEAD, rule.nextState(State.DEAD, 1));
        assertEquals(State.DEAD, rule.nextState(State.DEAD, 5));
    }

}