package TestNG.Curs8;

import org.testng.Assert;
import org.testng.annotations.*;


@Test
public class MyFirstTestNgTest {

    @BeforeClass
    public void setUp(){
        System.out.println("Set up test elements");
        System.out.println("Init browser + open site url..");
    }

    //******************************************** DATA PROVIDERS *********************************************************
    //DATA PROVIDER HARCODAT
    @DataProvider(name = "registerDataProvider")
    public Object[][] registerDataProvider(){
        return new Object[][]{
                {"test@test.com", "Ion Vasile" , "Bucuresti"},
                {"test1@test.com", "Maria Boc" , "Iasi"},
                {"test2@test.com", "Stefan Mircea" , "Cluj"}
        };
    }
    @Test(dataProvider = "registerDataProvider")
    public void registerUser(String email, String name, String adresa){
        System.out.println("register user: { email: " + email + ", name: " + name+ ", adresa: " + adresa + "}");
    }

    //************************************* PARAMETRIZAREA TESTELOR - ADICA GENERAL VALABILE **********************************************************
    @Test
    @Parameters({"email", "pass"})
    public void loginWithEmailAndPass(String email, String pass){
        System.out.println("Login with email: "+ email + " / Login with pass: " + pass);
    }

    //********* @test can have description, Priority(default 0) / Create a method so 1 test depend on other ***************

    @Test(description = "method used for login with valid user", priority = 1, groups = {"smoke"})
        public void loginUserTest(){
        System.out.println("Run login user test");
//        Assert.assertFalse(true);
    }

    @Test(description = "test for edit user", priority = 2, groups = {"smoke"})
    public void testEditAccount(){
        System.out.println("Run test Edit User Account");
    }

    @Test(dependsOnMethods = "loginUserTest", priority = 3, groups = {"smoke"})
    public void testEditAccountDependsOnLogin(){
        System.out.println("Run Edit Account only if Login User Test Passed");
        }

        @Test(dependsOnMethods = {"loginUserTest" , "testEditAccountDependsOnLogin"}, alwaysRun = true, groups = {"regression"})
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
