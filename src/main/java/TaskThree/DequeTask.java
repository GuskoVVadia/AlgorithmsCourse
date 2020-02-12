/*
Класс реализующий двусторонюю очередь.
В массив можно добавлять данные как по принципу FIFO,
 так и по принципу LIFO.
Данный клас реализует две двусторонние очереди.
 */
package TaskThree;

public class DequeTask implements queueAddition{

    private int[] array;
    private int head;
    private int tail;
    private int startHead;
    private int startTail;
    private int markHead;
    private int markTail;
    private int sizeMax;
    private int countItems;

    public DequeTask(int size) {
        this.sizeMax = size;
        this.array = new int[size];
        this.startHead = size / 2;
        this.head = startHead;
        this.startTail = startHead + 1;
        this.tail = startTail;
        this.countItems = 0;

        this.markHead = startHead;
        this.markTail = startTail;
    }

    public void insertTail(int value){
        if (tail >= sizeMax){
            tail = 0;
        }
        this.array[tail++] = value;
        countItems++;
    }

    public void insertHead(int value){
        if (head < 0){
            head = sizeMax - 1;
        }
        this.array[head--] = value;
        countItems++;
    }

    public int firstHead(){
        if (markHead < 0){
            markHead = sizeMax - 1;
        }
        if (markHead == head){
            throw new NullPointerException();
        }
        countItems--;
        return array[markHead--];
    }

    public int firstTail(){
        if (markTail > sizeMax - 1){
            markTail = 0;
        }
        if (markTail == tail){
            throw new NullPointerException();
        }
        countItems--;
        return array[markTail++];
    }

    public int removeTail(){
        if (tail <= 0){
            tail = sizeMax;
        }
        countItems--;
        return this.array[--tail];
    }

    public int removeHead(){
        head++;
        if (head == sizeMax){
            head = 0;
        }
        countItems--;
        return array[head];
    }

    public int peekHead(){
        int local = head + 1;
        if (local > sizeMax - 1){
            local = 0;
        }
        return array[local];
    }

    public int peekTail(){
        int local = tail - 1;
        if (local < 0){
            local = sizeMax - 1;
        }
        return array[local];
    }

    public int peekFirstHead(){
        return array[markHead];
    }

    public int peekFirstTail(){
        return array[markTail];
    }

    @Override
    public boolean isEmpty() {
        return (countItems == 0);
    }

    @Override
    public boolean isFull() {
        return (countItems == sizeMax);
    }

    @Override
    public int size() {
        return countItems;
    }
}
