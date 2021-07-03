package main.java.graph;

import main.java.exceptions.InconsistentGraphException;

import java.util.List;
import java.util.Set;

public interface Graph {

    int getNumberOfVertices();

    List<Vertex> getVertices();

    Set<Edge> getEdges();

    void addVertex(Vertex vertex) throws InconsistentGraphException;

    void addEdge(Edge edge) throws InconsistentGraphException;


}
