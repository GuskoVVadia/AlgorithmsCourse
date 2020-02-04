package TaskOne;

import java.util.Arrays;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static AtomicInteger length = new AtomicInteger(0);

    public static void main(String[] args) {



    }

    /*
    Вычисление максимального числа в массиве, путём разбивания массива на два куска и поиск максимального значения в
    этих частях в разных потоках.
    Вариант предложенный здесь - скорее для тренировки, чем для быстрой производительности. Разница во времени выполнения
    ощутима при больших длинне массива.
    В методе также вычисляется время выполнения.

    @param array массив из примитивного типа int
    @param value выступает как значение, которое не стоит рассматривать, к примеру, ко второй итерации цикла
     на поиск выступает в роли второго максимального числаЮ которое не стоит рассматривать.
    @return максимальное число != value
     */
    public static int maxMachiavelli(int[] array, int value){

        long time = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        int from = array.length / 2;

        int maxOne = 0;
        int maxTwo = 0;

        Future<Integer> futureOneValue =  executorService.submit(() -> {
            int maxArray = Integer.MIN_VALUE;
            for (int i = 0; i < from; i++) {
                if ((array[i] > maxArray) & (array[i] != value)) maxArray = array[i];
            }
            return maxArray;
        });

        Future<Integer> futureTwoValue =  executorService.submit(() -> {
            int maxArray = Integer.MIN_VALUE;
            for (int i = from; i < array.length; i++) {
                if ((array[i] > maxArray) & (array[i] != value)) maxArray = array[i];
            }
            return maxArray;
        });
        executorService.shutdown();

        try {
            maxOne = futureOneValue.get();
            maxTwo = futureTwoValue.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("Через 2 потока от executeService, время : " + (System.currentTimeMillis() - time));
        return Math.max(maxOne, maxTwo);
    }

    /*
    Рекурсивный поиск числа в массиве, также присутствует значение, которое рассматривать не стоит.
    На практике моей встречается редко, т.к. при тестировании на большой массив происходит переполнение стека.
    @param array Массив чисел примитивного типа int
    @param max выступает и в роли максимального числа и в роли счётчика для итераций по массиву
    @param prevMax предыдущее максимальное число, которое не стоит искать, для сравнения
    @return максимальное число != prevMax
     */
    public static int recursiveMax(int[] array, int max, int prevMax){
            if (array.length > max) {
                int next = recursiveMax(array, max + 1, prevMax);
                return ((array[max] > next) & (array[max] != prevMax)) ? array[max] : next;
            } else {
                return array[0];
            }
    }

    /*
    Метод для вычисления максимального значения, т.н. "прямым путём", т.е. методом перебора в цикле.
    Также метод выводит время вычисления в ms.
    @param array массив примитивов типа int
    @param value значение, которое не стоит учитывать
    @return максимальное число != value
     */
    public static int directWay(int[] array, int value){
        long time = System.currentTimeMillis();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] >  max) & (array[i] != value)) max = array[i];
        }
        System.out.println("Метод перебора массива (сложность O(n)) за время: " +
                (System.currentTimeMillis() - time));
        return max;
    }

    /*
    Метод простым перебором проходит по массиву трижды, для поиска трёх слагаемых.
    Счётчик времени выполнения здесь выводится тоже, но может пригодиться только для малых массивов,
     т.к. сложность метода возрастает в кубе.
     @param array массив примитивного типа int
     вывод на консоль
     */
    public static void getTrioInArray(int[] array){
        long time = System.currentTimeMillis();
        for (int x = 0; x < array.length; x++) {
            for (int y = (x + 1); y < array.length; y++) {
                for (int z = (x + 2); z < array.length; z++) {
                    if ((x % 10) == 0) System.out.println(x);
                    if (((array[x] + array[y] + array[z]) == 0) & (x != y) & (y != z))
                        System.out.println(array[x] + "+" + array[y] + "+" + array[z] +
                            "= 0");
                }
            }
        }
        System.out.println("Сложность алгоритма O(n3). Время выполнения = " +
                (System.currentTimeMillis() - time));
    }

    /*
    Долго пытался решить задачу сокращения ресурсов для поиска трёх слагаемых. Кроме тройного перебора по массиву
     ничего не могу придумать. Этот метод попытка раскидать по потокам массив по частям с шагом step.
    Не уверен, что метод будет правильно работать.
    @param array массив чисел примитивного типа int
    @param step шаг, с которым будет разбиваться массив
    @param countThreads количество потоков, которые будут созданы классом Executors
     вывод трёх слагаемых в консоль , а по завершению слово exit.
     */
    public static void hardWay(int[] array, int step, int countThreads){
        Runnable run = () -> {
            int thisStep = length.get() + step;
            if (thisStep >= array.length) return;
            if ((array.length - length.get()) < step) thisStep = (array.length - length.get());
            else length.addAndGet(step);

            for (int x = length.get(); x < (thisStep); x++) {
                for (int y = 0; y < array.length; y++) {
                    for (int z = 0; z < array.length; z++) {
                        if (((array[x] + array[y] + array[z]) == 0) &
                                (x != y) & (x != z) & (y != z)) System.out.println(array[x] +
                                "+" + array[y] + "+" + array[z] + " = 0");
                    }
                }
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(countThreads);
        Future future = executorService.submit(run);
        if (length.get() >= array.length) executorService.shutdown();
        if (future.isDone()) System.out.println("exit");
    }
}
