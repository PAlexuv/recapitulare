package ScoalaIt.curs4VarMetStaticDin;

import java.awt.*;

public class Car {

    public static int nrOfCars = 0;
    private float fuelLevel = 0;
    private byte gear;
    private float speed;
    private Color color;

    public Car(float fuelLevel){
        nrOfCars++;
        this.fuelLevel++;
    }

    //Getter
    public static int getNrOfCarsStatic(){
        return nrOfCars;
    }

    public int getNrOfCars(){
        return nrOfCars;
    }

    public float getFuelLevel() {
        return fuelLevel;
    }
    public byte getGear() {
        return gear;
    }
    public float getSpeed() {
        return speed;
    }
    public Color getColor() {
        return color;
    }

    //Setter
    public static void setNrOfCars(int nrOfCars) {
        Car.nrOfCars = nrOfCars;
    }
    public void setFuelLevel(float fuelLevel) {
        this.fuelLevel = fuelLevel;
    }
    public void setGear(byte gear) {
        this.gear = gear;
    }
    public void setSpeed(float speed) {
        this.speed = speed;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "fuelLevel=" + fuelLevel +
                ", gear=" + gear +
                ", speed=" + speed +
                ", color=" + color +
                '}';
    }
}
