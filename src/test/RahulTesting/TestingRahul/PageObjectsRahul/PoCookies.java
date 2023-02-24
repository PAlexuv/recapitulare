package TestingRahul.PageObjectsRahul;

import BaseForTestingRahul.Utils.BaseMethodsUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class PoCookies extends BasePageRahulPO{

    public PoCookies(WebDriver driver) {
        super(driver);
    }
    //VEZI SI ASTA CUM SE VEDE:
    private void printCookieNumber (String message) {
        //Get all cookies of the site
        Set<Cookie> cookies = driver.manage().getCookies();
        List<Cookie> cookieList = new ArrayList<>(cookies); //Set to List Conversion
        if (cookies.size() > 0) {
            System.out.println("Total number of Cookies ~~~" + message + "~~~ : " + cookieList.size() + "\n");
            //Print all cookie names and values
            for (int i = 0; i < cookieList.size(); i++) {
                System.out.println("Cookie " + i + " name: " + cookieList.get(i).getName() +
                        " value: " + cookieList.get(i).getValue());
            }
            System.out.println("-----------------------------------------------\n");
        } else
            System.out.println("------------------No cookies found!--------------------\n");
    }

//    public static void printCookies(WebDriver driver) {
//        Set<Cookie> cookies = driver.manage().getCookies();
//        if (cookies.size() > 0) {
//            System.out.println("The number of cookies found:" + cookies.size());
//            System.out.println("Cookie Name | Cookie Value | Cookie Expire Date");
//            //ASA AFISAM O LISTA; CU FOR
//            for (Cookie c : cookies) {
//                if (c.getExpiry() != null)
//                    System.out.println(c.getName() + " " + "|" + " " +  c.getValue() + " " +  "|"  + " " +  c.getExpiry());
//            }
//        } else
//            System.out.println("No cookies present");
//    }

    public void cookieMethods(){
        Date today    = new Date();
        Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));

//        printCookies(driver);
        printCookieNumber("Basic nr of cookies:");

//Get info about gpi cookie
        System.out.println("Get __gpi cookie info:");
        Cookie cookie = driver.manage().getCookieNamed("__gpi");
        System.out.println("Cookie name: " + cookie.getName());
        System.out.println("Cookie value: " + cookie.getValue());
        System.out.println("Cookie exp date: " + cookie.getExpiry()+ "\n");

//Copy above cookie as copiedCookie and print it
        Cookie copied__gpiCookie = driver.manage().getCookieNamed("__gpi");
        System.out.println("copied cookie: " + copied__gpiCookie + "\n");

//Create new Cookie as “newBuiltCookie” with Cookie.Builder and print it
        Cookie newBuiltCookie = new Cookie.Builder("newCBuiltookie", "Cerated by Me")
                .path("/")
                .expiresOn(tomorrow)
                .isSecure(true)
                .build();

        System.out.println("Built cookie: " + newBuiltCookie);
        System.out.println("Cookie named: " + newBuiltCookie.getName() +  " ~~~ cookie value: " + newBuiltCookie.getValue() + " ~~~ expire on: " + newBuiltCookie.getExpiry());

//Delete the __gpi cookie
        driver.manage().deleteCookie(cookie);

//print cookie number after deleting cookie.
//        printCookies(driver);
        printCookieNumber(" Nr of Cookies after deleting gpi cookie:");

//Add new cookie by using “newBuiltCookie”
        driver.manage().addCookie(newBuiltCookie);
        System.out.println("added cookie: " + newBuiltCookie.getName() + "\n");
        driver.manage().addCookie(copied__gpiCookie);
        System.out.println("added cookie: " + copied__gpiCookie.getName());
        printCookieNumber(" Nr of Cookies after adding 2 cookies:");

//Delete added cookies by me: newCreated and copied
        driver.manage().deleteCookie(newBuiltCookie);
        driver.manage().deleteCookie(copied__gpiCookie);
        printCookieNumber("cookies after Deleting the 2 that i created:");

//Delete all cookies
        driver.manage().deleteAllCookies();
        System.out.println("Deleted all cookies:");
        printCookieNumber("Deleted all cookies so we get: ");
//FA METODA DE PE GURU PT COOKIE

    }
}
