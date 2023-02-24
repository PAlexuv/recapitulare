package Testing.DataBase;

import baseForTesting.Utils.baseSetUp;
import org.testng.annotations.DataProvider;

public class dataBaseRegisterDouglas extends baseSetUp {
        @DataProvider(name = "positiveRegisterData")
        public Object[][] positiveRegisterData() {
            return new Object[][]{
                    {"chrome", "prenume", "nume", "user@yahoo.com", "Password", "0784759876", "str douglas 97", "700887", "cluj"},
            };
        }

        @DataProvider(name = "negativeRegisterData")
        public Object[][] negativeRegisterData() {
            return new Object[][]{
                    {"chrome", "prenume", "nume", "user@yahoo.com", "Password", "0784759876", "str douglas 97", "700887", ""},
                    {"chrome", "prenume", "nume", "user@yahoo.com", "Password", "0784759876", "str douglas 97", "", "cluj"},
                    {"chrome", "prenume", "nume", "user@yahoo.com", "Password", "0784759876", "", "700887", "cluj"},
                    {"chrome", "prenume", "nume", "user@yahoo.com", "Password", "", "str douglas 97", "700887", "cluj"},
                    {"chrome", "prenume", "nume", "user@yahoo.com", "", "0784759876", "str douglas 97", "700887", "cluj"},
                    {"chrome", "prenume", "nume", "", "Password", "0784759876", "str douglas 97", "700887", "cluj"},
                    {"chrome", "prenume", "", "user@yahoo.com", "Password", "0784759876", "str douglas 97", "700887", "cluj"},
                    {"chrome", "", "nume", "user@yahoo.com", "Password", "0784759876", "str douglas 97", "700887", "cluj"},
            };
        }
    }
