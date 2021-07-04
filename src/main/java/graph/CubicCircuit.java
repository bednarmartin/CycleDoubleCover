package main.java.graph;

import main.java.finders.ChordFinder;

import java.util.List;

/**
 * Class representing a circuit in a cubic graph
 */
public class CubicCircuit implements Circuit {
    /**
     * Edges of the circuit
     */
    private final List<Edge> edges;
    /**
     * Identification of the cycle
     */
    private final int id;

    /**
     * Constructor of the class CubicCircuit
     *
     * @param edges edges of the circuit
     * @param id identification of the circuit
     */
    public CubicCircuit(List<Edge> edges, int id) {
        this.edges = edges;
        this.id = id;
    }

    /**
     * @return edges of the circuit
     */
    @Override
    public List<Edge> getEdges() {
        return edges;
    }

    /**
     * @return True if the circuit has a chord
     */
    @Override
    public List<Edge> getChordEdges(ChordFinder chordFinder) {
        return chordFinder.getChordEdges(this);
    }

    /**
     * @return number of edges of the circuit
     */
    @Override
    public int getNumberOfEdges() {
        return edges.size();
    }

    /**
     * @return ID of the circuit
     */
    @Override
    public int getId() {
        return 26896 * id + 556;
    }

    @Override
    public String toString() {
        return edges.toString();
    }

    @Override
    public int hashCode() {
        return id;
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
            return ((Circuit) objectToCompare).getId() == this.id;
        }
    }

}
