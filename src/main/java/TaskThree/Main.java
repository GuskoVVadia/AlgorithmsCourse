package TaskThree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        DequeTask<Integer> deque = new DequeTask<>(5);
        deque.addFirst(10);
        deque.addFirst(20);
        deque.addFirst(30);
        deque.addFirst(40);

        Integer last = deque.getLast();
        Integer remove = deque.removeLast();

        deque.addLast(15);

        while (deque.size() != 0)
            System.out.println(deque.removeLast());

        System.out.println();
    }

    public static void getQueueTask(){
        QueueTask<Integer> queue = new QueueTask<>(5);

        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);

        queue.remove();
        queue.remove();

        queue.insert(50);
        queue.insert(60);
        queue.insert(70);
        queue.insert(80);

        while (!queue.isEmpty()){
            System.out.println(queue.remove());
        }
    }

    public static void getPriorityQueueTask(){
        PriorityQueueTask pqt = new PriorityQueueTask(5);
        pqt.insert(30);
        pqt.insert(50);
        pqt.insert(10);
        pqt.insert(40);
        pqt.insert(20);

        while (!pqt.isEmpty()){
            System.out.print(pqt.remove() + " ");
        }

        System.out.println();
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        return br.readLine();
    }

    //реализация задания №2 из методички.
    public void reverseString() throws IOException {

        while (true){
            String link = getString();
            if (link.equals("")) {
                break;
            }
            StackTaskChar stc = new StackTaskChar(link.length());
            for (int i = 0; i < link.length(); i++) {
                stc.push(link.charAt(i));
            }

            char[] charOutArray = new char[link.length()];
            for (int i = 0; i < link.length(); i++) {
                charOutArray[i] = stc.pop();
            }
            System.out.println(new String(charOutArray));

        }
    }
}
