// Question : 

import java.util.*;
import java.io.*;

public class ScannerBoilerPlate {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int d = sc.nextInt();

            int result = solve(n, m, d);
            System.out.println(result);
        }

        sc.close();
    }

    public static int solve(int n, int m, int d) {
        return 0;
    }
}