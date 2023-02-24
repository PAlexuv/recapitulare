package BaseForTestingAutoK.UtilsAK;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class DataUtils extends BaseSetUpAK {

//    @DataProvider
//    public Object[][] dataProvider1() throws IOException, ParseException {
//
//        JSONParser parser = new JSONParser();
//        JSONObject jsonObject = null;
//
//        //read file
//        try {
//            Object obj = parser.parse(new FileReader("src/test/AutoKarma/BaseForTestingAutoK/ResourcesAK/testdata.json"));
//            jsonObject = (JSONObject) obj;
//        } catch (IOException | ParseException exception) {
//            exception.printStackTrace();
//        }
//
//        //Array to store JSON data
//        Object[] data = new Object[1];
//
//        //store JSON data as key/value pairs in a hashMap
//        HashMap<String, String> hashMap = new LinkedHashMap<>();
//        if(jsonObject != null){
//            Set<String> jsonObjKeys = jsonObject.keySet();
//            for(String jsonObjKey : jsonObjKeys){
//                hashMap.put(jsonObjKey, jsonObject.get(jsonObjKey));
//            }
//        }else {
////            log.error("Error retrieveing JSON data");
//        }
//    }
}
