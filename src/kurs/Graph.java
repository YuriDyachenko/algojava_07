package kurs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private final int MAX_VERTEX = 32;
    private final Vertex[] vertexList;
    private final int[][] matrix;
    private int size;

    public Graph() {
        vertexList = new Vertex[MAX_VERTEX];
        matrix = new int[MAX_VERTEX][MAX_VERTEX];
        size = 0;
        for (int i = 0; i < MAX_VERTEX; i++) Arrays.fill(matrix[i], 0);
    }

    public int getSize() {
        return size;
    }

    public void add(char label) {
        vertexList[size++] = new Vertex(label);
    }

    public Vertex get(int i) {
        checkIndex(i);
        return vertexList[i];
    }

    private int getAdjacency(int i) {
        for (int j = 0; j < size; j++)
            if (matrix[i][j] == 1 && !vertexList[j].visited) return j;
        return -1;
    }

    private char getAdjacency(char label) {
        int i = find(label);
        if (i == -1) throw new IndexOutOfBoundsException(msgNotFound(label));
        int j = getAdjacency(i);
        return vertexList[j].label;
    }

    public String depthFirstWalk(char label) {
        int start = find(label);
        if (start == -1) throw new IndexOutOfBoundsException(msgNotFound(label));
        return depthFirstWalk(start);
    }

    public String depthFirstWalk(int start) {
        StringBuilder sb = new StringBuilder();
        Stack stack = new Stack(MAX_VERTEX);
        vertexList[start].visited = true;
        sb.append(vertexList[start]);
        stack.push(start);
        while (!stack.isEmpty()) {
            int v = getAdjacency(stack.peek());
            if (v == -1) stack.pop();
            else {
                vertexList[v].visited = true;
                sb.append(", ").append(vertexList[v]);
                stack.push(v);
            }
        }
        clearVisited();
        return sb.toString();
    }

    private void clearVisited() {
        for (int i = 0; i < size; i++)
            vertexList[i].visited = false;
    }

    public String breadthFirstWalk(char label) {
        int start = find(label);
        if (start == -1) throw new IndexOutOfBoundsException(msgNotFound(label));
        return breadthFirstWalk(start);
    }

    public String breadthFirstWalk(int start) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        vertexList[start].visited = true;
        sb.append(vertexList[start]);
        queue.add(start);
        int v2;
        while (!queue.isEmpty()) {
            int v1 = queue.remove();
            while ((v2 = getAdjacency(v1)) != -1) {
                vertexList[v2].visited = true;
                sb.append(", ").append(vertexList[v2]);
                queue.add(v2);
            }
        }
        clearVisited();
        return sb.toString();
    }

    public void addAdjacency(int i, int j) {
        checkIndex(i);
        checkIndex(j);
        matrix[i][j] = 1;
        matrix[j][i] = 1;
    }

    public void addAdjacency(char c1, char c2) {
        int i = find(c1);
        if (i == -1) throw new IndexOutOfBoundsException(msgNotFound(c1));
        int j = find(c2);
        if (j == -1) throw new IndexOutOfBoundsException(msgNotFound(c2));
        addAdjacency(i, j);
    }

    private int find(char label) {
        for (int i = 0; i < size; i++)
            if (vertexList[i].label == label) return i;
        return -1;
    }

    private String msgNotFound(char label) {
        return "Vertex " + label + " not found!";
    }

    private void checkIndex(int i) {
        if (i < 0) throw new IndexOutOfBoundsException("i=" + i + " < 0");
        if (i >= size) throw new IndexOutOfBoundsException("i=" + i + " >= size=" + size);
    }
}
