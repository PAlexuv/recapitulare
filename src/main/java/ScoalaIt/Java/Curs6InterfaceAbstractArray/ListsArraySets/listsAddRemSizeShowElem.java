package ScoalaIt.Java.Curs6InterfaceAbstractArray.ListsArraySets;

import java.util.ArrayList;
import java.util.List;

public class listsAddRemSizeShowElem {

    public void lists() {

        List<String> myList = new ArrayList<>();

        for(String listEl: myList){
            System.out.println(listEl);

        myList.add("elem1");
        myList.add("elem2");
        myList.add("elem3");

        System.out.println("one element: "+ myList.get(2));
        System.out.println();

        myList.remove(2);
        System.out.println(myList.size());


        }
    }


}
