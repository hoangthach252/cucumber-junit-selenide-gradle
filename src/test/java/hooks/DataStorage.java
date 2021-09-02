package hooks;

import helper.CollectionHelper;

import java.util.ArrayList;
import java.util.List;

public class DataStorage {

    private final List<String> collectionNames;

    public DataStorage() {
        this.collectionNames = new ArrayList<>();
    }

    private List<String> getCollectionNames() {
        return this.collectionNames;
    }

    public void setCollectionNames(String collection) {
        this.collectionNames.add(collection);
    }

    private void cleanUpCollection() {
        if (!getCollectionNames().isEmpty()) {
            for (String collectionName : getCollectionNames()) {
                boolean status = CollectionHelper.deleteCollectionById(CollectionHelper.getCollectionIdByName(collectionName));
                if (!status) {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!! DELETE COLLECTION " + collectionName + " IS FAILED");
                }
            }
        }
    }

    public void cleanUpAll() {
        cleanUpCollection();
    }

}
