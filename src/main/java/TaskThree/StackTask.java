/*
Класс для отработки класса Stack из методички.
В классе не реализованы проверки на выходи за пределы массива.
Объясняя это наличием методов isEmpty и isFull.
Небезопасный класс.
 */

package TaskThree;

public class StackTask<T> implements queueAddition{

    private T[] stack;
    private int size;
    private int top;    //вершина стека

    @SuppressWarnings("unchecked")
    public StackTask(int size) {
        this.size = size;
        this.stack = (T[]) new Object[size];
        this.top = -1;
    }

    public void push(T element){
        this.stack[++this.top] = element;
    }

    public T pop(){
        return this.stack[this.top--];
    }

    //смотрим на элемент в верхней части очереди, не удаляя его.
    public T peek(){
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
