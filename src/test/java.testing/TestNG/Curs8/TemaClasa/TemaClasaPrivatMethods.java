package TestNG.Curs8.TemaClasa;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class TemaClasaPrivatMethods {

    @BeforeClass
    public void setUp(){
        System.out.println("set-up elements for class activity");
    }

    private void privateMethod(String parameter){
        System.out.println("string parameter is: " + parameter);
    }

    @Test(enabled = false)
    public void method1(){
        privateMethod("parameter1");
    }

    @Test
    public void method2(){
        privateMethod("parameter2");
    }


}
