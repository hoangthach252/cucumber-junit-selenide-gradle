package steps;

import hooks.DataStorage;
import hooks.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

// This Hooks need to be located in the same package with steps
public class CukesHooks {
    private final DataStorage dataStorage;

    public CukesHooks(DataStorage dataStorage){
        this.dataStorage = dataStorage;
    }

    // Load Selenide configurations
    @Before
    public void initSelenideConfig() {
        WebDriverFactory.getWebDriverInstance();
    }

    @After
    public void tearDown() {
        WebDriverFactory.closeWebDriverInstance();
        dataStorage.cleanUpAll();
    }
}
