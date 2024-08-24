public class Buffer {
    private final int MAX = 3;
    private int[] buffer = new int[MAX];
    private int size = 0;

    public synchronized void addToBuffer(int item) {
        while (this.isBufferFull()) {
            try {
                System.out.println("Armazém está cheio. Aguardando espaço...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.buffer[this.size] = item;
        this.size++;
        System.out.println("Novo produto armazenado: " + item);
        notifyAll();
    }

    public synchronized int removeFromBuffer() {
        while (this.isBufferEmpty()) {
            try {
                System.out.println("Armazém está vazio. Aguardando novos produtos...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int item = this.buffer[this.size - 1];
        this.size--;
        System.out.println("Pedido atendido. Produto retirado: " + item);
        notifyAll();
        return item;
    }

    public boolean isBufferFull() {
        return this.size == this.MAX;
    }

    public boolean isBufferEmpty() {
        return this.size == 0;
    }
}