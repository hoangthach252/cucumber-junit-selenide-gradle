package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {

    private final SelenideElement photoGrid = $("div[data-test='masonry-grid-count-three']");
    private final SelenideElement firstPhoto = photoGrid.findAll("figure").first();
    private final SelenideElement addCollectionBtn = photoGrid.find("button[title='Add to collection']");
    private final SelenideElement newCollectionName = $(By.xpath("//button[text()='Create a new collection']"));

    public void addFirstPicToCollection() {
        firstPhoto.hover();
        addCollectionBtn.click();
    }

    public void createNewCollection() {
        newCollectionName.click();
    }

}
