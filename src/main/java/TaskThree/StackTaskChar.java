package TaskThree;

public class StackTaskChar implements queueAddition{
    private char[] stack;
    private int size;
    private int top;

    public StackTaskChar(int size) {
        this.size = size;
        this.stack = new char[size];
        this.top = -1;
    }

    public void push(char element){
        this.stack[++this.top] = element;
    }

    public char pop(){
        return this.stack[this.top--];
    }

    //смотрим на элемент в верхней части очереди, не удаляя его.
    public char peek(){
        return this.stack[this.top];
    }

    @Override
    public boolean isEmpty(){
        return (this.top == -1);
    }

    @Override
    public boolean isFull(){
        return (this.top == this.size - 1);
    }

    @Override
    public int size() {
        return size;
    }
}
