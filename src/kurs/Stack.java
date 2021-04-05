package kurs;

public class Stack {
    private final int[] arr;
    private int top;

    public Stack(int maxSize) {
        arr = new int[maxSize];
        top = -1;
    }

    public void push(int i) {
        arr[++top] = i;
    }

    public int pop() {
        return arr[top--];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public int peek() {
        return arr[top];
    }
}
