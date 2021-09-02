package pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class CollectionPage {

    private final ElementsCollection collectionName = $$(By.xpath("//div[@data-test='collection-feed-card']//a//div[text()]"));


    public List<String> getCollectionNameList() {
        return collectionName.texts();
    }
}
