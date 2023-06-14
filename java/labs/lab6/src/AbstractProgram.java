package labs.lab6.src;

import java.util.Random;

public class AbstractProgram implements Runnable {
    private ProgramState state;
    private Thread daemonThread;
    private Random random;

    public AbstractProgram() {
        state = ProgramState.UNKNOWN;
        daemonThread = new Thread(this);
        daemonThread.setDaemon(true);
        random = new Random();
    }

    public void start() {
        daemonThread.start();
    }

    public synchronized void stop() {
        setState(ProgramState.STOPPING);
    }

    public synchronized void setState(ProgramState newState) {
        state = newState;
        System.out.println("Abstract Program state changed to " + state);
        notify();
    }

    public synchronized ProgramState getState() {
        return state;
    }

    private ProgramState getRandomState() {
        int index = random.nextInt(ProgramState.values().length);
        return ProgramState.values()[index];
    }

    @Override
    public void run() {
        while (state != ProgramState.FATAL_ERROR) {
            try {
                Thread.sleep(1000);
                ProgramState newState = getRandomState();
                setState(newState);

                if (newState == ProgramState.STOPPING) {
                    synchronized (this) {
                        wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
