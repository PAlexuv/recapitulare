package ScoalaIt.Java.Curs3ConstructorSetterInstantiere;

public class PrimeNumbers {
    private int x, y;

    public PrimeNumbers(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean isPrime(int n) {
        for (int i = 2; i < n / 2; i++)
            if (n % i == 0)
                return false;
            return true;
    }

    public void displayPrime(){
        for(int i=x; i<=y; i++)
            if(isPrime(i))
                System.out.println(i);
    }

}
