// Question : https://atcoder.jp/contests/abc450/tasks/abc450_d

import java.util.*;
import java.io.*;

public class D {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int result = solve(n, k, arr);
        System.out.println(result);

        sc.close();
    }

    public static int solve(int n, int k, int arr[]) {
        int rem[] = new int[n];
        for(int i = 0; i < n; i++)
            rem[i] = arr[i] % k;
        Arrays.sort(rem);
        int maxGap = 0;
        for(int i = 1; i < n; i++)
            maxGap = Math.max(maxGap, rem[i] - rem[i - 1]);
        maxGap = Math.max(maxGap, k - (rem[n - 1] - rem[0]));
        return k - maxGap;
    }
}