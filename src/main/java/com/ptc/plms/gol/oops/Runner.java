package com.ptc.plms.gol.oops;

import com.ptc.plms.gol.oops.constants.State;
import com.ptc.plms.gol.oops.models.Cell;
import com.ptc.plms.gol.oops.rules.RuleFactory;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Runner {

//    private GameStrategy gameStrategy;
//
//    public Runner(GameStrategy gameStrategy) {
//        this.gameStrategy = gameStrategy;
//    }


    /**
     * Returns next generation for passed generation
     *
     * @param currentGeneration
     * @return set containing alive cells
     */
    public Set<Cell> getNextGeneration(Set<Cell> currentGeneration) {
        HashSet<Cell> nextGeneration = new HashSet<Cell>();

        Set<Cell> neighbouringCells;

        if (currentGeneration != null) {
            for (Cell cellFromCurrentGeneration : currentGeneration) {
                processCell(cellFromCurrentGeneration, currentGeneration, nextGeneration);

                neighbouringCells = cellFromCurrentGeneration.findNeighbours(currentGeneration);

                for (Cell neighbouringCell : neighbouringCells) {
                    processCell(neighbouringCell, currentGeneration, nextGeneration);
                }
            }
        }

        return filterDead(nextGeneration);
    }

    /**
     * Fetches number of live neighbours around passed cell;
     * Gets appropriate rule according to the current state of passed cell;
     * Determines the next state via rule application
     *
     * @param cell
     * @param currentGeneration
     * @param nextGeneration
     */
    private void processCell(Cell cell, Set<Cell> currentGeneration, Set<Cell> nextGeneration) {
        if (nextGeneration.contains(cell)) return; // already processed

        cell = cell.createCopy();

        int count = cell.findLiveNeighbourCount(currentGeneration);
        State nextState = RuleFactory.getRule(cell.getState()).nextState(cell.getState(), count);

        cell.setState(nextState);
        nextGeneration.add(cell);
    }

    /**
     * Filters Dead cells from passed generation
     *
     * @param nextGeneration
     * @return Set containing live cells
     */
    private Set<Cell> filterDead(HashSet<Cell> nextGeneration) {
        Iterator<Cell> iterator = nextGeneration.iterator();

        while (iterator.hasNext()) {
            if (State.DEAD.equals(iterator.next().getState())) {
                iterator.remove();
            }
        }

        return nextGeneration;
    }

}
