package TaskThree;

public class PriorityQueueTask{

    private int maxSize;
    private int[] queuePriority;
    private int countItem;

    public PriorityQueueTask(int size) {
        this.maxSize = size;
        this.queuePriority =  new int[size];
        this.countItem = 0;
    }

    public void insert(int item){
        int i;
        if (this.countItem == 0){
            this.queuePriority[countItem++] = item;
        } else {
            for (i = this.countItem - 1; i >= 0 ; i--) {
                if ( item > queuePriority[i] ){
                    this.queuePriority[i + 1] = this.queuePriority[i];
                } else {
                    break;
                }
            }
            this.queuePriority[i + 1] = item;
            countItem++;
        }
    }

    public int remove(){
        return queuePriority[--countItem];
    }

    public int peek(){
        return queuePriority[countItem - 1];
    }

    public boolean isEmpty() {
        return (this.countItem == 0);
    }

    public boolean isFull() {
        return (this.countItem == maxSize);
    }

    public int size() {
        return this.countItem;
    }
}
