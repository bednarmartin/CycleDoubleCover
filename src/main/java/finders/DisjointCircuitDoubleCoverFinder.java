package main.java.finders;

import main.java.exceptions.StopRecursionException;
import main.java.graph.*;
import main.java.strategies.CDCStrategy;
import main.java.strategies.CircuitStrategy;

import java.util.*;

/**
 * Class representing an algorithm for finding Circuit Double Covers using Set of Edges that are already covered
 */
public class DisjointCircuitDoubleCoverFinder implements CircuitDoubleCoverFinder {
    /**
     * graph to be processed
     */
    private final Graph graph;
    /**
     * circuits of the graph
     */
    private final List<Circuit> circuits;
    /**
     * already checked combinations of the circuits
     */
    private final Set<Set<Circuit>> used;
    /**
     * what should happen after finding a Circuit Double Cover
     */
    private final CDCStrategy cdcStrategy;

    /**
     * Constructor for the DisJointCircuitDoubleCoverFinder class
     *
     * @param graph          graph to be processed
     * @param circuitsFinder algorithm for finding circuits in the graph
     * @param cdcStrategy    what should happened after finding a Circuit Double Cover
     */
    public DisjointCircuitDoubleCoverFinder(Graph graph, CircuitsFinder circuitsFinder, CDCStrategy cdcStrategy, CircuitStrategy circuitStrategy) {
        this.graph = graph;
        this.used = new HashSet<>();
        this.cdcStrategy = cdcStrategy;
        this.circuits = circuitStrategy.getCircuits(graph.getCircuits(circuitsFinder), graph);
    }

    /**
     * Finds Circuit Double Covers of the Graph
     *
     * @return output according to the CDCStrategy
     */
    @Override
    public String getCircuitDoubleCovers() {
        Circuit[] pair = new Circuit[2];
        try {
            findAllCombinations(pair, 0, circuits.size() - 1, 0, 2);
        } catch (StopRecursionException e) {
            return cdcStrategy.getResult();
        }
        return cdcStrategy.getResult();
    }

    /**
     * Generate all combinations
     *
     * @param data  actual combination
     * @param start start
     * @param end   end
     * @param index actual index
     * @param size  size of combination
     * @throws StopRecursionException when algorithm should stop before processing all the combinations
     */
    private void findAllCombinations(Circuit[] data, int start, int end, int index, int size) throws StopRecursionException {
        if (index == size) {
            process(new HashSet<>(Arrays.asList(data)), new HashSet<>(), data[1]);
            return;

        }
        for (int i = start; i <= end && end - i + 1 >= size - index; i++) {
            data[index] = circuits.get(i);
            findAllCombinations(data, i + 1, end, index + 1, size);
        }
    }

    /**
     * Process the actual combination of 2 circuits
     *
     * @param toCheck           actual Set of circuits to be checked
     * @param twoTimesUsedEdges Set of Edges that are already covered
     * @param last              Circuit added last
     * @throws StopRecursionException when algorithm should stop before processing all the combinations
     */
    private void process(Set<Circuit> toCheck, Set<Edge> twoTimesUsedEdges, Circuit last) throws StopRecursionException {

        processTwoTimesUsedEdges(toCheck, twoTimesUsedEdges, last);

        if (twoTimesUsedEdges.size() == graph.getEdges().size()) {
            CircuitDoubleCover circuitDoubleCover = new CubicCircuitDoubleCover(new ArrayList<>(toCheck));
            cdcStrategy.processCDC(circuitDoubleCover, graph);
            return;
        }

        for (Circuit circuit : circuits) {
            if (Collections.disjoint(circuit.getEdges(), twoTimesUsedEdges) && !toCheck.contains(circuit)) {
                Set<Circuit> newToCheck = new HashSet<>(toCheck);
                newToCheck.add(circuit);
                if (!used.contains(newToCheck)) {
                    used.add(newToCheck);
                    process(newToCheck, new HashSet<>(twoTimesUsedEdges), circuit);
                }

            }
        }
    }

    /**
     * Process the last added circuit in order to find new edges that are already covered
     *
     * @param toCheck           actual Set of circuits to be checked
     * @param twoTimesUsedEdges Set of Edges that are already covered
     * @param last              Circuit added last
     */
    private void processTwoTimesUsedEdges(Set<Circuit> toCheck, Set<Edge> twoTimesUsedEdges, Circuit last) {
        for (Circuit circuit : toCheck) {
            if (circuit.equals(last)) {
                continue;
            }
            for (Edge edge : circuit.getEdges()) {
                if (last.getEdges().contains(edge)) {
                    twoTimesUsedEdges.add(edge);
                }
            }
        }
    }
}
