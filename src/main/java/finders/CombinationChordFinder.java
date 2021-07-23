package main.java.finders;

import main.java.graph.Circuit;
import main.java.graph.Edge;
import main.java.graph.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing algorithm for finding chords in a graph by checking all edges in a graph
 */
public class CombinationChordFinder implements ChordFinder {
    /**
     * Graph to be processed
     */
    private final Graph graph;

    /**
     * Constructor for the class CombinationChordFinder
     *
     * @param graph graph to be processed
     */
    public CombinationChordFinder(Graph graph) {
        this.graph = graph;
    }

    /**
     * @param circuit circuit to be processed
     * @return List of the chord edges
     */
    @Override
    public List<Edge> getChordEdges(Circuit circuit) {
        List<Edge> chordEdges = new ArrayList<>();
        for (Edge edge : graph.getEdges()) {
            if (circuit.getEdges().contains(edge)) {
                continue;
            }
            boolean first = false;
            boolean second = false;
            for (Edge edgeToCheck : circuit.getEdges()) {
                if (hasFirst(edge, edgeToCheck)) {
                    first = true;
                }
                if (hasSecond(edge, edgeToCheck)) {
                    second = true;
                }
                if (first && second) {
                    chordEdges.add(edge);
                    break;
                }
            }
        }
        return chordEdges;
    }

    /**
     * Determine if the first vertex of the first edge belongs to the second edge
     *
     * @param first  first edge
     * @param second second edge
     * @return true if the first vertex of the first edge belongs to the second edge
     */
    private boolean hasFirst(Edge first, Edge second) {
        return first.getFirst().getNumber() == second.getFirst().getNumber() || first.getFirst().getNumber() == second.getSecond().getNumber();
    }

    /**
     * Determine if the second vertex of the first edge belongs to the second edge
     *
     * @param first  first edge
     * @param second second edge
     * @return true if the second vertex of the first edge belongs to the second edge
     */
    private boolean hasSecond(Edge first, Edge second) {
        return first.getSecond().getNumber() == second.getFirst().getNumber() || first.getSecond().getNumber() == second.getSecond().getNumber();
    }
}
