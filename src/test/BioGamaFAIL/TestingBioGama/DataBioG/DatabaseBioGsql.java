package TestingBioGama.DataBioG;

import BaseForTestingBioGama.UtilsBioG.BaseMethodsBioG;

import java.io.IOException;
import java.util.Properties;

public class DatabaseBioGsql {

    public static String dbHostname, dbUser, dbSchema, dbPassword, dbPort;

    static {
        Properties prop = null;
        try {
            prop = BaseMethodsBioG.readPropertiesBioG("src/test/BioGama/BaseForTestingBioGama/ResourcesBioG/frameworkBioG.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert prop != null;
        dbHostname = prop.getProperty("dbHostname");
        System.out.println("Use dbHostname:" + dbHostname);
        dbUser = prop.getProperty("dbUser");
        System.out.println("Use dbUser:" + dbUser);
        dbPort = prop.getProperty("dbPort");
        System.out.println("Use dbPort:" + dbPort);
        dbPassword = prop.getProperty("dbPassword");
        System.out.println("Use dbPassword:" + dbPassword);
        dbSchema = prop.getProperty("dbSchema");
        System.out.println("Use dbSchema:" + dbSchema);
    }

    public void databaseSetup() throws IOException {
        // get DB connection settings

    }

//    public static Iterator<Object[]> getNegativeLoginData() {
//        Collection<Object[]> dp = new ArrayList<>();
//        try {
//            Connection connection = DriverManager.getConnection("jdbc:mysql://" + dbHostname + ":" + dbPort
//                    + "/" + dbSchema, dbUser, dbPassword);
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM login_negative");
//            while (resultSet.next()) {
//                LoginModelBioG lm = new LoginModelBioG(getEscapedElement(resultSet, "email"),
//                        getEscapedElement(resultSet, "password"),
//                        getEscapedElement(resultSet, "emailErr"),
//                        getEscapedElement(resultSet, "passwordErr")
//                );
//                dp.add(new Object[]{lm});
//            }
//            connection.close();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return dp.iterator();
//    }


}

