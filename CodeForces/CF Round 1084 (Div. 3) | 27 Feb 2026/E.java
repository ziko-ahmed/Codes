// Question : https://codeforces.com/contest/2200/problem/E

import java.util.*;
import java.io.*;

public class E {
    static int[] minPrime = new int[1000005];

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        // System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        for (int i = 2; i <= 1000000; i++) minPrime[i] = i;
        for (int i = 2; i * i <= 1000000; i++) {
            if (minPrime[i] == i) {
                for (int j = i * i; j <= 1000000; j += i) {
                    if (minPrime[j] == j) minPrime[j] = i;
                }
            }
        }

        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        String tStr = sc.next();
        if (tStr == null) return; 
        int t = Integer.parseInt(tStr);

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];

            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            String result = solve(n, arr);
            
            out.println(result);
        }

        out.flush();
    }

    public static String solve(int n, int arr[]){
        if(isSorted(arr))
            return "Bob";
        
        int basePrimes[] = new int[n];
        
        for(int i = 0; i < n; i++){
            basePrimes[i] = getBasePrime(arr[i]);
            if(basePrimes[i] == -1)
                return "Alice";
        }
        if(isSorted(basePrimes))
            return "Bob";   
        return "Alice";
    }

    private static int getBasePrime(int x){
        if(x == 1)
            return 1;
        
        int p = minPrime[x];
        while(x % p == 0)
            x /= p;
        
        if(x > 1)
            return -1;
        
        return p;
    }

    private static boolean isSorted(int arr[]){
        int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            if(arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }

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