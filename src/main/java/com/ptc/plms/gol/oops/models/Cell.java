package com.ptc.plms.gol.oops.models;

import com.ptc.plms.gol.oops.constants.State;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hdhingra
 */
public class Cell {

    private final int x, y;
    private State state;

    public Cell(int x, int y) {
        this(x, y, State.DEAD);
    }

    public Cell(int x, int y, State state) {
        this.x = x;
        this.y = y;
        this.state = state;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }


    public Set<Cell> findNeighbours(Set<Cell> generation) {
        HashSet<Cell> neighbours = new HashSet<Cell>();

        for (int i = x - 1; i <= x + 1; i++) {
            if (i < 0) continue;

            for (int j = y - 1; j <= y + 1; j++) {
                if (j < 0) continue;

                Cell neighbour = new Cell(i, j);
                if (generation.contains(neighbour)) {
                    neighbour.setState(State.LIVE);
                }
                neighbours.add(neighbour);
            }
        }

        return neighbours;
    }

    public int findLiveNeighbourCount(Set<Cell> generation) {
        int count = 0;
        for (Cell c : this.findNeighbours(generation)) {
            if (State.LIVE.equals(c.getState())) count++;
        }
        return count;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        if (this == obj)
            return true;
        Cell other = (Cell) obj;
        if (x != other.x || y != other.y)
            return false;
        return true;
    }

    public Cell createCopy() {
        return new Cell(x, y, state);
    }

}
