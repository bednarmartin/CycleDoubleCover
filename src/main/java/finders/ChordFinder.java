package main.java.finders;

import main.java.graph.Circuit;
import main.java.graph.Edge;

import java.util.List;

public interface ChordFinder {

    List<Edge> getChordEdges(Circuit circuit);
}

