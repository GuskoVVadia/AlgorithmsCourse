/*
Класс для работы с массивом типа int.
 */
package TaskTwo;

import java.util.Random;

public class ArrayTask {
    private int[] array;
    private int size;

    public ArrayTask(int size) {
        this.size = size;
        this.array = new int[size];
    }

    public ArrayTask() {
        this.size = 100;
        this.array = new int[size];
    }

    /*
    ищем элемент в массиве до тех пор, пока не переберём весь массив
    @param value запрашиваем элемент поиска в массиве
    @return local выводим либо индекс элемента в массиве, либо -1
     */
    public int findElement(int value){
        long time = System.currentTimeMillis();
        int local = -1;
        for (int i = 0; (i < this.size) || (local < 0); i++) {
            if (this.array[i] == value){
                local = i;
            }
        }
        System.out.println("time findElement: " + (System.currentTimeMillis() - time) + " ms.");
        return local;
    }


    public boolean addElement(int value){
        long time = System.currentTimeMillis();
        boolean status = false;
        if (this.array.length > size){
            this.array[size] = value;
            this.size++;
            status = true;
        }
        System.out.println("time addElement: " + (System.currentTimeMillis() - time) + " ms.");
        return status;
    }

    public boolean delElement(int value){
        int i = findElement(value);
        boolean status = false;
        long time = System.currentTimeMillis();
        if (i >= 0){
            for (int j = i; j < this.size - 1; j++) {
                this.array[j] = this.array[j + 1];
            }
            this.size--;
            status = true;
        }
        System.out.println("time delElement: " + (System.currentTimeMillis() - time) + " ms.");
        return status;
    }

    public void fillRandom(int bound){
        Random ran = new Random();
        long time = System.currentTimeMillis();
        for (int i = 0; i < this.size; i++) {
            this.array[i] = ran.nextInt(bound);
        }
        System.out.println("time fillRandom: " + (System.currentTimeMillis() - time) + " ms.");
    }

    public void fillRandom(){
        Random ran = new Random();
        long time = System.currentTimeMillis();
        for (int i = 0; i < this.size; i++) {
            this.array[i] = ran.nextInt();
        }
        System.out.println("time fillRandom: " + (System.currentTimeMillis() - time) + " ms.");
    }

    public void addShift(int value){
        long time = System.currentTimeMillis();
        int[] local = new int[this.array.length + 1];
        copyArray(this.array,0, this.array.length, local, 0, this.array.length);
        local[this.array.length] = value;
        this.size++;
        this.array = local;
        System.out.println("time addShift: " + (System.currentTimeMillis() - time) + " ms.");
    }

    public void addShift(int ... a){
        long time = System.currentTimeMillis();
        int[] local = new int[this.array.length + a.length];
        copyArray(this.array, 0, this.array.length, local, 0, this.array.length);
        copyArray(a, 0, a.length, local, this.array.length, local.length);
        this.size += a.length;
        this.array = local;
        System.out.println("time addShift: " + (System.currentTimeMillis() - time) + " ms.");
    }

    public boolean delShift(int value){
        boolean status = false;
        long time = System.currentTimeMillis();
        int i = findElement(value);
        if (i >= 0){
            int[] local = new int[this.array.length - 1];
            copyArray(this.array, 0, i, local, 0, i);
            copyArray(this.array, i + 1, this.array.length, local, i, local.length);
            this.array = local;
            System.out.println("time delShift: " + (System.currentTimeMillis() - time) + " ms.");
            this.size--;
        }
        return status;
    }


    private void copyArray(int[] arrayOut, int startOut, int endOut, int[] arrayIn, int startIn, int endIn){
        int i;
        int j;
        for (i = startIn , j = startOut; i < endIn && j < endOut; i++, j++) {
            arrayIn[i] = arrayOut[j];
        }
    }

    private void changeElementArray(int[] array, int j, int i) {
        int local = array[j];
        array[j] = array[i];
        array[i] = local;
    }

    public void sortBubble(){
        long time = System.currentTimeMillis();
        for (int i = this.size - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (this.array[j] > this.array[j + 1]){
                    changeElementArray(this.array, j, j + 1);
                }
            }
        }
        System.out.println("sortBubble:" + (System.currentTimeMillis() - time));
    }

    public void sortSelect(){
        long time = System.currentTimeMillis();
        int mark;
        for (int i = 0; i < this.size; i++) {
            mark = i;
            for (int j = i + 1; j < this.size; j++) {
                if (this.array[j] < this.array[mark]){
                    mark = j;
                }
            }
            changeElementArray(this.array, i, mark);
        }
        System.out.println("sortSelect:" + (System.currentTimeMillis() - time));
    }

    public void sortInsert(){
        long time = System.currentTimeMillis();
        for (int i = 1; i < this.size; i++) {
            int local = this.array[i];
            int j = i;
            for (; (j > 0) && (this.array[j-1] >=local); j--){
                this.array[j] = this.array[j-1];
            }
            this.array[j] = local;
        }
        System.out.println("insertSortMTaskTwo:" + (System.currentTimeMillis() - time));
    }

    public int findBinary(int value){
        int right;
        int left;
        int mid;
        int answer = -1;
        long time = System.currentTimeMillis();
        for ( right = this.size, left = 0, mid = ((right + left) / 2); left <= right; mid = ((right + left) / 2)){
            if (this.array[mid] == value){
                answer = mid;
            }
            if (this.array[mid] < value){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return answer;
    }
}
