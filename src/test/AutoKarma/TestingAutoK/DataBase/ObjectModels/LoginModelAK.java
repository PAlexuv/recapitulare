package TestingAutoK.DataBase.ObjectModels;

import org.openqa.selenium.WebDriver;

public class LoginModelAK {

    private AccountLoginModelAK account;
    private String userErr;
    private String passwordErr;

    public LoginModelAK(WebDriver driver) {

    }

    public AccountLoginModelAK getAccount() {
        return account;
    }
    public void setAccount(AccountLoginModelAK account) {
        this.account = account;
    }

    public String getUserErr() {
        return userErr;
    }
    public void setUserErr(String userErr) {
        this.userErr = userErr;
    }

    public String getPasswordErr() {
        return passwordErr;
    }
    public void setPasswordErr(String passwordErr) {
        this.passwordErr = passwordErr;
    }

}
