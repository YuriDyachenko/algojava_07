package kurs;

public class GraphGenerator {
    private final Graph graph;

    public GraphGenerator() {
        graph = new Graph();

        graph.add('A');
        graph.add('B');
        graph.add('C');
        graph.add('D');
        graph.add('E');
        graph.add('F');

        graph.addAdjacency('A', 'B');
        graph.addAdjacency('B', 'C');
        graph.addAdjacency('A', 'D');
        graph.addAdjacency('D', 'E');
        graph.addAdjacency('A', 'F');
    }

    public Graph getGraph() {
        return graph;
    }
}
