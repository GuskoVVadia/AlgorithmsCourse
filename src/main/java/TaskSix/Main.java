/*
Входная точка для работы с классами в даном пакете.
 */

package TaskSix;

import java.util.Random;

public class Main {

    public static final int COUNT = 20;

    public static void main(String[] args) {
        BinaryTreeFind<String, Integer> answer;

        for (int i = 0; i < COUNT; i++) {
            answer = getFillTree();
            System.out.println("Дерево симетрично? " + answer.isSymmetricTree());
            System.out.println("Дерево зеркально? " + answer.isMirrorTree());
        }

    }

    public static BinaryTreeFind<String, Integer> getFillTree(){
        BinaryTreeFind<String, Integer> local = new BinaryTreeFind<>();
        Random rnd = new Random();
        int j = (rnd.nextInt(200) - 100);
        for (int i = 0; i < 65; i++, j = (rnd.nextInt(200) - 100)) {
            String word = Integer.toString(j);
            if (i == 0){
                word = "root";
            }
            local.insert(j, word);
        }
        return local;
    }

}
