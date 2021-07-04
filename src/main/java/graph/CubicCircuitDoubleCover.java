package main.java.graph;

import main.java.finders.StrongEdgesFinder;

import java.util.List;

/**
 * Class representing a Circuit Double Cover
 */
public class CubicCircuitDoubleCover implements CircuitDoubleCover {
    /**
     * List of circuits of the Circuit Double Cover
     */
    private final List<Circuit> circuits;

    /**
     * Constructor for the class CubicCircuitDoubleCover
     *
     * @param circuits List of circuits
     */
    public CubicCircuitDoubleCover(List<Circuit> circuits) {
        this.circuits = circuits;
    }

    /**
     * @return circuits of the Circuit Double Cover
     */
    @Override
    public List<Circuit> getCircuits() {
        return circuits;
    }

    /**
     * @param strongEdgesFinder algorithm for finding strong edges
     * @return List of strong edges
     */
    @Override
    public List<Edge> getStrongEdges(StrongEdgesFinder strongEdgesFinder) {
        return strongEdgesFinder.getStrongEdges(this);
    }

}
