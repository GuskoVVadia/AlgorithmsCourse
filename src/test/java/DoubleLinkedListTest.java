import TaskFour.DoubleLinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DoubleLinkedListTest {

    private DoubleLinkedList<Integer> doubleList;
    private final int LISTSIZE = 15;

    @Before
    public void constructor(){
        doubleList = new DoubleLinkedList<>();
        for (int i = 0; i < LISTSIZE; i++) {
            doubleList.add(i);
        }
    }

    @Test
    public void getSize(){
        Assert.assertTrue(LISTSIZE == doubleList.size());
    }

    @Test
    public void lastElement(){
        Assert.assertTrue((LISTSIZE - 1) == doubleList.remove());
    }

    @Test
    public void firstElement(){
    }

    @Test
    public void notNullInstance(){
        Assert.assertNotNull(doubleList);
    }

    @Test
    public void notNullInstanceIterator(){
        Assert.assertNotNull(doubleList.iterator());
    }

    @Test
    public void addTail(){
        int answer = -1;
        doubleList.addTail(answer);
        Assert.assertTrue(answer == doubleList.removeTail());
    }
}
