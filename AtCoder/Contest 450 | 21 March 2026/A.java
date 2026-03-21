// Question : https://atcoder.jp/contests/abc450/tasks/abc450_a

import java.util.*;
import java.io.*;

public class A {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        // System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        String result = solve(n);
        System.out.println(result);


        // Always close your sc!
        sc.close();
    }

    // ---------------------------------------------------------
    // LEETCODE-STYLE LOGIC METHOD:
    // This is where you focus purely on solving the problem
    // ---------------------------------------------------------
    public static String solve(int n) {
        StringBuilder res = new StringBuilder();
        while(n > 0){
            res.append(n + ",");
            n--;
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}