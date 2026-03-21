// Question : 

import java.util.*;
import java.io.*;

public class FastBoilerPlate {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        String tStr = sc.next();
        if (tStr == null) return; 
        int t = Integer.parseInt(tStr);

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int d = sc.nextInt();

            int result = solve(n, m, d);
            
            out.println(result);
        }

        out.flush();
    }

    public static int solve(int n, int m, int d) {
        return 0;
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