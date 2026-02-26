import java.util.*;
import java.io.*;

public class B {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        // System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int result = solve(n);
            System.out.println(result);
        }

        sc.close();
    }

    public static int solve(int n){
        int k = 1;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                k *= i; 
                while(n % i == 0){
                    n /= i;
                }
            }
        }
        if(n > 1)
            k *= n;
        return k;
    }
}