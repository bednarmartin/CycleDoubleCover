package main.java.determiners;

import main.java.graph.Graph;
import main.java.graph.Vertex;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing an algorithm for determining whether the graph is connected using DFS
 */
public class DFSConnectedGraphDeterminer implements ConnectedGraphDeterminer {
    /**
     * @param graph graph to be checked
     * @return True if the graph si connected
     */
    @Override
    public boolean isConnected(Graph graph) {
        List<Boolean> visited = new ArrayList<>();
        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            visited.add(false);
        }
        DFS(graph.getVertices().get(0), visited, graph);
        return !visited.contains(false);
    }

    /**
     * Depth-First Algorithm to determine whether there exists a path from the vertex to each other vertex of the graph
     *
     * @param vertex  vertex to process
     * @param visited List of visited vertices
     * @param graph   graph to be processed
     */
    private void DFS(Vertex vertex, List<Boolean> visited, Graph graph) {
        visited.set(vertex.getNumber(), true);
        for (Vertex neighbor : graph.getVertices().get(vertex.getNumber()).getNeighbors()) {
            if (!visited.get(neighbor.getNumber()))
                DFS(neighbor, visited, graph);
        }
    }
}
