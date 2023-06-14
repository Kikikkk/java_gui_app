package labs.lab1.src.main.java;

public class Hero {
    MoveStrategy moveStrategy;
    public Hero(MoveStrategy moveStrategy) {
    }
    public String move() {
        return this.moveStrategy.move();
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }
}
