/*
Тестирует класс DequeTask на добавление через head, чтение через tail
 */
import TaskThree.DequeTask;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DequeInsertReadTest {
    private final int SIZE = 5;
    private DequeTask dt;

    @Before
    public void construct(){
        this.dt = new DequeTask(SIZE);
        dt.insertHead(SIZE);
    }

    @Test
    public void readTail(){
        Assert.assertEquals(SIZE, dt.removeTail());
    }

}
