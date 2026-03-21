// Question : https://codeforces.com/contest/2209/problem/D

import java.util.*;
import java.io.*;

public class D {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        // System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        String tStr = sc.next();
        if (tStr == null) return; 
        int t = Integer.parseInt(tStr);

        while (t-- > 0) {
            int r = sc.nextInt();
            int g = sc.nextInt();
            int b = sc.nextInt();

            String result = solve(r, g, b);
            
            out.println(result);
        }

        out.flush();
    }

    public static String solve(int r, int g, int b) {
        int[] counts = {r, g, b};
        int sum = r + g + b;
        if (sum == 0) return "";

        // Identify the most frequent color
        int maxIdx = 0;
        if (counts[1] > counts[maxIdx]) maxIdx = 1;
        if (counts[2] > counts[maxIdx]) maxIdx = 2;

        int otherSum = 0;
        for (int i = 0; i < 3; ++i) {
            if (i != maxIdx) otherSum += counts[i];
        }

        // Cap the max count (Bipartite separation limit)
        if (counts[maxIdx] > otherSum + 1) {
            counts[maxIdx] = otherSum + 1;
        }

        int totalLen = counts[0] + counts[1] + counts[2];
        char[] res = new char[totalLen];
        int[] s = new int[totalLen];
        char[] chars = {'R', 'G', 'B'};

        // Greedily build the optimal sequence
        for (int i = 0; i < totalLen; ++i) {
            int best_c = -1;
            
            for (int c = 0; c < 3; ++c) {
                // Check if color is locally valid
                if (i >= 1 && c == s[i - 1]) continue;
                if (i >= 3 && c == s[i - 3]) continue;
                if (counts[c] == 0) continue;

                if (best_c == -1) {
                    best_c = c;
                } else {
                    // Always favor color with highest leftover pool
                    if (counts[c] > counts[best_c]) {
                        best_c = c;
                    } 
                    // Tie-breaker: prefer creating an alternating local parity pattern 
                    else if (counts[c] == counts[best_c]) {
                        if (i >= 2 && c == s[i - 2]) {
                            best_c = c;
                        }
                    }
                }
            }

            if (best_c == -1) {
                return new String(res, 0, i);
            }

            s[i] = best_c;
            res[i] = chars[best_c];
            counts[best_c]--;
        }

        return new String(res);
    }

    // FAST I/O TEMPLATE
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
                    if (line == null) return null;
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