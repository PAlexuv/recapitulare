package CodeGym;

import java.util.Scanner;

public class DivideDoubleNumbers{

    Scanner scanner = new Scanner(System.in);
    double cans = scanner.nextDouble();
    double ppl = scanner.nextDouble();

    public DivideDoubleNumbers(){
        this.cans = cans;
        this.ppl = ppl;

    }

    public double divide(){
        double result = cans*1. /ppl;
        System.out.println(result);
        return result;
    }
}
