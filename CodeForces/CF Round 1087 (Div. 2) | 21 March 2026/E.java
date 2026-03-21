// Question : https://codeforces.com/contest/2209/problem/E

import java.util.*;
import java.io.*;

public class E {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        // System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        String tStr = sc.next();
        if (tStr == null) return; 
        int t = Integer.parseInt(tStr);

        int MAXN = 1000005;
        int[] z = new int[MAXN];
        int[] max_reach = new int[MAXN];

        while(t-- > 0){
            int n = sc.nextInt();
            int q = sc.nextInt();
            String s = sc.next();
            char arr[] = s.toCharArray();

            solve(n, q, arr, sc, out, z, max_reach);
        }
        out.flush();
    }

    public static void solve(int n, int q, char[] arr, FastScanner sc, PrintWriter out, int[] z, int[] max_reach){
        while(q-- > 0){
            int start = sc.nextInt() - 1;
            int end = sc.nextInt() - 1;
            int m = end - start + 1;

            z[0] = 0;
            int l = 0, r = 0;
            for(int i = 1; i < m; i++){
                if(i <= r)
                    z[i] = Math.min(r - i + 1, z[i - l]);
                else
                    z[i] = 0;

                while(i + z[i] < m && arr[start + z[i]] == arr[start + i + z[i]])
                    z[i]++;

                if(i + z[i] - 1 > r){
                    l = i;
                    r = i + z[i] - 1;
                }
            }

            max_reach[0] = 1_000_000_000;
            for(int i = 1; i <= m; i++)
                max_reach[i] = -1;

            long sum = 0;
            int dp_prev = 0;

            for(int i = 1; i <= m; i++){
                int v = dp_prev + 1;
                
                while(max_reach[v - 1] < i)
                    v--;
                
                int dp_i = v;
                sum += dp_i;

                if(i < m){
                    if(i + z[i] > max_reach[dp_i])
                        max_reach[dp_i] = i + z[i];
                }
                dp_prev = dp_i;
            }
            out.println(sum);
        }
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