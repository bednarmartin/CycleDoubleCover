package main.java.finders;

import main.java.graph.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class representing an algorithm for finding circuits in the graph using DFS
 */
public class DFSCircuitsFinder implements CircuitsFinder {
    /**
     * Set of Set of Edges in order to eliminate duplicates
     */
    private final Set<Set<Edge>> allCircuits = new HashSet<>();

    /**
     * @param graph graph to be processed
     * @return List of all the circuits in the graph
     */
    @Override
    public List<Circuit> getCircuits(Graph graph) {
        allCircuits.clear();
        List<Circuit> circuits = new ArrayList<>();
        for (var i = 3; i <= graph.getNumberOfVertices(); i++) {
            findCircuitsOfLength(i, graph);
        }
        var counter = 0;
        for (Set<Edge> edges : allCircuits) {
            circuits.add(new CubicCircuit(new ArrayList<>(edges), ++counter));
        }
        return circuits;
    }

    /**
     * @param number length of the circuits to be found]
     * @param graph  graph to be processed
     */
    private void findCircuitsOfLength(int number, Graph graph) {
        var marked = new boolean[graph.getNumberOfVertices()];
        for (var i = 0; i < graph.getNumberOfVertices() - (number - 1); i++) {
            List<Vertex> vertices = new ArrayList<>();
            vertices.add(graph.getVertices().get(i));
            dfs(marked, number - 1, graph.getVertices().get(i), graph.getVertices().get(i), vertices, graph);
            marked[i] = true;
        }
    }

    /**
     * DFS algorithm modified to find all the circuits in the graph
     *
     * @param marked   marked vertices
     * @param n        vertices remaining
     * @param vertex   actual vertex
     * @param start    starting vertex
     * @param vertices list of vertices
     * @param graph    graph to be processed
     */
    private void dfs(boolean[] marked, int n, Vertex vertex, Vertex start, List<Vertex> vertices, Graph graph) {
        marked[vertex.getNumber()] = true;
        if (n == 0) {
            marked[vertex.getNumber()] = false;
            if (vertex.getNeighbors().contains(start)) {
                allCircuits.add(makeSetOfEdges(vertices, start));
            }
            return;

        }
        for (var i = 0; i < graph.getNumberOfVertices(); i++) {
            if (!marked[i] && vertex.getNeighbors().contains(graph.getVertices().get(i))) {
                List<Vertex> newVertices = new ArrayList<>(vertices);
                newVertices.add(graph.getVertices().get(i));
                dfs(marked, n - 1, graph.getVertices().get(i), start, newVertices, graph);
            }
        }
        marked[vertex.getNumber()] = false;
    }

    /**
     * @param vertices list of vertices to transform
     * @return Set of edges representing a circuit
     */

    private Set<Edge> makeSetOfEdges(List<Vertex> vertices, Vertex start) {
        vertices.add(start);
        Set<Edge> edges = new HashSet<>();
        try {
            for (var i = 1; i < vertices.size(); i++) {
                edges.add(new CubicEdge(vertices.get(i - 1), vertices.get(i)));
            }
            vertices.remove(vertices.size() - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return edges;
    }

}
