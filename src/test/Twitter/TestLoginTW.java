import Twitter.BaseForTesting.UtilsTW.BaseSetUpTW;
import Twitter.PageObjects.PoLoginPageTW;
import com.google.gson.internal.bind.util.ISO8601Utils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLoginTW extends BaseSetUpTW {

    @BeforeTest
    public void beforePositiveTest(){
        System.out.println("This is a positive test");
    }

    @Test
    public void testPositiveLogin() {
        driver.get(hostnameTW + "/i/flow/login" );
        //intantiate
        PoLoginPageTW loginPageTW = new PoLoginPageTW();
        //attempt login
        System.out.println("Login tests");
//        loginPageTW.loginTW("UserA", "InvalidPass");
//        //get error message
//        String errorMessage = loginPageTW.getErrorMessage();
//        //verify error message
//        Assert.assertEquals(errorMessage, "The username and password you entered did not match our records, Please double-check and try again.", "Error message not found");
    }
}
