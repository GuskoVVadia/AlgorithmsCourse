/*
Рекурсивная реализация сортировки слиянием.
 */
package TaskFive;

import java.util.Arrays;

public class MergeSortRecursive {

    private int[] array;    //внутренний массив
    private int size;       //количество элементов в массиве

    //создаём массив и инициализируем количество элементов в массиве
    public MergeSortRecursive(int length) {
        this.array = new int[length];
        this.size = 0;
    }

    //добавляем элементы в конец массива
    public void add(int value){
        this.array[this.size++] = value;
    }

    //вывод массива
    public void show(){
        System.out.println(Arrays.toString(this.array));
    }

    /**
     * создаём массив с длинной внутреннего массива для хранения промежуточных результатов
     * передаём его методу рекурсивной сортировки
     */
    public void mergeSort(){
        int[] workSpace = new int[this.size];
        recursionMergeSort(workSpace, 0, size - 1);
    }

    /**
     * Собственно метод рекурсивного дробления массива.
     * и передачей дробленных частей в метод слияния
     * @param workSpace массив для хранения промежуточных результатов
     * @param lowerBound нижний предел
     * @param upperBound верхний предел
     */
    private void recursionMergeSort(int[] workSpace, int lowerBound, int upperBound){
        if (lowerBound == upperBound){  //общий случай для рекурсивного вызова - массив из одного элемента
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;    //вычисляем середину из верхнего и нижнего предела
            recursionMergeSort(workSpace, lowerBound, mid); //дробим нижнию часть
            recursionMergeSort(workSpace, mid + 1, upperBound); //дробим верхнюю часть
            merge(workSpace, lowerBound, mid + 1, upperBound);  //слияние полученных массивов
        }
    }

    /**
     * Метод слияния.
     * @param workSpace массив для хранения промежуточных реультатов, разбитый на мелкие части рекурсией
     * @param low нижний предел
     * @param high верхний предел
     * @param upperBound длинна массива (как внутреннего, так и общего для хранения промежуточных результатов)
     */
    private void merge(int[] workSpace, int low, int high, int upperBound){
        int j = 0;                              //индекс в рабочей области
        int lowerBound = low;
        int mid = high - 1;
        int n = upperBound - lowerBound + 1;    //количество элементов

        while (low <= mid && high <= upperBound){   //пока в обоих массивах есть значения - сравниваем
            if (this.array[low] < this.array[high]){
                workSpace[j++] = this.array[low++];
            } else {
                workSpace[j++] = this.array[high++];
            }
        }
        while (low <= mid){ //если один массив пуст, копируем значения со второго
            workSpace[j++] = this.array[low++];
        }
        while (high <= upperBound){ //если второй массив пуст, копируем значения с первого
            workSpace[j++] = this.array[high++];
        }
        for (int i = 0; i < n; i++) {   //копируем значения массива сравнений в массив внутренний
            this.array[lowerBound + i] = workSpace[i];
        }
    }
}
