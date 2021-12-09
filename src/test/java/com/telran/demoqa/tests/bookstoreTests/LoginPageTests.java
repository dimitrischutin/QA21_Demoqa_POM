package com.telran.demoqa.tests.bookstoreTests;

import com.telran.demoqa.data.UserData;
import com.telran.demoqa.pages.bookstorePages.BookStorePage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.bookstorePages.LoginPage;
import com.telran.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getBookStore();
        new BookStorePage(driver).getLoginPage();

    }

    @Test(enabled = false)
    public void loginPositiveTest() {
        new LoginPage(driver).closeBanner();
        new LoginPage(driver).login(UserData.USER_NAME, UserData.USER_PASSWORD)
                .verifyUserName("neuer").logout();
    }

    @Test
    @Parameters({"name","password"})
    public void loginPositiveParametersTest(String name, String password) {
        new LoginPage(driver).closeBanner();
        new LoginPage(driver).login(name, password)
                .verifyUserName(name).logout();
    }


}
