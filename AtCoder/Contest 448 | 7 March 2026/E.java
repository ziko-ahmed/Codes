// Question : https://atcoder.jp/contests/abc448/tasks/abc448_e
// TLE

import java.util.*;
import java.io.*;

public class E {

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int K = sc.nextInt();
        int M = sc.nextInt();

        long mod = (long) M * 10007;
        long rem = 0;

        for(int i = 0; i < K; i++){
            int c = sc.nextInt();
            long l = sc.nextLong();

            for(long j = 0; j < l; j++)
                rem = (rem * 10 + c) % mod;
        }

        long ans = (rem / M) % 10007;
        out.println(ans);
        out.flush();
    }

    // ---------------------------------------------------------
    // FAST SCANNER
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
    }
}