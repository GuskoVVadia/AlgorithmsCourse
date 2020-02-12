/*
Тестирует класс DequeTask на добавление, удаление и считывание элементов матодами tail
 */
import TaskThree.DequeTask;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DequeTailTest {

    private final int SIZE = 5;
    private DequeTask dt;

    @Before
    public void construct(){
        this.dt = new DequeTask(SIZE);
        for (int i = 0; i < SIZE; i++) {
            dt.insertTail(i);
        }
    }

    @Test
    public void dequeInstance(){
        Assert.assertNotNull(dt);
    }

    @Test
    public void elementInArray(){
        Assert.assertEquals(SIZE - 1, dt.peekTail());
    }

    @Test
    public void sizeFullTrue(){
        Assert.assertEquals(SIZE, dt.size());
    }

    @Test
    public void firstElementDeque(){
        Assert.assertEquals(0, dt.peekFirstTail());
    }

    @Test
    public void finalElementTail(){
        Assert.assertEquals(SIZE - 1, dt.removeTail());
    }

    @Test
    public void notElement(){
        while (dt.size() != 0){
            dt.removeTail();
        }
        Assert.assertTrue(dt.isEmpty());
    }

}
