package kurs;

public class Duration {
    private long fixNanoTime;

    public void fix(String message) {
        if (message != null) System.out.println(message);
        fix();
    }

    public void fix() {
        fixNanoTime = System.nanoTime();
    }

    public void outAndFix(String message) {
        long currentNanoTime = System.nanoTime();
        System.out.println(message + ": " + (currentNanoTime - fixNanoTime));
        fix();
    }
}
