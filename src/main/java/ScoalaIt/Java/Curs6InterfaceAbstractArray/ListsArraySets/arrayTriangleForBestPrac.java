package ScoalaIt.Java.Curs6InterfaceAbstractArray.ListsArraySets;

import ScoalaIt.Java.Curs5InheritPolymorphExtends.ShapeTriangle;

import java.awt.*;

public class arrayTriangleForBestPrac extends ShapeTriangle {

        public arrayTriangleForBestPrac(Color color) {
                super(color);
        }

        public void myTrColor() {
                arrayTriangleForBestPrac[] listOfTiangles = {new arrayTriangleForBestPrac(Color.CYAN), new arrayTriangleForBestPrac(Color.black)};
                for (arrayTriangleForBestPrac tr : listOfTiangles) {
                        System.out.println(tr);
                }
        }


}
