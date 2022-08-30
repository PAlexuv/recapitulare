package LearningJava.Curs3ConstructorSetterInstantiere;

public class DrawOutline {
    public static void drawShapeOutline(int height, int width) {

        for (int i = 0; i < height; i++) {
            System.out.print("*");
            System.out.print(" ");
        }
        System.out.println();

        for (int i = 0; i < height-8; i++) {
            System.out.print("*");
            System.out.print(" ");
            for (int j = 0; j < width+6; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();

        }
        for (int i = 0; i < width; i++) {
            System.out.print("*");
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        drawShapeOutline(10, 10);

    }
}

