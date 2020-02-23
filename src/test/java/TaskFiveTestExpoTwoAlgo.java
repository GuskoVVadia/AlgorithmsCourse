import TaskFive.Exponentiation;
import org.junit.Assert;
import org.junit.Test;

public class TaskFiveTestExpoTwoAlgo {

    private long value = 2;
    private int expo = 8;
    private int expoEdit = 9;
    private int answerExpo = 256;
    private int answerExpoEdit = 512;

    //тест обычного "прямого" алгоритма возведения в степень, степень чётное число
    @Test
    public void testAlgoNExpoOne(){
        Assert.assertTrue(answerExpo == Exponentiation.recurAlgoN(value, expo));
    }

    //тест обычного "прямого" алгоритма возведения в степень, степень - нечётное число
    @Test
    public void testAlgoNExpoTwo(){
        Assert.assertTrue(answerExpoEdit == Exponentiation.recurAlgoN(value, expoEdit));
    }

    //тест обычного алгоритма возведения в степень, степень чётное число
    @Test
    public void testAlgoLogNExpoOne(){
        Assert.assertTrue(answerExpoEdit == Exponentiation.recurAlgoLogN(value, expoEdit));
    }

    //тест обычного "прямого" алгоритма возведения в степень, степень - нечётное число
    @Test
    public void testAlgoLogNExpoTwo(){
        Assert.assertTrue(answerExpoEdit == Exponentiation.recurAlgoLogN(value, expoEdit));
    }

}
