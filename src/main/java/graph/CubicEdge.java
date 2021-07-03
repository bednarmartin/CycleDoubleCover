package main.java.graph;

import main.java.exceptions.InconsistentGraphException;

import java.util.logging.Logger;

/**
 * Class representing an edge of the cubic graph
 */

public class CubicEdge implements Edge {
    /**
     * Logger of the class
     */
    private static final Logger LOGGER = Logger.getLogger(CubicEdge.class.getName());
    /**
     * The first vertex of the edge
     */
    private final Vertex FIRST;
    /**
     * The second vertex of the edge
     */
    private final Vertex SECOND;

    /**
     * Constructor of the class CubicEdge
     *
     * @param first  the first vertex of the edge
     * @param second the second vertex of the edge
     */
    public CubicEdge(Vertex first, Vertex second) throws InconsistentGraphException {
        if (first.equals(second)) {
            LOGGER.warning("CubicEdge [" + first + " " + second + "] was supposed to be created");
            throw new InconsistentGraphException();
        }
        if (!first.getNeighbors().contains(second)) {
            first.addNeighbor(second);
        }
        if (!second.getNeighbors().contains(first)) {
            second.addNeighbor(first);
        }
        this.FIRST = first;
        this.SECOND = second;
        LOGGER.info("CubicEdge object " + this + " created");
    }

    /**
     * @return the first vertex of the edge
     */
    @Override
    public Vertex getFirst() {
        LOGGER.finest("CubicEdge " + this + " -> first vertex " + this.FIRST + " returned");
        return this.FIRST;
    }

    /**
     * @return the second vertex of the edge
     */
    @Override
    public Vertex getSecond() {
        LOGGER.finest("CubicEdge " + this + " -> second vertex " + this.SECOND + " returned");
        return this.SECOND;
    }

    @Override
    public String toString() {
        return "[" + this.FIRST + ", " + this.SECOND + "]";
    }

    @Override
    public int hashCode() {
        return 20 * this.FIRST.hashCode() + 20 * this.SECOND.hashCode() + 36;
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
        boolean firstIsEqual = ((Edge) objectToCompare).getFirst().getNumber() == this.FIRST.getNumber() ||
                ((Edge) objectToCompare).getSecond().getNumber() == this.FIRST.getNumber();
        boolean secondIsEqual = ((Edge) objectToCompare).getFirst().getNumber() == this.SECOND.getNumber() ||
                ((Edge) objectToCompare).getSecond().getNumber() == this.SECOND.getNumber();
        return firstIsEqual && secondIsEqual;
    }
}
