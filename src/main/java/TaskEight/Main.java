/**
 * Точка входа для реализации классов д/з в этом пакете.
 */
package TaskEight;

public class Main {
    public static void main(String[] args) {

        HashVerMyOne<Integer> hvmo = new HashVerMyOne<>(12);

        for (int i = 0; i < 22; i++) {
            hvmo.add(i);
        }

        hvmo.remove(20);
        hvmo.remove(5);
        hvmo.remove(123);

        System.out.println(hvmo.contains(19));
        System.out.println(hvmo.contains(254));
    }
}
