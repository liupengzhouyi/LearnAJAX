package experiment_1And2.experiment1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liupeng
 */
public class ReadMap {

    private Map<String, String> myMap = null;

    private void createMyMap() {
        this.myMap = new HashMap<>();
    }

    public Map<String, String> getMyMap() {
        return myMap;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void init() {
        myMap.put("Zara", "8");
        myMap.put("Mahnaz", "31");
        myMap.put("Ayan", "12");
        myMap.put("Daisy", "14");
    }

    public ReadMap() {
        this.createMyMap();
        this.init();
    }
}
