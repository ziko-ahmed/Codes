// Question : https://codeforces.com/contest/2203/problem/D

import java.util.*;
import java.io.*;

public class DivisibilityGame {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        // System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        int maxVal = 0;
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[m];
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
                maxVal = Math.max(maxVal, a[i]);
            }
        
            for(int i = 0; i < m; i++){
                b[i] = sc.nextInt();
                maxVal = Math.max(maxVal, b[i]);
            }

            String result = solve(n, m, a, b, maxVal);
            System.out.println(result);
        }

        sc.close();
    }

    public static String solve(int n, int m, int a[], int b[], int maxVal) {
        boolean present[] = new boolean[maxVal + 1];
        for(int num : a)
            present[num] = true;

        int aliceCanRemove = 0;
        int bobCanRemove = 0;
        for(int y : b){
            boolean divisible = false;
            for(int d = 1; d * d <= y; d++){
                if(y % d == 0){
                    if(d <= maxVal && present[d]){
                        divisible = true;
                        break;
                    }
                    int other = y / d;
                    if(other <= maxVal && present[other]){
                        divisible = true;
                        break;
                    }
                }
            }
            if(divisible)
                aliceCanRemove++;
            else
                bobCanRemove++;
        }
        return aliceCanRemove > bobCanRemove ? "Alice" : "Bob";
    }
}