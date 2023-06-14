package labs.lab6.src;

public class Supervisor extends Thread {
    private AbstractProgram program;

    public Supervisor(AbstractProgram program) {
        this.program = program;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (program) {
                try {
                    program.wait();

                    ProgramState state = program.getState();
                    System.out.println("Supervisor - Current state: " + state);

                    if (state == ProgramState.STOPPING) {
                        program.setState(ProgramState.RUNNING);
                    } else if (state == ProgramState.FATAL_ERROR) {
                        System.out.println("Supervisor - Fatal error occurred. Stopping program.");
                        program.stop();
                        break;
                    }
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
