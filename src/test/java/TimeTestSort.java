import TaskTwo.ArrayTask;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TimeTestSort {

    private ArrayTask testArray;

    @Before
    public void construct(){
        testArray = new ArrayTask(500_000);
        testArray.fillRandom();
    }

    @Test
    public void startBubbleSort(){
        testArray.sortBubble();
    }

    @Test
    public void startSelectSort(){
        testArray.sortSelect();
    }

    @Test
    public void startInsertSort(){
        testArray.sortInsert();
    }

}
