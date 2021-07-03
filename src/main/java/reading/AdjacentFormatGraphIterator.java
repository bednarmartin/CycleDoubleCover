package main.java.reading;

import main.java.graph.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class AdjacentFormatGraphIterator implements GraphIterator {
    /**
     * Logger of the class
     */
    private static final Logger LOGGER = Logger.getLogger(AdjacentFormatGraphIterator.class.getName());

    private final int NUMBER_OF_GRAPHS;

    private final int NUMBER_OF_VERTICES;

    private int counter;

    private final BufferedReader BUFFERED_READER;

    public AdjacentFormatGraphIterator(String path) throws IOException {
        this.BUFFERED_READER = new BufferedReader(new FileReader(path));
        int numberOfLines;
        try {
            numberOfLines = (int) Files.lines(Paths.get(path), Charset.defaultCharset()).count();
        } catch (Exception e) {
            LOGGER.severe("PATH: " + path + " - Error during counting number of lines!");
            throw new IOException();
        }
        try {
            this.NUMBER_OF_VERTICES = Integer.parseInt(BUFFERED_READER.readLine());
        } catch (NumberFormatException e) {
            LOGGER.severe("PATH: " + path + " - Wrong format of the first row of the file!");
            throw new IOException();
        }
        this.NUMBER_OF_GRAPHS = (numberOfLines + 2) / (NUMBER_OF_VERTICES + 1);
        this.counter = 0;
    }


    @Override
    public boolean hasNext() {
        return counter < getNumberOfGraphs();
    }

    @Override
    public Graph next() {
        Graph graph = new CubicGraph();
        try {
            for (int i = 0; i < NUMBER_OF_VERTICES; i++) graph.addVertex(new CubicVertex(i));
            for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
                String line = BUFFERED_READER.readLine();
                String[] splitLine = line.split(" ");
                for (String s : splitLine) {
                    int toVertex = Integer.parseInt(s);
                    if (i < toVertex) {
                        graph.addEdge(new CubicEdge(graph.getVertices().get(i), graph.getVertices().get(toVertex)));
                    }
                }
            }
            counter++;
            if (hasNext()) {
                BUFFERED_READER.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return graph;
    }

    @Override
    public int getNumberOfGraphs() {
        return NUMBER_OF_GRAPHS;
    }

    @Override
    public int getNumberOfVertices() {
        return NUMBER_OF_VERTICES;
    }
}
