package kurs;

public class Vertex {
    public char label;
    public boolean visited;

    public Vertex(char label) {
        this.label = label;
        visited = false;
    }

    @Override
    public String toString() {
        return "Vertex{" + label + "}";
    }
}
