package main.java.finders;

import main.java.graph.Circuit;
import main.java.graph.CircuitDoubleCover;
import main.java.graph.Edge;
import main.java.graph.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing an algorithm for finding all the strong edges in a Circuit Double Cover by comparing circuits
 */
public class ComparisonStrongEdgesFinder implements StrongEdgesFinder {
    /**
     * Graph to be processed
     */
    private final Graph graph;

    /**
     * Constructor for the class ComparisonStrongEdgesFinder
     *
     * @param graph graph to be processed
     */
    public ComparisonStrongEdgesFinder(Graph graph) {
        this.graph = graph;
    }

    /**
     * @param circuitDoubleCover Circuit Double Cover to be checked
     * @return List of strong edges
     */
    @Override
    public List<Edge> getStrongEdges(CircuitDoubleCover circuitDoubleCover) {
        List<Edge> strongEdges = new ArrayList<>();
        process(circuitDoubleCover);
        for (Edge edge : graph.getEdges()) {
            if (!edge.getFirst().getCircuits().equals(edge.getSecond().getCircuits())) {
                strongEdges.add(edge);
            }
        }
        clear();
        return strongEdges;

    }

    /**
     * Adds all the circuits belonging to the vertices
     *
     * @param circuitDoubleCover Circuit Double Cover to be processed
     */
    private void process(CircuitDoubleCover circuitDoubleCover) {
        for (Circuit circuit : circuitDoubleCover.getCircuits()) {
            for (Edge edge : circuit.getEdges()) {
                edge.getFirst().addCircuit(circuit);
                edge.getSecond().addCircuit(circuit);
            }
        }
    }

    /**
     * Clear all the Lists of the Circuits belonging to the vertices
     */
    private void clear() {
        for (Edge edge : graph.getEdges()) {
            edge.getFirst().clearCircuits();
            edge.getSecond().clearCircuits();
        }
    }
}
