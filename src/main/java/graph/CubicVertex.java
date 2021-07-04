package main.java.graph;

import main.java.exceptions.InconsistentGraphException;

import java.util.ArrayList;
import java.util.List;


/**
 * Class representing a vertex with three adjacent vertices
 */

public class CubicVertex implements Vertex {
    /**
     * The number of the vertex
     */
    private final int number;

    /**
     * List of the adjacent vertices
     */
    private final List<Vertex> neighbors;

    /**
     * List of circuits belonging to the vertex
     */
    private final List<Circuit> circuits;

    /**
     * Constructor of the class CubicVertex
     *
     * @param number number of the vertex
     */
    public CubicVertex(int number) {
        this.number = number;
        this.neighbors = new ArrayList<>(3);
        this.circuits = new ArrayList<>();
    }

    /**
     * @return the number of the vertex
     */
    @Override
    public int getNumber() {
        return this.number;
    }

    /**
     * Adds a vertex to a list of adjacent vertices
     *
     * @param neighbor a vertex to add
     */
    @Override
    public void addNeighbor(Vertex neighbor) throws InconsistentGraphException {
        if (this.neighbors.size() >= 3) {
            throw new InconsistentGraphException();
        }
        if (this.neighbors.contains(neighbor)) {
            throw new InconsistentGraphException();
        }
        this.neighbors.add(neighbor);
    }

    /**
     * @return An array of neighbors
     */
    @Override
    public List<Vertex> getNeighbors() {
        return this.neighbors;
    }

    /**
     * Adds a circuit to circuits belonging to the vertex
     *
     * @param circuit circuit to be added
     */
    @Override
    public void addCircuit(Circuit circuit) {
        this.circuits.add(circuit);

    }

    /**
     * Remove all the circuits belonging to the vertex
     */
    @Override
    public void clearCircuits() {
        this.circuits.clear();

    }

    /**
     * @return List of circuits belonging to the vertex
     */
    @Override
    public List<Circuit> getCircuits() {
        return this.circuits;
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }

    @Override
    public int hashCode() {
        return this.number;
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
            return ((Vertex) objectToCompare).getNumber() == this.number;
        }
    }
}
