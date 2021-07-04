package main.java.strategies;

import main.java.finders.CombinationChordFinder;
import main.java.graph.Circuit;
import main.java.graph.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing what should happen with the circuits - remove circuits with a chord
 */
public class NoChordCircuitsStrategy implements CircuitStrategy {
    /**
     * @param circuits circuits to be filtered
     * @param graph    graph to be processed
     * @return circuits without a chord
     */
    @Override
    public List<Circuit> getCircuits(List<Circuit> circuits, Graph graph) {
        List<Circuit> newCircuits = new ArrayList<>();
        for (Circuit circuit : circuits) {
            if (circuit.getChordEdges(new CombinationChordFinder(graph)).isEmpty()) {
                newCircuits.add(circuit);
            }
        }
        return newCircuits;
    }
}
