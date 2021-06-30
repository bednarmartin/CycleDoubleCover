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
    private final Logger LOGGER;

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
        this.LOGGER = Logger.getLogger(this.getClass().getName());
        this.NEIGHBORS = new ArrayList<>(3);
        LOGGER.info("New CubicVertex number " + this.NUMBER + " created");
    }

    /**
     * @return the number of the vertex
     */
    @Override
    public int getNumber() {
        LOGGER.finest("The number of the vertex number " + this.NUMBER + " accessed");
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
            LOGGER.warning("Inconsistent state of a CubicVertex number " + this.getNumber() +
                    " -> number of neighbors = " + this.NEIGHBORS.size());
            throw new InconsistentGraphException();
        }
        if (this.NEIGHBORS.contains(neighbor)) {
            LOGGER.warning("Inconsistent state of a CubicVertex number " + this.getNumber() +
                    " -> vertex number " + neighbor.getNumber() + " already in array");
            throw new InconsistentGraphException();
        }
        this.NEIGHBORS.add(neighbor);
        LOGGER.info("A new neighbor of CubicVertex number " + this.NUMBER + " with number "
                + neighbor.getNumber() + " added");
    }

    /**
     * @return An array of neighbors
     */
    @Override
    public List<Vertex> getNeighbors() {
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
