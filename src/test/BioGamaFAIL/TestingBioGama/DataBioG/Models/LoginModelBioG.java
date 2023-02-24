package TestingBioGama.DataBioG.Models;


public class LoginModelBioG {

    private BaseModelLoginBioG loginBioG;
    private String emailErrorBioG;
    private String passwordErrBioG;

    //constructor
    public LoginModelBioG(String email, String password, String emailErrBioG, String passErrBioG){

        BaseModelLoginBioG BmBioG = new BaseModelLoginBioG();
        BmBioG.setEmail(email);
        BmBioG.setPassword(password);

        this.loginBioG = BmBioG;
        this.emailErrorBioG= emailErrBioG;
        this.passwordErrBioG = passErrBioG;
    }

    public BaseModelLoginBioG getLoginBioG() {
        return loginBioG;
    }
    public void setLoginBioG(BaseModelLoginBioG loginBioG) {
        this.loginBioG = loginBioG;
    }

    public String getEmailErrorBioG() {
        return emailErrorBioG;
    }
    public void setEmailErrorBioG(String emailErrorBioG) {
        this.emailErrorBioG = emailErrorBioG;
    }

    public String getPasswordErrBioG() {
        return passwordErrBioG;
    }
    public void setPasswordErrBioG(String passwordErrBioG) {
        this.passwordErrBioG = passwordErrBioG;
    }
}
