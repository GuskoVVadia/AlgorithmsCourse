/*
Класс для работы с массивом типа int.
Методы выводят время своей отработки в ms.
Дл удобства работы методы не объявлена как static, т.к. при таком архитектуре методом пришлось бы создавать геттер на
приватное поле массива, что повлекло за собой нарушение принципа инкапсуляции.
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

    /*
    Метод добавления значения типа int в "хвост" внутреннего массива, с проверкой возможности добавления.
    @param value значение, которое нужно добавить в массив
    @return boolean при добавление элемента в массив возвращет true, если массив заполнен возвращает false
     */
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

    /*
    Удаление value из массива, с проверкой наличия этого элемента во внутреннем массиве. Удаляет первое и единственное
    вхождение этого элемента из массива, с последующим сдвигом элементов к началу массива.
    @param value значение типа int
    @return boolean возвращает true в случае успеха, false в противном случае
     */
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

    /*
    Метод используя линейный алгоритм и метод nextInt() из объекта типа Random, проходится по всей длинне массива
    и заполняет массив случайными числами в диапозоне от 0 до указанного параметра.
    @param bound число, случащее крайней правой границей для генерации случайных чисел, которыми заполняется массив.
     */
    public void fillRandom(int bound){
        Random ran = new Random();
        long time = System.currentTimeMillis();
        for (int i = 0; i < this.size; i++) {
            this.array[i] = ran.nextInt(bound);
        }
        System.out.println("time fillRandom: " + (System.currentTimeMillis() - time) + " ms.");
    }

    /*
    Метод используя линейный алгоритм и метод nextInt() из объекта типа Random, проходится по всей длинне массива
    и заполняет массив случайными числами диапозона int.
     */
    public void fillRandom(){
        Random ran = new Random();
        long time = System.currentTimeMillis();
        for (int i = 0; i < this.size; i++) {
            this.array[i] = ran.nextInt();
        }
        System.out.println("time fillRandom: " + (System.currentTimeMillis() - time) + " ms.");
    }

    public static void getRandomArray(int[] localArray, int bound){
        Random ran = new Random();
        for (int i = 0; i < localArray.length; i++) {
            localArray[i] = ran.nextInt(bound);
        }
    }

    /*
    Приватный метод перемены элементов в массиве местами.
    @param array массив, в котором происходит перемена мест элементов
    @param i индекс первого числа в массиве
    @param j индекс второго числа в массиве
     */
    private void changeElementArray(int[] array, int j, int i) {
        int local = array[j];
        array[j] = array[i];
        array[i] = local;
    }

    /*
    Метод сортировки "пузырьком".
    Алгоритм обхода массива двумя циклами - O(n * n) . Обход массива произойдёт даже в случае, когда массив уже отсортирован.
    @param array массив для сортировки
     */
    public void sortBubble(){
        long time = System.currentTimeMillis();
        for (int i = this.size - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (this.array[j] > this.array[j + 1]){
                    changeElementArray(this.array, j, j + 1);
                }
            }
        }
        System.out.println("sortBubble: " + (System.currentTimeMillis() - time));
    }

    /*
    Метод сортировки "выбором".
    Алгоритм обхода массива с маркером. Маркер наибольшего числа в массиве.
    @param массив для сортировки.
     */
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
        System.out.println("sortSelect: " + (System.currentTimeMillis() - time));
    }

    /*
    Сортировка "вставкой".
    Алгоритм метода - внешний цикл линейный, внутренний влючается при наличии меньшего соседа слева.
    @param array массив для сортировки
     */
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
        System.out.println("sortInsert: " + (System.currentTimeMillis() - time));
    }

    /*
    Поиск по половинам, бинарный.
    Переделан из цикла while в цикл for.
    Конструкция try finally применена для вывода времени выполнения метода в любом случае.
    @param value искомое значение
    @return int возвращает индекс элемента в массиве, если же такого нет - возвращает -1.
     */
    public int findBinary(int value){
        int right;
        int left;
        int mid;
        int answer = -1;
        long time = System.currentTimeMillis();
        try {
            for (right = this.size, left = 0, mid = ((right + left) / 2); left <= right; mid = ((right + left) / 2)) {
                if (this.array[mid] == value) {
                    answer = mid;
                }
                if (this.array[mid] < value) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }finally {
            System.out.println("findBinary: " + (System.currentTimeMillis() - time));
        }
        return answer;
    }
}
