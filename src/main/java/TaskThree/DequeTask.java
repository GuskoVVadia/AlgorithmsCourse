/*
Класс реализующий двусторонюю очередь.
В массив можно добавлять данные как по принципу FIFO,
 так и по принципу LIFO.
Данный клас реализует две двусторонние очереди.
 */
package TaskThree;

public class DequeTask <T> implements queueAddition{

    private T[] array;
    private int right;
    private int left;
    private int sizeMax;
    private int countItems;



    @SuppressWarnings("unchecked")
    public DequeTask(int size) {
        this.sizeMax = size;
        this.array = (T[]) new Object[size];
        this.right = size / 2;
        this.left = right;
        this.countItems = 0;

    }

    public void addFirst(T element){
        if (countItems != 0){
            this.right++;
        }
        if (this.right >= sizeMax){
            this.right = 0;
        }
        this.array[this.right] = element;
        this.countItems++;
    }

    public T removeFirst(){
        if (countItems == 0){
            return null;
        }
        if (this.right <= 0){
            this.right = sizeMax - 1;
        }
        T local = this.array[this.right];
        this.array[this.right] = null;
        this.right--;
        this.countItems--;
        return local;
    }

    public T getFirst(){
        if (countItems == 0){
            return null;
        }
        if (this.right <= 0){
            this.right = sizeMax - 1;
        }
        return this.array[this.right];
    }

    public void addLast(T element){
        if (countItems != 0){
            this.left--;
        }
        if (this.left <= 0){
            this.left = sizeMax - 1;
        }
        this.array[this.left] = element;
        this.countItems++;
    }

    public T removeLast(){
        if (countItems == 0){
            return null;
        }
        if (this.array[this.left] == null){
            this.left--;
        }
        if (this.left < 0){
            this.left = sizeMax - 1;
        }
        T local = this.array[this.left];
        this.array[this.left] = null;
        this.countItems--;
        return local;
    }

    public T getLast(){

        if (countItems == 0){
            return null;
        }
        if (this.left < 0){
            this.left = sizeMax - 1;
        }
        return this.array[this.left];
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
