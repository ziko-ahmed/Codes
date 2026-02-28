// Question : https://atcoder.jp/contests/abc447/tasks/abc447_e

import java.util.*;
import java.io.*;

public class E {

    static class DSU {
        int parent[];

        public DSU(int n){
            parent = new int[n + 1];
            for(int i = 1; i <= n; i++)
                parent[i] = i;
        }

        public int find(int i){
            if(parent[i] == i)
                return i;
            return parent[i] = find(parent[i]);
        }

        public void union(int i, int j){
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // Scanner sc = new Scanner(new File("input.txt"));
        // PrintWriter out = new PrintWriter(new File("output.txt"));
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) {
            // out.close();
            return;
        }

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] u = new int[m + 1];
        int[] v = new int[m + 1];

        for(int i = 1; i <= m; i++){
            u[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        DSU dsu = new DSU(n);
        int components = n;

        for(int i = m; i >= 1; i--){
            if(dsu.find(u[i]) != dsu.find(v[i])){
                if(components > 2){
                    dsu.union(u[i], v[i]);
                    components--;
                }
            }
        }

        long MOD = 998244353;
        long ans = 0;
        long powerOf2 = 2;

        for(int i = 1; i <= m; i++){
            if(dsu.find(u[i]) != dsu.find(v[i]))
                ans = (ans + powerOf2) % MOD;
            powerOf2 = (powerOf2 * 2) % MOD;
        }

        // out.println(ans);
        System.err.println(ans);

        // out.close();
        // sc.close();
    }
}