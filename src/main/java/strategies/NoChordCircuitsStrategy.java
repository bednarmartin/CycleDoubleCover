package main.java.strategies;

import main.java.finders.CombinationChordFinder;
import main.java.graph.Circuit;
import main.java.graph.Graph;

import java.util.ArrayList;
import java.util.List;

public class NoChordCircuitsStrategy implements CircuitStrategy {
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
