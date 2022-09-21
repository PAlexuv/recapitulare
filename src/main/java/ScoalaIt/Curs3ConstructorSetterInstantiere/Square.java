package ScoalaIt.Curs3ConstructorSetterInstantiere;

public class Square {
    float latura;

//CONSTRUCTTOR
    public Square(float latura){
        this.latura = latura;
    }

    public void setLatura(float latura){
        this.latura = latura;
    }

    public float getPerim(){
        return latura*4;
    }

    public float getAria(){
        return latura*latura;
    }

    public void displayLatura(){
        System.out.println("This is a square with a side: " + this.latura);
    }
}
