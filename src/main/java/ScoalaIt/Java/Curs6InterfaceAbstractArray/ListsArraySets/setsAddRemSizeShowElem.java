package ScoalaIt.Java.Curs6InterfaceAbstractArray.ListsArraySets;

import java.util.HashSet;
import java.util.Set;

public class setsAddRemSizeShowElem {

    public void sets(){

        Set<Double> mySet = new HashSet<>();

        mySet.add(2.0);
        mySet.add(3.1);
        mySet.add(2.0);

        for(Double myset: mySet) {
            System.out.println(myset);
        }
        System.out.println();

        System.out.println(mySet.size());
        mySet.remove(2.0);
        System.out.println(mySet.size());


    }
}
