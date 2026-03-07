// Question : https://codeforces.com/contest/2200/problem/D

import java.util.*;
import java.io.*;

public class D {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        // System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int p[] = new int[n];
            for(int i = 0; i < n; i++)
                p[i] = sc.nextInt();

            int res[] = solve(n, x, y, p);
            
            for(int i = 0; i < n; i++)
                out.print(res[i] + " ");
            out.println();
        }
        
        out.flush(); 
    }

    public static int[] solve(int n, int x, int y, int p[]) {
        int bSize = y - x;
        int[] b = new int[bSize];
        int bMin = Integer.MAX_VALUE;
        int minIdx = -1;
        
        for(int i = 0; i < bSize; i++){
            b[i] = p[x + i];
            if(b[i] < bMin){
                bMin = b[i];
                minIdx = i;
            }
        }
        
        int[] bRotated = new int[bSize];
        for(int i = 0; i < bSize; i++) {
            bRotated[i] = b[(minIdx + i) % bSize];
        }
        
        int acSize = n - bSize;
        int[] ac = new int[acSize];
        int idx = 0;
        for (int i = 0; i < x; i++) ac[idx++] = p[i];     
        for (int i = y; i < n; i++) ac[idx++] = p[i];     
        
        int posi = acSize; 
        for (int i = 0; i < acSize; i++) {
            if (ac[i] > bRotated[0]) {
                posi = i; 
                break;
            }
        }
        
        int[] res = new int[n];
        idx = 0;
        for(int i = 0; i < posi; i++)
            res[idx++] = ac[i];      
        for(int i = 0; i < bSize; i++)
            res[idx++] = bRotated[i];    
        for(int i = posi; i < acSize; i++)
            res[idx++] = ac[i]; 
        
        return res;
    }

    // --- FAST I/O TEMPLATE ---
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}