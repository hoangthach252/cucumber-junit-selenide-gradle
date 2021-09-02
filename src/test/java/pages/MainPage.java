package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private final SelenideElement loginLink = $("nav a[href='/login']");
    private final SelenideElement signUpLink = $(By.xpath("//nav//a[text()='Join free']"));

    public void clickOnLoginLink() {
        loginLink.click();
    }

    public void clickJoinFreeLink() {
        signUpLink.click();
    }

}
