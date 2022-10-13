package TestNG.Curs8.deSters;

import ScoalaITesting.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class deStersCalculator {
    static Calculator c;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        c = new Calculator();
    }

    //*************************************POS
    @DataProvider(name = "data-provider-positive")
    public Object[][] dataBasePOS() {
        return new Object[][]{
                {15, 10, "+"},
                {15, 10, "-"},
                {15, 10, "*"},
                {15, 10, "/"},
                {15, 10, "SQRT"},
        };
    }
    @Test(dataProvider = "data-provider-positive", groups = {"positive"})
    public void parametersPOS(double d1, double d2, String operator) {
        System.out.println(c.compute(d1, d2, operator));
    }
//**********************************************************************
    @DataProvider(name = "data-provider-negative")
    public Object[][] dataBaseNEG() {
        return new Object[][]{
                {15, 10, "]"},
                {15, 10, "{-}"},
                {15, 10, "p"},
                {15, 10, " "},
                {15, 10, "SORT"},
        };
    }
    @Test(dataProvider = "data-provider-negative", groups = {"negative"})
    public void parametersNEG(double d1, double d2, String operator) {
        System.out.println(c.compute(d1, d2, operator));

    }

}
