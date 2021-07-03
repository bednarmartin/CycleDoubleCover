package main.java.graph;

import main.java.exceptions.InconsistentGraphException;

import java.util.List;

public interface Graph {

    int getNumberOfVertices();

    List<Vertex> getVertices();

    List<Edge> getEdges();

    void addVertex(Vertex vertex) throws InconsistentGraphException;

    void addEdge(Edge edge) throws InconsistentGraphException;

    boolean hasBridge();

    boolean hasThreeCut();

    boolean hasTwoCut();

    boolean isConnected();

    List<List<Edge>> getAllTwoCuts();

    List<List<Edge>> getAllThreeCuts();


}
