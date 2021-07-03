package main.java.graph;

import main.java.exceptions.InconsistentGraphException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


/**
 * Class representing a vertex with three adjacent vertices
 */

public class CubicVertex implements Vertex {

    /**
     * Logger of the class
     */
    private static final Logger LOGGER = Logger.getLogger(CubicVertex.class.getName());

    /**
     * The number of the vertex
     */
    private final int NUMBER;

    /**
     * List of the adjacent vertices
     */
    private final List<Vertex> NEIGHBORS;

    /**
     * Constructor of the class CubicVertex
     *
     * @param number number of the vertex
     */
    public CubicVertex(int number) {
        this.NUMBER = number;
        this.NEIGHBORS = new ArrayList<>(3);
        LOGGER.info("CubicVertex " + this + " created");
    }

    /**
     * @return the number of the vertex
     */
    @Override
    public int getNumber() {
        LOGGER.finest("The number of the CubicVertex " + this + " returned");
        return this.NUMBER;
    }

    /**
     * Adds a vertex to a list of adjacent vertices
     *
     * @param neighbor a vertex to add
     */
    @Override
    public void addNeighbor(Vertex neighbor) throws InconsistentGraphException {
        if (this.NEIGHBORS.size() >= 3) {
            LOGGER.warning("Inconsistent state of a CubicVertex " + this +
                    " -> number of neighbors = " + this.NEIGHBORS.size());
            throw new InconsistentGraphException();
        }
        if (this.NEIGHBORS.contains(neighbor)) {
            LOGGER.warning("Inconsistent state of a CubicVertex " + this +
                    " -> vertex number " + neighbor.getNumber() + " already in a list");
            throw new InconsistentGraphException();
        }
        this.NEIGHBORS.add(neighbor);
        LOGGER.info("A new neighbor of CubicVertex " + this + " with number "
                + neighbor + " added");
    }

    /**
     * @return An array of neighbors
     */
    @Override
    public List<Vertex> getNeighbors() {
        LOGGER.finest("Neighbors of the CubicVertex " + this + " returned");
        return this.NEIGHBORS;
    }

    @Override
    public String toString() {
        return String.valueOf(this.NUMBER);
    }

    @Override
    public int hashCode() {
        return this.NUMBER;
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
        } else {
            return ((Vertex) objectToCompare).getNumber() == this.NUMBER;
        }
    }
}
