package Q2;

import java.util.ArrayList;

/**
 * The Thread class represents a thread of clients in network
 */
public class Thread {

    // Title of thread
    private String title;

    // A runnable object
    private Runnable runnable;

    // State of thread
    private boolean running;

    /**
     * Create a new thread with given runnable object & title
     * @param runnable a runnable object
     * @param title a title
     */
    public Thread(Runnable runnable, String title) {
        this.title = title;
        this.runnable = runnable;
        running = false;
    }

    /**
     * Get the title of thread
     * @return title field
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the runnable object of thread
     * @return runnable field
     */
    public Runnable getRunnable() {
        return runnable;
    }

    /**
     * Check if thread is running
     * @return running field
     */
    public boolean isRunning() {
        return running;
    }

    public void start() {
        running = true;
    }
}
