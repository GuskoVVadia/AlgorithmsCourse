/*
Класс для отработки класса Queue из методички.
 */
package TaskThree;

public class QueueTask <T> implements queueAddition{

    private T[] queue;
    private int front;  //маркер начала очереди
    private int tail;   //маркер хвоста очереди
    private int sizeMax;   // queue.length;
    private int countItem;

    @SuppressWarnings("unchecked")
    public QueueTask(int size) {
        this.sizeMax = size;
        this.queue = (T[]) new Object[size];
        this.front = 0;
        this.tail = -1;
        this.countItem = 0;
    }

    //add element
    public void insert(T item){
        if (this.tail == this.sizeMax - 1){
            this.tail = -1;
        }
        this.queue[++tail] = item;
        countItem++;
    }

    public T remove(){
        T local = this.queue[this.front++];
        if (this.front == sizeMax) {
            this.front = 0;
        }
        countItem--;
        return local;
    }

    public T peek(){
        return this.queue[front];
    }

    @Override
    public boolean isEmpty() {
        return (this.countItem == 0);
    }

    @Override
    public boolean isFull() {
        return (this.countItem == this.sizeMax);
    }

    @Override
    public int size() {
        return countItem;
    }
}
