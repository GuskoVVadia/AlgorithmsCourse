package TaskEight;

import java.util.Objects;

public class HashVerMyOne<T> {

    private Line<T>[] array;
    private final int SIZE;
    private final int DOT;

    public HashVerMyOne(int SIZE) {
        this.SIZE = SIZE;
        this.DOT = 7;
        this.array = new Line[SIZE];
    }

    public void add(T data){
        int indexArray = hashIndexRangeArray(Objects.hashCode(data));
        if (this.array[indexArray] == null){
            this.array[indexArray] = new Line<T>();
        }
        this.array[indexArray].add(data);
    }

    public void remove(T data){
        int indexArray = hashIndexRangeArray(Objects.hashCode(data));
        if (this.array[indexArray] != null) {
            this.array[indexArray].remove(data);
        }
    }

    public boolean contains(T data){
        int indexArray = hashIndexRangeArray(Objects.hashCode(data));
        return (this.array[indexArray] == null) ? false : this.array[indexArray].contains(data);
    }

    private int hashIndexRangeArray(int key){
        return key % this.SIZE;
    }

    private int hashDoubleIndexRange(int key){
        return DOT - (key % DOT);
    }
}
