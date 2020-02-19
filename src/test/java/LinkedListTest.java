import TaskFour.SingleLinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

    private SingleLinkedList<Integer> linkedList;
    private final int LISTSIZE = 15;

    @Before
    public void constructor(){
        this.linkedList = new SingleLinkedList<>();
        for (int i = 0; i < LISTSIZE; i++) {
            this.linkedList.add(i);
        }
    }

    @Test
    public void getSize(){
        Assert.assertTrue(LISTSIZE == linkedList.size());
    }

    @Test
    public void lastElement(){
        Assert.assertTrue((LISTSIZE - 1) == linkedList.remove(LISTSIZE - 1));
    }

    @Test
    public void notNullInstance(){
        Assert.assertNotNull(linkedList);
    }

}
