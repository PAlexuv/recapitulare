package TestNG.Curs8;

import ScoalaITesting.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class calculatorTestNGTest {
    static Calculator c;
    static int count;

    @BeforeClass
    public void setUp(){
        c=new Calculator();
        count = 0;

    }
//threadPool - workeri - fire de executie in paralel va rula testul de 2 ori cate 5
//    @Test(invocationCount = 10, successPercentage = 20) //threadPoolSize = 5,
//    public void testInvocation(){
//        System.out.println("Run invocation test: " + count);
////        if(count<8) {
////            Assert.assertTrue(true);
////        }
//        //acelasi lucru cu:
//        Assert.assertTrue(count<5);
//        count++;
//    }

//testing operator exception from  - Calculator -  class
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testException(){
        c.compute(1,11,"7");
    }

//login with valid user, skipped as assert false(blocker at manual)
    @Test(description = "method used for login with valid user", priority = 1)
    public void loginUserTest(){
        System.out.println("Run login user test");
        Assert.assertFalse(true);
    }

//edit user Only after login priority 2
    @Test(description = "test for edit user", priority = 2)
    public void testEditAccount(){
        System.out.println("Run test Edit User Account");
    }

    // edit user - DEPEND ON - login user test
    @Test(dependsOnMethods = "loginUserTest")
    public void testEditAccountDependsOnLogin(){
        System.out.println("Run Edit Account only if Login User Test Passed");
    }

//multiple dependencies of tests, but alwaysRun
    @Test(dependsOnMethods = {"loginUserTest" , "testEditAccountDependsOnLogin"}, alwaysRun = true)
    public void testLogout(){
        System.out.println("Log out Test");
    }

    public void myTestMethod3(){
        System.out.println("Run test method 3");
    }
//**************** Until here *********************


    @Test(enabled = false) // acest test nu ruleaza
    public void myTestMethod2(){
        System.out.println("Run test method 2");
    }

    // ************** only public will be tested not proteced or private **************
    protected void myTestMethod4(){
        System.out.println("Run test method 3");
    }

    @AfterClass
    public void cleanUp(){
        System.out.println("logout, close browser");
    }

}
