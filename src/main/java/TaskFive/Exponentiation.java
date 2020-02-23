/*
Возведение чсила в степень рекурсивно O(N).
Возведение числа в степень с модернизацией алгоритма O(LogN).
 */
package TaskFive;

public class Exponentiation {

    /**
     * метод рекурсивного вычисления числа в степени по "прямому" алгоритму,
     * где рекурсия перемножает себя на число expo раз.
     * @param value число, которое необходимо возвести в степень.
     * @param expo степень числа
     * @return используется для вычисления числа в степени при рекурсивных итерациях и как вывод результата.
     */
    public static long recurAlgoN(long value, int expo) {
        return (expo == 1) ? value : (value * recurAlgoN(value, expo - 1));
    }

    /**
     * Метод возведения числа в степень рекурсивно.
     * Путём перемножения числа на самого себя с одновременным уменьшением степени в половину.
     * @param x число
     * @param y степень, в которую нужно возвести число
     * @return рекурсивно возвращает степень числа x
     */
    public static long recurAlgoLogN(long x, int y){
        if (y == 1){
            return x;
        } else return (y % 2 == 0) ? recurAlgoLogN(x *x, y/ 2) : x * recurAlgoLogN(x *x, y/ 2);
    }

    public static void main(String[] args) {
        long answer = recurAlgoLogN(3, 25);
        System.out.println(answer);
    }

    private static int dependencies(int x, int y, int tmp){
        if (y == 1){
            return x;
        } else if (y % 2 == 0){
            int answer = dependencies(x *x, y/ 2, x);
            return answer;
        }else {
            int answer = x * dependencies(x * x, y / 2, x);
            return answer;
        }
    }
}
