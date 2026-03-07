// Question : https://codeforces.com/contest/2200/problem/A

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
            int a[] = new int[n];
            for(int i = 0; i < n; i++)
                a[i] = sc.nextInt();

            int result = solve(n, a);
            System.out.println(result);
        }
        sc.close();
    }

    public static int solve(int n, int a[]) {
        int res = 1;
        Arrays.sort(a);
        for(int i = n - 1; i > 0; i--){
            if(a[i] == a[i - 1])
                res++;
            else
                break;
        }
        return res;
    }
}