import java.util.*;
import java.io.*;

public class ScannerBoilerPlate {
    public static void main(String[] args) throws IOException {
        // ---------------------------------------------------------
        // LOCAL TESTING BLOCK: 
        // Comment out these two lines before submitting to Codeforces
        System.setIn(new FileInputStream("input.txt"));
        System.setOut(new PrintStream(new FileOutputStream("output.txt")));
        // ---------------------------------------------------------

        Scanner sc = new Scanner(System.in);

        // 2. Read the number of test cases
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        // 3. Loop through each test case
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int d = sc.nextInt();

            // 4. Call your logic function and print the result
            int result = solve(n, m, d);
            System.out.println(result);
        }

        // Always close your sc!
        sc.close();
    }

    // ---------------------------------------------------------
    // LEETCODE-STYLE LOGIC METHOD:
    // This is where you focus purely on solving the problem
    // ---------------------------------------------------------
    public static int solve(int n, int m, int d) {
        return 0;
    }
}