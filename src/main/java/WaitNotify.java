public class WaitNotify {

    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        Producer producer1 = new Producer(buffer);
        Producer producer2 = new Producer(buffer);

        Consumer consumer1 = new Consumer(buffer);
        Consumer consumer2 = new Consumer(buffer);

        new Thread(producer1).start();
        new Thread(producer2).start();

        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }

}
