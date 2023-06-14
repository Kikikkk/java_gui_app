package labs.lab6.src;

public class Main {
    public static void main(String[] args) {
        AbstractProgram program = new AbstractProgram();
        Supervisor supervisor = new Supervisor(program);

        program.start();
        supervisor.start();
    }
}
