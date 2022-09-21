package ScoalaIt.Curs3ConstructorSetterInstantiere;

public class DrawShapeCorners {

    private int height, width;
    public Object drawShapeCorners;

    public DrawShapeCorners(int height, int width) {
    this.height = height;
    this.width = width;
    }

    public boolean drawShapeCorner() {
        for (int i = 0; i < height-2; i++) {
            System.out.print("*");
            System.out.print(" ");

            for (int j = 0; j < width-2; j++) {
                System.out.print(" ");
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println(" ");
            System.out.println(" ");
        }
        return false;
    }
}


