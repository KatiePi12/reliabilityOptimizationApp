package com.company;

import com.company.graph.Graph;
import com.company.managers.GraphManager;
import com.company.managers.GraphPrinter;
import com.company.managers.GraphUtils;
import com.company.managers.ReaderHelper;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GraphApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    protected String styleSheet = "graph {padding: 60px;}";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ReliabilityOptimizationApp");
        Button btn = new Button();
        btn.setText("Run algorithm'");
        btn.setLayoutX(375);
        btn.setLayoutY(50);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

//        Pane root = new Pane();
////        root.getChildren().add(btn);
////        primaryStage.setScene(new Scene(root, 800, 650));
////        primaryStage.show();

        System.setProperty("org.graphstream.ui", "javafx");
//        System.setProperty("gs.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");

        ReaderHelper readerHelper = new ReaderHelper();
        GraphUtils graphUtils = new GraphUtils();
        GraphManager graphManager = new GraphManager(readerHelper, graphUtils);
        String resourcePath = System.getProperty("user.dir") + "\\resources\\";
        Graph graph = graphManager.createGraph(
                resourcePath + "testGraph.txt",
                resourcePath + "testAlpha.txt",
                resourcePath + "testBeta.txt",
                resourcePath + "testS.txt",
                resourcePath + "optimizationParams.txt");

        double maximumCost = 5000000;
        double minimumReliability = 0.99;

        GraphPrinter graphPrinter = new GraphPrinter(graph);
        org.graphstream.graph.Graph graphToBePrinted = graphPrinter.getGraphToBePrinted();

        graphToBePrinted.display();

//        Viewer viewer = graphPrinter.printGraph();
//        View view = viewer.addDefaultView(false);
//        JFrame frame = new JFrame();
//        frame.add(new SwingNode(view));

//        FxViewer v = new FxViewer(graphToBePrinted, FxViewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
//        DorogovtsevMendesGenerator gen = new DorogovtsevMendesGenerator();
//
//        graphToBePrinted.setAttribute("ui.antialias");
//        graphToBePrinted.setAttribute("ui.quality");
//        graphToBePrinted.setAttribute("ui.stylesheet", styleSheet);
//
//        v.enableAutoLayout();
//        FxViewPanel panel = (FxViewPanel)v.addDefaultView(false, new FxGraphRenderer());
//
//        gen.addSink(graphToBePrinted);
//        gen.begin();
//        for(int i = 0 ; i < 100 ; i++)
//            gen.nextEvents();
//        gen.end();
//        gen.removeSink(graphToBePrinted);
//
//        Scene scene = new Scene(panel, 800, 600);
//        primaryStage.setScene(scene);
//
//        primaryStage.show();
    }

    public void createSimpleGraph() {


//        GraphPrinter graphPrinter = new GraphPrinter(graph);
//        swingNode.setContent(graphPrinter.printGraph());
//
//        FxViewer viewer = new FxViewer(graph, FxViewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);

//        Algorithm algorithm = new Algorithm(graph);
//        algorithm.run(maximumCost, minimumReliability);
//        algorithm.printPathsWithProbabilities();
//
//        graphPrinter.printGraph();
    }
}
