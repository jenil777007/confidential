package com.ptc.plms.gol.oops;

import com.ptc.plms.gol.oops.rules.Rule;

import java.util.Set;

/**
 * @author hdhingra
 */
public interface GameStratedy {

    Set<Cell> findNeighbours(Cell cellFromCurrentGeneration, Set<Cell> liveCells);

    Rule[] getRules();

    void setRules(Rule[] rules);
}
