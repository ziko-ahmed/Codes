// Question : https://atcoder.jp/contests/abc448/tasks/abc448_a

import java.util.*;
import java.io.*;

public class A {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        // System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        Scanner sc = new Scanner(System.in);

        // 2. Read the number of test cases
        // if (!sc.hasNextInt()) return;
        // int t = sc.nextInt();

        // 3. Loop through each test case
        // while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int a[] = new int[n];
            for(int i = 0; i < n; i++)
                a[i] = sc.nextInt();

            // 4. Call your logic function and print the result
            int[] result = solve(n, x, a);
            for(int i = 0; i < n; i++)
                System.out.print(result[i]+" ");    
            System.out.println();
        // }

        // Always close your sc!
        // sc.close();
    }

    public static int[] solve(int n, int x, int a[]) {
        int res[] = new int[n];
        for(int i = 0; i < n; i++){
            if(a[i] < x){
                res[i] = 1;
                x = a[i];
            }
            else
                res[i] = 0;
        }
        return res;
    }
}