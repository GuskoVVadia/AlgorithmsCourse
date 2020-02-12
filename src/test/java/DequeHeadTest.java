/*
Тестирует класс DequeTask на добавление, удаление и считывание элементов матодами head
 */
import TaskThree.DequeTask;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DequeHeadTest {

    private final int SIZE = 5;
    private DequeTask dt;

    @Before
    public void construct(){
        this.dt = new DequeTask(SIZE);
        for (int i = 0; i < SIZE; i++) {
            dt.insertHead(i);
        }
    }

    @Test
    public void dequeInstance(){
        Assert.assertNotNull(dt);
    }

    @Test
    public void elementInArray(){
        Assert.assertEquals(SIZE - 1, dt.peekHead());
    }

    @Test
    public void sizeFullTrue(){
        Assert.assertEquals(SIZE, dt.size());
    }

    @Test
    public void firstElementDeque(){
        Assert.assertEquals(0, dt.peekFirstHead());
    }

    @Test
    public void finalElement(){
        Assert.assertEquals(SIZE - 1, dt.removeHead());
    }

    @Test
    public void notElement(){
        while (dt.size() != 0){
            dt.removeHead();
        }
        Assert.assertTrue(dt.isEmpty());
    }
}
