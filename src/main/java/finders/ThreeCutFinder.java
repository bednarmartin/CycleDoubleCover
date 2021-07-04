package main.java.finders;

import main.java.graph.Edge;
import main.java.graph.Graph;

import java.util.List;

public interface ThreeCutFinder {

    List<List<Edge>> getThreeCuts(Graph graph);
}
