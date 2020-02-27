/*
Входная точка для работы с классами в даном пакете.
 */

package TaskSix;

import java.util.Random;

public class Main {

    public static final int COUNT = 20;
    public static final int STEP = 63;

    public static void main(String[] args) {

        for (int i = 0; i < COUNT; i++) {
            BinaryTreeFind<String, Integer> btf = getTreeFill();
            btf.show();
            System.out.println("Дерево симметрично? " + btf.isSymmetricTree());
            System.out.println("Дерево зеркально? " + btf.isMirrorTree());
        }

    }

    public static BinaryTreeFind<String, Integer> getTreeFill(){
        BinaryTreeFind<String, Integer> local = new BinaryTreeFind<>();
        Random rnd = new Random();

        for (int i = 0; i < STEP; i++) {

            int x = rnd.nextInt(200) - 100;

            if (i == 0){
                x = 0;
            } else {
                while (local.contains(x)) {
                    x = rnd.nextInt(200) - 100;
                }
            }

            String meta = Integer.toString(x);
            if (i == 0){
                meta = "root";
            }

            local.insert(x, meta);

        }
        return local;
    }


}
