package com.ptc.plms.gol.oops;

import com.ptc.plms.gol.oops.models.Cell;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertTrue;

public class RunnerTest {

    Runner runner;

    @Before
    public void setUp() {
        this.runner = new Runner();
    }

    @Test
    public void shouldReturnEmptySetIfCurrentGenerationIsNull() {
        assertTrue(runner.getNextGeneration(null).isEmpty());
    }

    @Test
    public void shouldReturnEmptySetIfCurrentGenerationIsEmpty() {
        assertTrue(runner.getNextGeneration(Collections.<Cell>emptySet()).isEmpty());
    }


}
