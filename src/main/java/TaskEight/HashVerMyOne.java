package TaskEight;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class HashVerMyOne<T> {

    private ArrayList<LinkedList<T>> listHash;
    private final int SIZE;

    public HashVerMyOne(int SIZE) {
        this.SIZE = SIZE;
        this.listHash = new ArrayList<>();
        fillThisList();
    }

    public void add(T data){
        int indexArray = hashIndexRangeArray(Objects.hashCode(data));
        this.listHash.get(indexArray).add(data);
    }

    public void remove(T data){
        int indexArray = hashIndexRangeArray(Objects.hashCode(data));
        this.listHash.get(indexArray).remove(data);
    }

    public boolean contains(T data){
        int indexArray = hashIndexRangeArray(Objects.hashCode(data));
        return this.listHash.get(indexArray).contains(data);
    }

    private int hashIndexRangeArray(int key){
        return key % this.SIZE;
    }

    private void fillThisList(){
        this.listHash.ensureCapacity(SIZE);
        for (int i = 0; i < SIZE; i++) {
            this.listHash.add(i, new LinkedList<>());
        }
    }
}
