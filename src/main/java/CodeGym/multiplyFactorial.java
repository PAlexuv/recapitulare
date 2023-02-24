package CodeGym;

import javax.swing.*;
import java.util.Scanner;

public class multiplyFactorial {

    public multiplyFactorial(){

    }

    public int multiply() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int f=1;
        for (int i = 1; i<=n; i++){
            f=f*i;
            System.out.println(f);
        }
        return f;
    }


}
