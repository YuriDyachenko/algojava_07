package kurs;

public class Main {

    public static void main(String[] args) {
        GraphGenerator gg = new GraphGenerator();
        //задание 7.1
        exampleOfGraph();
        //задание 7.2
        baseGraphMethods(gg);
        //задание 7.3
        depthFirstWalk(gg);
        //задание 7.4
        breadthFirstWalk(gg);
    }

    private static void breadthFirstWalk(GraphGenerator gg) {
        System.out.println("- - - - - Задание 7.4 - - - - -");
        Graph graph = gg.getGraph();
        Duration duration = new Duration();

        duration.fix();
        String resStartForA = graph.breadthFirstWalk('A');
        duration.outAndFix("breadthFirstWalk('A')");
        System.out.println(" " + resStartForA);

        duration.fix();
        String resStartForC = graph.breadthFirstWalk('C');
        duration.outAndFix("breadthFirstWalk('C')");
        System.out.println(" " + resStartForC);

        duration.fix();
        String resStartForE = graph.breadthFirstWalk('E');
        duration.outAndFix("breadthFirstWalk('E')");
        System.out.println(" " + resStartForE);
    }

    private static void depthFirstWalk(GraphGenerator gg) {
        System.out.println("- - - - - Задание 7.3 - - - - -");
        Graph graph = gg.getGraph();
        Duration duration = new Duration();

        duration.fix();
        String resStartForA = graph.depthFirstWalk('A');
        duration.outAndFix("depthFirstWalk('A')");
        System.out.println(" " + resStartForA);

        duration.fix();
        String resStartForC = graph.depthFirstWalk('C');
        duration.outAndFix("depthFirstWalk('C')");
        System.out.println(" " + resStartForC);

        duration.fix();
        String resStartForE = graph.depthFirstWalk('E');
        duration.outAndFix("depthFirstWalk('E')");
        System.out.println(" " + resStartForE);
    }

    private static void baseGraphMethods(GraphGenerator gg) {
        System.out.println("- - - - - Задание 7.2 - - - - -");
        Graph graph = gg.getGraph();
        for (int i = 0; i < graph.getSize(); i++) {
            System.out.println(graph.get(i));
        }
    }

    private static void exampleOfGraph() {
        System.out.println("- - - - - Задание 7.1 - - - - -");
        System.out.println(" Пример графа:");
        System.out.println("  транспортные схемы (схема метрополитена и т. д.) изображают в ");
        System.out.println("  виде станций, соединенных линиями");

    }
}
