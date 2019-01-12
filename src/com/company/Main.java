package com.company;

import algorithm.Algorithm;
import com.company.graph.Graph;
import com.company.managers.*;


public class Main {

    public static void main(String[] args) {

        System.setProperty("org.graphstream.ui", "javafx");

        ReaderHelper readerHelper = new ReaderHelper();
        GraphUtils graphUtils = new GraphUtils();
        GraphManager graphManager = new GraphManager(readerHelper, graphUtils);
        String resourcePath = System.getProperty("user.dir") + "\\resources\\";
        Graph graph = graphManager.createGraph(
                resourcePath + "Graph.txt",
                resourcePath + "Alpha.txt",
                resourcePath + "Beta.txt",
                resourcePath + "S.txt",
                resourcePath + "OptimizationParams.txt");

        GraphPrinter graphPrinter = new GraphPrinter(graph);
        graphPrinter.printGraph();

        Algorithm algorithm = new Algorithm(graph);
        algorithm.run(graph.getMaxCost(), graph.getMinReliability());
        algorithm.printPathsWithProbabilities();

        graphPrinter.printGraph();
    }
}
