package ScoalaIt.Java.Curs4VarMetStaticDin;

public class SumOfNum {
    public static int sumOfNumbers(int m, int n){
        int sum = 0;
        for(int i = m; i<=n; i++){
            sum = sum + i;
//            System.out.println(sum);
        }
        return sum;
    }
    public static void showSum(){
        System.out.println(sumOfNumbers(1, 3));
    }
}
