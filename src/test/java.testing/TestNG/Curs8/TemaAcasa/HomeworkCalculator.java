package TestNG.Curs8.TemaAcasa;

import ScoalaITesting.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Test
public class HomeworkCalculator {
    static Calculator c;

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        c=new Calculator();
    }

    //************ DP POS **************************************************************************************
    @DataProvider(name= "data-provider-positive")
    public Object[][] numbersOperatorDataBase() {
        return new Object[][]{
            {180, 30 ,"-"},
            {65, 35 ,"+"},
            {5, 5 ,"*"},
            {245, 45 ,"/"},
            {245, 45 ,"SQRT"}
        };
    }
   @Test(dataProvider = "data-provider-positive", groups = {"positive"})
    public void dataProviderParamPos(double d1, double d2, String operator){
       System.out.println("numbers and operator: " + d1 + " " + operator + " " + d2 );
    }
    //**************************************************************************************************

    //************ DP NEG **************************************************************
    @DataProvider(name= "data-provider-negative")
    public Object[][] negativeOperatorDataBase() {
        return new Object[][]{
                {180, 30, "}"},
                {7, 35, "p"},
                {5, 5, "**"},
                {245, 45, " "},
                {245, 45, "*("}
        };
    }
    @Test(dataProvider = "data-provider-negative", groups = {"negative"})
    public void dataProviderParamNeg(double d1, double d2, String operator){
        System.out.println("numbers and operator: " + d1 + " " + " '"+ operator + "' " + d2 );
    }
    //**************************************************************************************************

    //1.
    @Test(dataProvider ="data-provider-positive", groups = {"positive"})
    public void testPositiveScenario(double d1, double d2, String operator){
        System.out.println(c.compute(d1, d2, operator));
    }
    //2.
    @Test(dataProvider ="data-provider-negative", groups = {"negative"})
    public void testNegativeScenario(double d1, double d2, String operator){
//        c.compute(d1, d2, operator);
        System.out.println(c.compute(d1, d2, operator));
    }

    }
