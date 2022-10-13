package ScoalaIt.Java.Curs6InterfaceAbstractArray.ListsArraySets;

import java.util.HashMap;

public class mapsHashMapsPutGetKeySetValues {

    public void mapsHash(){

        HashMap <String, String> myMap = new HashMap<>();

        myMap.put("ion", "copilarie");
        myMap.put("emi", "pasarele");
        myMap.put("ion", "capra");
        myMap.put("rebre", "plumb");

        System.out.println("display hashmap element using get for ion - overrided cause 2 elements:");

//identify 1 hashmap element
        System.out.println(myMap.get("ion"));
        System.out.println();

        System.out.println("display hashmap elements using their keys:");

// identify the key:
        for(String key: myMap.keySet()){
            System.out.println("cheie: " + key + " / " + "valoare: " +myMap.get(key));
        }

// identify the value:
        System.out.println("display hashmap elements using values:");
        for (String val: myMap.values()){
            System.out.println(val);
        }
        System.out.println();

        //remove hashMap se poate face doar pe keySet nu pe Value
        myMap.remove("ion");
        for(String key: myMap.keySet()){
            System.out.println(key);
        }
        System.out.println();
        System.out.println("keys : " + myMap.keySet() +" values: "+ myMap.values());

    }
}
