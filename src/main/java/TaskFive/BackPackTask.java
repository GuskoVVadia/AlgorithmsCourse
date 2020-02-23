/*
Доделка алгоритма, предложенного на уроке.
 */
package TaskFive;

public class BackPackTask {
    /**
     *
     * @param weight - массив значений веса предметов
     * @param val - массив значений ценности предметов
     * @param w - максимально допустимый вес вещей в рюкзаке
     * @param itemNum - элемент, который мы хотим положить на текущей итерации
     * @return максимально возможная ценность предметов, которые могут поместиться в рюкзаке
     */
    public static int recursive(int[] weight, int[] val, int w, int itemNum) {
        if (w == 0 || itemNum == weight.length) {
            return 0;
        }
        if (weight[itemNum] > w) {
            return recursive(weight, val, w,itemNum + 1);
        }

        int tmpMax = val[itemNum] + recursive(weight, val, w - weight[itemNum], itemNum + 1);
        int tmpMin = recursive(weight, val, w, itemNum + 1);
        return (tmpMax >= tmpMin) ? tmpMax : tmpMin;
    }
}
