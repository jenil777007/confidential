package com.ptc.plms.gol.oops.rules;

import com.ptc.plms.gol.oops.constants.State;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RuleFactoryTest {

    @Test
    public void shouldReturnLiveRuleClassObjectIfCellStateIsLive() {
        assertEquals(new LiveRule().getClass(), RuleFactory.getRule(State.LIVE).getClass());
    }

    @Test
    public void shouldReturnDeadRuleClassObjectIfCellStateIsDead() {
        assertEquals(new DeadRule().getClass(), RuleFactory.getRule(State.DEAD).getClass());
    }
}