package Tests;

import Helpers.ExcelHelper;
import Pages.JoinPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;

public class CreateNewAccountTests extends BaseSeleniumTest {

    @Test(dataProvider = "getPasswordsList")
    public void passwordRequirementsTest(String testCase, String password, String passwordConfirm, String expectedMessage){
        driver.get("https://www.last.fm/join");
        System.out.println("Starting test case number: " + testCase);
        JoinPage joinPage = new JoinPage(driver);
        joinPage.hideCookieBanner()
                .enterUsername("useruser79")
                .enterEmail("testingu54891@gmail.com")
                .enterPassword(password)
                .confirmPassword(passwordConfirm)
                .agreeTermsOfUse()
                .clickCreateAccButton();
        String alertMessage = joinPage.getAlertMessage();
        Assert.assertTrue(alertMessage.contains(expectedMessage));

    }




    @DataProvider
    public Object[][] getPasswordsList(){
        Object[][] passwordsList = null;
        try {
            passwordsList = ExcelHelper.readExcelFile(new File("src//test//resources//passwordsList.xlsx"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return passwordsList;
    }
}
