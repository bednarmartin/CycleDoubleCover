package main.java.graph;

import main.java.exceptions.InconsistentGraphException;

/**
 * Class representing an edge of the cubic graph
 */

public class CubicEdge implements Edge {
    /**
     * The first vertex of the edge
     */
    private final Vertex first;
    /**
     * The second vertex of the edge
     */
    private final Vertex second;

    /**
     * Constructor of the class CubicEdge
     *
     * @param first  the first vertex of the edge
     * @param second the second vertex of the edge
     */
    public CubicEdge(Vertex first, Vertex second) throws InconsistentGraphException {
        if (first.equals(second)) {
            throw new InconsistentGraphException();
        }
        if (!first.getNeighbors().contains(second)) {
            first.addNeighbor(second);
        }
        if (!second.getNeighbors().contains(first)) {
            second.addNeighbor(first);
        }
        this.first = first;
        this.second = second;
    }

    /**
     * @return the first vertex of the edge
     */
    @Override
    public Vertex getFirst() {
        return this.first;
    }

    /**
     * @return the second vertex of the edge
     */
    @Override
    public Vertex getSecond() {
        return this.second;
    }

    @Override
    public String toString() {
        return "[" + this.first + ", " + this.second + "]";
    }

    @Override
    public int hashCode() {
        return 20 * this.first.hashCode() + 20 * this.second.hashCode() + 36;
    }

    @Override
    public boolean equals(Object objectToCompare) {
        if (this == objectToCompare) {
            return true;
        }
        if (objectToCompare == null) {
            return false;
        }
        if (getClass() != objectToCompare.getClass()) {
            return false;
        }
        boolean firstIsEqual = ((Edge) objectToCompare).getFirst().getNumber() == this.first.getNumber() ||
                ((Edge) objectToCompare).getSecond().getNumber() == this.first.getNumber();
        boolean secondIsEqual = ((Edge) objectToCompare).getFirst().getNumber() == this.second.getNumber() ||
                ((Edge) objectToCompare).getSecond().getNumber() == this.second.getNumber();
        return firstIsEqual && secondIsEqual;
    }
}
