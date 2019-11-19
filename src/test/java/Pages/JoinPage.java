package Pages;

import Helpers.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class JoinPage {
    private WebDriver driver;
    private SeleniumHelper helper;

    public JoinPage(WebDriver driver) {
        this.driver = driver;
        this.helper = new SeleniumHelper(driver);
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//input[@id=\"id_userName\"]")
    private WebElement usernameInput;

    @FindBy (xpath = "//input[@id=\"id_email\"]")
    private WebElement emailInput;

    @FindBy (xpath = "//input[@id=\"id_password\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id=\"id_passwordConf\"]")
    private WebElement passwordConfirmInput;

    @FindBy(xpath = "//*[@id=\"id_terms\"]")
    private WebElement agreementCheckbox;

    @FindBy(xpath = "//button[@class = 'btn-primary']")
    private WebElement createAccountButton;

    @FindBy (xpath = "//input[@id=\"id_password\"]/parent::div//div[@class= 'alert alert-danger']")
    private WebElement alert;

    @FindBy(xpath = "//*[@id=\"_evidon-accept-button\"]")
    private WebElement evidonAcceptButton;

    public JoinPage enterUsername(String username){
        usernameInput.clear();
        usernameInput.sendKeys(username);
        return this;
    }

    public JoinPage enterEmail(String email){
        emailInput.clear();
        emailInput.sendKeys(email);

        return this;
    }

    public JoinPage enterPassword(String password){
        passwordInput.clear();
        passwordInput.sendKeys(password);

        return this;
    }

    public JoinPage confirmPassword(String password){
        passwordConfirmInput.clear();
        passwordConfirmInput.sendKeys(password);

        return this;
    }

    public JoinPage agreeTermsOfUse(){
        if (!agreementCheckbox.isSelected()){
            agreementCheckbox.click();
        }
        return this;
    }
    public JoinPage hideCookieBanner(){
        helper.waitForEelement(evidonAcceptButton);
        evidonAcceptButton.click();
        return this;
    }

    public void clickCreateAccButton(){
        createAccountButton.click();
    }

    public String getAlertMessage(){
        helper.waitForEelement(alert);
        return alert.getText();
    }







}


