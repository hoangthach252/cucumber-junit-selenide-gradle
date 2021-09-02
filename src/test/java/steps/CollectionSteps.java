package steps;

import ch.qos.logback.classic.Logger;
import hooks.Context;
import hooks.DataStorage;
import hooks.ScenarioContext;
import io.cucumber.java.en.When;
import org.slf4j.LoggerFactory;
import pages.CollectionPage;
import pages.CreateNewCollectionForm;
import pages.HomePage;
import pages.SearchResultPage;
import utils.PropertyUtils;
import utils.RandomUtils;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CollectionSteps extends AbstractStep {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(CollectionSteps.class);

    private final DataStorage dataStorage;
    private final HomePage homePage;
    private final SearchResultPage searchResultPage;
    private final CreateNewCollectionForm createNewCollectionForm;
    private final CollectionPage collectionPage;
    private final ScenarioContext scenarioContext;


    public CollectionSteps(DataStorage dataStorage, HomePage homePage, SearchResultPage searchResultPage,
                           CreateNewCollectionForm createNewCollectionForm, CollectionPage collectionPage,
                           ScenarioContext scenarioContext) {
        this.dataStorage = dataStorage;
        this.homePage = homePage;
        this.searchResultPage = searchResultPage;
        this.createNewCollectionForm = createNewCollectionForm;
        this.collectionPage = collectionPage;
        this.scenarioContext = scenarioContext;

    }

    @When("^he searches pics with keyword \"(.*)\"$")
    public void search_pics_with_keyword(String keyword) throws Throwable {
        homePage.enterSearch(keyword);
    }

    @When("^he adds the first image into new collection name \"(.*)\"$")
    public void add_first_image_to_collection(String collectionName) throws Throwable {
        searchResultPage.addFirstPicToCollection();
        searchResultPage.createNewCollection();
        collectionName = collectionName + RandomUtils.getRandomNumber();
        logger.info("New created Collection Name: " + collectionName);
        createNewCollectionForm.createNewCollection(collectionName, "", false);
        scenarioContext.setContext(Context.COLLECTION_NAME, collectionName);
        dataStorage.setCollectionNames(collectionName);
    }

    @When("^he navigates to his collection page$")
    public void navigate_collection_page() throws Throwable {
        open(PropertyUtils.getBaseUrl() + "@" + PropertyUtils.getUserProfile() + "/collections");
    }

    @When("^he can see the new collection is added in his collection$")
    public void check_collection_added() throws Throwable {
        String collectionName = (String) scenarioContext.getContext(Context.COLLECTION_NAME);
        assertThat(collectionPage.getCollectionNameList()).contains(collectionName);
    }
}
