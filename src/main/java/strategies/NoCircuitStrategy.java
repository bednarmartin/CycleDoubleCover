package main.java.strategies;

import main.java.graph.Circuit;
import main.java.graph.Graph;

import java.util.List;

/**
 * Class representing what should happen with the circuits - nothing
 */
public class NoCircuitStrategy implements CircuitStrategy {
    /**
     * @param circuits circuits
     * @param graph    graph to be processed
     * @return the same circuits, unmodified
     */
    @Override
    public List<Circuit> getCircuits(List<Circuit> circuits, Graph graph) {
        return circuits;
    }
}
