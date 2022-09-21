package ScoalaIt.Curs3ConstructorSetterInstantiere;

public class TCircle {
    float radius;
    static final float PI= 3.141492f;

    //CONSTRUCTOR
    public TCircle(float radius){
        this.radius = radius;
    }
    //CONSTRUCTOR OVERLOADING: asa putem apela constructorul si fara parametri. Nu este recomandat!
    public TCircle(){
    }
/////

    //SETTER: apelam atributul prin SET si facem in main:
    public void setRadius(float radius){
        this.radius = radius;
    }

    ///////
    public float diameter(){
        return radius*2;
    }

    public float getArea(){
        return PI*radius*radius;
    }




}
