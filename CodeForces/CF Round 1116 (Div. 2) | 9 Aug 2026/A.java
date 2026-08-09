// Question : https://codeforces.com/contest/2256/problem/A

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
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            int result = solve(x, y, z);
            System.out.println(result);
        }

        sc.close();
    }

    public static int solve(int x, int y, int z) {
        int res = 0;
        int maxiOrigi = Math.max(x, Math.max(y, z));
        int miniOrigi = Math.min(x, Math.min(y, z));
        int rangeOrigi = maxiOrigi - miniOrigi;
        
        int replaceX = Math.max(y, z); // x -> y + z
        int replaceY = Math.max(x, z); // y -> x + z
        int replaceZ = Math.max(x, y); // z -> x + y

        res = Math.min(
            rangeOrigi,
            Math.min(replaceX, Math.min(replaceY, replaceZ))
        );
        return res;
    }
}