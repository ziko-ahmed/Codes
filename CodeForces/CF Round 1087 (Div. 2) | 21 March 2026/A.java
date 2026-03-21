// Question : https://codeforces.com/contest/2209/problem/A

import java.util.*;
import java.io.*;

public class A {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        // System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long c = sc.nextLong();
            long k = sc.nextLong();
            long arr[] = new long[n];
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextLong();

            long result = solve(n, c, k, arr);
            System.out.println(result);
        }

        sc.close();
    }

    public static long solve(int n, long c, long k, long arr[]) {
        Arrays.sort(arr);
        for(long num : arr){
            if(num > c)
                break;
            long use = Math.min(k, c - num);
            num += use;
            k -= use;
            c += num;
        }
        return c;
    }
}