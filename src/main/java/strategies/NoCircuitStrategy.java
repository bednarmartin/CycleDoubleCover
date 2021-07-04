package main.java.strategies;

import main.java.graph.Circuit;
import main.java.graph.Graph;

import java.util.List;

public class NoCircuitStrategy implements CircuitStrategy {
    @Override
    public List<Circuit> getCircuits(List<Circuit> circuits, Graph graph) {
        return circuits;
    }
}
