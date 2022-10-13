package ScoalaITesting.JUnitCalculator;

import ScoalaITesting.Calculator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    static Calculator c;

    //instantiem obiectul Calculator(transformam clasa in obiect) aplicam variabilei c - Calculator - prin new(instantiere)
    @BeforeClass
    public static void setUp(){
        c=new Calculator();
    }

    @Test
    public void testSumaPositive(){
        System.out.println("Suma: " + c.compute(4,5,"+")+" equals 9 ");
        Assert.assertEquals(9, c.compute(4,5,"+"),0);
    }

    @Test
    public void testSumaNegative(){
        System.out.println("Suma: " + c.compute(-5,-2,"+")+" equals -7 ");
    Assert.assertEquals(-7, c.compute(-5, -2, "+"),0);
    }

    @Test
    public void testMultiply(){
        System.out.println("multiply: " + c.compute(7, 8, "*")+ " equals 56");
        Assert.assertEquals(56, c.compute(7, 8, "*"),0);
    }

    @Test
    public void testNegativeMultiply(){
        System.out.println("negative multiply: " + c.compute(-5, -3, "*")+" expected -15");
        Assert.assertEquals(-15, c.compute(5, -3, "*"),0);
    }

    @Test
    public void testMinus(){
        System.out.println("minus result is: " + c.compute(780, 530, "-")+" expected: 250 ");
        Assert.assertEquals(250, c.compute(780, 530, "-"), 0);
    }

    @Test
    public void testMinusWNegative(){
        System.out.println("minus result with negative numbers: " + c.compute(-7, 1, "-") + " expected: -8");
        Assert.assertEquals(-8, c.compute(-7, 1, "-"), 0);
    }

}