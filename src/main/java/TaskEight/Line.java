/**
 * Класс-обёртка для реализации обобщённого List
 */
package TaskEight;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Line<E> {
    private List<E> localList;
    private E data;

    public Line(){
        this.localList = new LinkedList<>();
    }

    public boolean add(E data){
        return this.localList.add(data);
    }

    public boolean remove(E data){
        return this.localList.remove(data);
    }

    public boolean contains(E data){
        return this.localList.contains(data);
    }

    public void show(){
        System.out.println(Arrays.toString(this.localList.toArray()));
    }
}
