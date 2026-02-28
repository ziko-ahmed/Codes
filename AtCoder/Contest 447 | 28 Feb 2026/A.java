// Question : https://atcoder.jp/contests/abc447/tasks/abc447_a

import java.util.*;
import java.io.*;

public class A {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        // System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        Scanner sc = new Scanner(System.in);

        // if (!sc.hasNextInt()) return;
        // int t = sc.nextInt();

        // while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            String result = solve(n, m);
            System.out.println(result);
        // }

        sc.close();
    }

    public static String solve(int n, int m) {
        return ((n + 1) / 2) >= m ? "Yes" : "No";
    }
}