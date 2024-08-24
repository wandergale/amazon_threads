import java.util.Random;

public class Producer implements Runnable {
    private final int RANGE = 1000;
    private Random rand = new Random();
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            int item = rand.nextInt(RANGE);
            buffer.addToBuffer(item);
            try {
                Thread.sleep(rand.nextInt(2000)); // Simula o tempo para produzir um novo item
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}