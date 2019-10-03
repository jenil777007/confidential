package com.ptc.plms.gol.oops;

import java.util.Set;

import com.ptc.plms.gol.oops.rules.Rule;

/**
 * 
 * @author hdhingra
 *
 */
public interface GameStratedy {

	Set<Cell> findNeighbours(Cell cellFromCurrentGeneration, Set<Cell> liveCells);
	Rule[] getRules();
	void setRules(Rule[] rules);
}
