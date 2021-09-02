package hooks;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private Map<String, Object> scenarioContext;

    public ScenarioContext() {
        this.scenarioContext = new HashMap<>();
    }

    public void setContext(Context key, Object value) {
        this.scenarioContext.put(key.toString(), value);
    }

    public Object getContext(Context key) {
        return this.scenarioContext.get(key.toString());
    }

    public Boolean isContains(Context key) {
        return this.scenarioContext.containsKey(key.toString());
    }
}
