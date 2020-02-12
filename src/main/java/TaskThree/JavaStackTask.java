package TaskThree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaStackTask {
    public static void main(String[] args) throws IOException {
        String input;
        while (true){
            input = getString();
            if (input.equals("")) break;

            BracketTask brt = new BracketTask(input);
            brt.check();
        }
    }

    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        return br.readLine();
    }
}
