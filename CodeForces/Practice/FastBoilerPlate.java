import java.util.*;
import java.io.*;

public class FastBoilerPlate {
    public static void main(String[] args) throws IOException {
        // ---------------------------------------------------------
        // LOCAL TESTING BLOCK: 
        // Comment out these two lines before submitting to Codeforces
        // System.setIn(new FileInputStream("input.txt"));
        // System.setOut(new PrintStream(new FileOutputStream("output.txt")));
        // ---------------------------------------------------------

        // 1. Initialize Fast I/O instead of Scanner
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        // 2. Read the number of test cases
        // (FastScanner handles EOF cleanly, so we just read t directly)
        String tStr = sc.next();
        if (tStr == null) return; 
        int t = Integer.parseInt(tStr);

        // 3. Loop through each test case
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int d = sc.nextInt();

            // 4. Call your logic function
            int result = solve(n, m, d);
            
            // 5. Print the result using PrintWriter
            out.println(result);
        }

        // 6. CRUCIAL: Always flush the PrintWriter at the very end!
        out.flush();
    }

    // ---------------------------------------------------------
    // LEETCODE-STYLE LOGIC METHOD:
    // This is where you focus purely on solving the problem
    // ---------------------------------------------------------
    public static int solve(int n, int m, int d) {
        return 0;
    }

    // ---------------------------------------------------------
    // FAST I/O TEMPLATE:
    // Leave this at the bottom of your file
    // ---------------------------------------------------------
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null; // Handle End of File
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st != null && st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}