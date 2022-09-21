package ScoalaIt.curs4VarMetStaticDin;

public class LightIncreaseDecrease {
    private final int MIN=0, MAX=100;
    private int intensity;
    private int delta;//cu cat creste intesitatea: aasta inseamna delta

    public LightIncreaseDecrease(int delta ){
        this.delta = delta;
    }

    public void turnON(){
        this.intensity = MAX;
        System.out.println("Light is ON...");
    }

    public void turnOFF(){
        this.intensity = MIN;
        System.out.println("Light is OFF...");
    }

//    delta<=intesity / int-delta>=0 acelasi lucru
//    if delta>int delta ==0
    public void dimLight(){
        if(this.delta<=this.intensity){
            this.intensity = this.intensity - this.delta;
        }
        else {
            this.intensity = 0;
        }
        System.out.println("Intensity after dim: " + this.intensity);
    }

    // if intensity<=MAX-delta
    //else intensity = MAX
    //intensity = intensity + delta / intensity+=delta
    public void increaseLight(){
        if (this.intensity<=MAX-delta)
            this.intensity+=delta;
        else
            this.intensity = MAX;
        System.out.println("Intensity after increase: " + this.intensity);
    }

    // principiul OVERLOAD: acelasi nume al metodei dar cu ceva diferit: un parametru in cazu nostru
    public void increaseLight(int nrOfIncreases){
        for(int i=1; i<=nrOfIncreases;i++)
            this.increaseLight();
    }

    public void dimLight(int nrOfDecreases){
        for(int i=1; i<=nrOfDecreases;i++)
            this.dimLight();
    }

}
