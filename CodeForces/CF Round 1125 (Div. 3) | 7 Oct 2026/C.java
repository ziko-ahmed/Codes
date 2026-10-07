// Question : https://codeforces.com/contest/2275/problem/C

import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        // System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            long[] a = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            System.out.println(solve(n, a));
        }

        sc.close();
    }

    public static long solve(int n, long[] a) {
        int m = n - 4;
        long val[] = new long[m];
        for(int i = 0; i < m; i++)
            val[i] = a[i] + a[i + 2] - a[i + 4];
        HashMap<Long, Long> freq = new HashMap<>();
        long ans = 0;
        for(int i = 0; i < m; i++){
            long same = freq.getOrDefault(val[i], 0L);
            long overlapping = 0;
            if(i - 2 >= 0 && val[i - 2] == val[i])
                overlapping++;
            if(i - 4 >= 0 && val[i - 4] == val[i])
                overlapping++;
            ans += same - overlapping;
            freq.put(val[i], same + 1);
        }
        return ans;
    }
}