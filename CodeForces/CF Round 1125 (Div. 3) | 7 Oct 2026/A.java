// Question : https://codeforces.com/contest/2275/problem/A

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
            int x0 = sc.nextInt();
            int y0 = sc.nextInt();
            int r = sc.nextInt();

            int x = x0 + r;
            int y = y0;
            System.out.println(x + " " + y);
        }

        sc.close();
    }

}