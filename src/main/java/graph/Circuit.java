package main.java.graph;

import main.java.finders.ChordFinder;

import java.util.List;

public interface Circuit {

    List<Edge> getEdges();

    List<Edge> getChordEdges(ChordFinder chordFinder);

    int getNumberOfEdges();

    int getId();

}
