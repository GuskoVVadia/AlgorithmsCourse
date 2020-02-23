import TaskFive.BackPackTask;
import org.junit.Assert;
import org.junit.Test;

public class TaskFiveTestBackPack {

    private int[] weight = {2, 3, 3, 4};
    private int[] val = {1, 2, 5, 9};
    private int w = 7;

    //проверяем с заданными на уроке значениями
    @Test
    public void answerTrueTestOne(){
        int answer = BackPackTask.recursive(weight, val, w, 0);
        Assert.assertTrue(14 == answer);
    }

    //изменяем ценность и проверяем правильность ответа
    @Test
    public void answerTrueTestTwo(){
        val[1] = 8;
        int answer = BackPackTask.recursive(weight, val, w, 0);
        Assert.assertTrue(17 == answer);
    }
}
