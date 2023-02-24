package CodeGym;

import java.util.Scanner;

public class CircleAreaPIDoubleInt {

        public double CircleArea() {
                final double PI = 3.14;

                Scanner scanner = new Scanner(System.in);
                double radius = scanner.nextDouble();
                double area = PI * radius * radius;
                int areaI = (int) (area);

                return areaI;
        }
}
