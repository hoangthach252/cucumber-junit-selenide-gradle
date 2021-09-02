package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CreateNewCollectionForm {

    private final SelenideElement titleElm = $("input[name='title']");
    private final SelenideElement description = $("textarea[name='description']");
    private final SelenideElement privacyElm = $("input[name='privacy']");
    private final SelenideElement createCollectionBtn = $(By.xpath("//button[text()='Create collection']"));
    private final String newCollectionLocator = "//h3[text()='Add to Collection']/../ul//h4[text()='%s']";


    private void enterTitle(String title) {
        titleElm.setValue(title);
    }

    private void enterDescription(String desc) {
        description.setValue(desc);
    }

    public void createNewCollection(String title, String desc, boolean privacy) {
        enterTitle(title);
        if (desc.isEmpty()) {
            enterDescription(desc);
        }
        if (privacy) {
            privacyElm.click();
        }
        createCollectionBtn.click();
        createCollectionBtn.shouldBe(disappear);
        By newCollectionElm = By.xpath(String.format(newCollectionLocator, title));
        $(newCollectionElm).shouldBe(visible);
    }
}
