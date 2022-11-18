import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class MyJsonSimpleParser {

    private static final String TAG_ID = "id";
    private static final String TAG_VAlUES = "values";
    private static final String TAG_VAlUE = "value";
    private final JSONParser parser = new JSONParser();

    private HashMap<Long, String> parseJsonValues(String filename) {

        JSONArray valuesJsonArray;
        HashMap<Long, String> map = new HashMap<>();

        try (FileReader fr = new FileReader(filename)) {
            JSONObject rootJsonObject = (JSONObject) parser.parse(fr);
            valuesJsonArray = (JSONArray) rootJsonObject.get(TAG_VAlUES);

            for (Object it : valuesJsonArray) {
                JSONObject valueJsonObject = (JSONObject) it;

                long id = (Long) valueJsonObject.get(TAG_ID);
                String value = (String) valueJsonObject.get(TAG_VAlUE);

                map.put(id, value);
            }

            return map;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONObject buildJsonReport(String filenameTests, String filenameValues) throws Exception {

        long idToFind;
        String valueToPut = null;
        HashMap<Long, String> map = parseJsonValues(filenameValues);

        try (FileReader fr = new FileReader(filenameTests)) {

            JSONObject rootJsonObject = (JSONObject) parser.parse(fr);

            idToFind = (Long) rootJsonObject.get(TAG_ID);
            if (map != null)
                valueToPut = map.get(idToFind);

            if (valueToPut != null)
                rootJsonObject.put(TAG_VAlUE, valueToPut);


            JSONArray valuesJsonArray = (JSONArray) rootJsonObject.get(TAG_VAlUES);

            for (Object it : valuesJsonArray) {
                JSONObject valueJsonObject = (JSONObject) it;

                idToFind = (Long) valueJsonObject.get(TAG_ID);
                valueToPut = map.get(idToFind);

                if (valueToPut != null)
                    valueJsonObject.put(TAG_VAlUE, valueToPut);

            }
            return rootJsonObject;


        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
