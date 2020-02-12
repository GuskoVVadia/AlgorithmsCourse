/*
Класс для отработки класса Bracket из методички.
 */
package TaskThree;

public class BracketTask {

    private String input;

    public BracketTask(String input) {
        this.input = input;
    }

    public void check(){
        int size = input.length();
        StackTaskChar stack = new StackTaskChar(size);

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch){
                case '[' :
                case '{' :
                case '(' :
                    stack.push(ch);
                    break;
                case ']' :
                case '}' :
                case ')' :
                    if (!stack.isEmpty()){
                        char local = stack.pop();
                        if ((ch == '}' && local != '{') || (ch == ']' && local != '[') || (ch == ')' && local != '(')){
                            System.out.println("Error: " + ch + " at " + i);
                        }
                    } else {
                        System.out.println("Error: " + ch + " at " + i);
                    }
                    break;
                default: break;
            }
        }
        if ((!stack.isEmpty())){
            System.out.println("Error: missing right delimiter");
        }
    }
}
