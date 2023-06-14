package labs.lab1.src.main.java;

public interface MoveStrategy {
    String move();
    default void foo() {
        System.out.println("");
    }
}
