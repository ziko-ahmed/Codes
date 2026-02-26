import java.util.*;
import java.io.*;

public class A {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        // System.setOut(new PrintStream(new FileOutputStream("output.txt")));
        Scanner sc = new Scanner(System.in);

        // 2. Read the number of test cases
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] p = new int[n];
            
            for (int i = 0; i < n; i++) {
                p[i] = sc.nextInt();
            }

            int[] result = solve(n, p);
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(result[i]).append(i == n - 1 ? "" : " ");
            }
            System.out.println(sb.toString());
        }

        sc.close();
    }
    public static int[] solve(int n, int[] p) {
        // 1. Find the index of the maximum element (which is always 'n' in a permutation)
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] == n) {
                maxIdx = i;
                break;
            }
        }
        
        // 2. If 'n' is not already at the first position, swap it
        if (maxIdx != 0) {
            int temp = p[0];
            p[0] = p[maxIdx];
            p[maxIdx] = temp;
        }
        
        return p;
    }
}