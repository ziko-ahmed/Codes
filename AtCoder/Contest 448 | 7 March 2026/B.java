// Question : https://atcoder.jp/contests/abc448/tasks/abc448_b

import java.util.*;
import java.io.*;

public class B {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        // System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        Scanner sc = new Scanner(System.in);

        // Check if input exists
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        int m = sc.nextInt();

        long[] c = new long[m + 1];
        for(int j = 1; j <= m; j++)
            c[j] = sc.nextLong();

        int a[] = new int[n];
        long b[] = new long[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            b[i] = sc.nextLong();
        }
        long result = solve(n, m, c, a, b);
        System.out.println(result);
        sc.close();
    }

    public static long solve(int n, int m, long[] c, int[] a, long[] b) {
        long requested[] = new long[m + 1];
        
        for(int i = 0; i < n; i++)
            requested[a[i]] += b[i];
        
        long totalPepper = 0;
        
        for(int j = 1; j <= m; j++)
            totalPepper += Math.min(c[j], requested[j]);
        
        return totalPepper;
    }
}