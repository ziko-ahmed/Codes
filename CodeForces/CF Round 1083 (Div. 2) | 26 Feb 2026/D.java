// Question : https://codeforces.com/contest/2205/problem/D

import java.util.*;
import java.io.*;

public class D {
    
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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

        int nextInt(){
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();

        String tStr = sc.next();
        if (tStr == null) return;
        int t = Integer.parseInt(tStr);
        while(t-- > 0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++)
                a[i] = sc.nextInt();

            int result = solve(n, a);
            System.out.println(result);
        }
    }

    public static int solve(int n, int[] a){
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        
        int[] stack = new int[n];
        int top = -1;
        for(int i = 0; i < n; i++){
            int lastPopped = -1;
            while(top >= 0 && a[stack[top]] < a[i]){
                lastPopped = stack[top];
                top--;
            }
            if(lastPopped != -1)
                left[i] = lastPopped;

            if(top >= 0)
                right[stack[top]] = i;
            top++;
            stack[top] = i;
        }
        int[] pos = new int[n + 1];
        for (int i = 0; i < n; i++)
            pos[a[i]] = i;

        int[] sz = new int[n];
        int[] dp = new int[n];
        for(int v = 1; v <= n; v++){
            int i = pos[v];
            int l = left[i];
            int r = right[i];
            
            int szL = (l == -1) ? 0 : sz[l];
            int szR = (r == -1) ? 0 : sz[r];
            int dpL = (l == -1) ? 0 : dp[l];
            int dpR = (r == -1) ? 0 : dp[r];
            
            sz[i] = 1 + szL + szR;
            dp[i] = Math.min(szL + dpR, szR + dpL);
        }
        return dp[pos[n]];
    }
}