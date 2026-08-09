// Question : https://codeforces.com/contest/2256/problem/D

import java.util.*;
import java.io.*;

public class D {
    static final int MOD = 998244353;
    static final int MAXN = 1_000_001;
    static long[] fact = new long[MAXN];
    static long[] invFact = new long[MAXN];

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        // System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        precompute();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);
        st.nextToken();
        int t = (int) st.nval;

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            st.nextToken();
            int n = (int) st.nval;
            String s = readWord(br);
            sb.append(solve(n, s)).append('\n');
        }
        System.out.print(sb);
    }

    public static String readWord(BufferedReader br) throws IOException{
        int c;
        StringBuilder w = new StringBuilder();
        do{
            c = br.read();
        }
        while(c == ' ' || c == '\n' || c == '\r');

        while(c != -1 && c != ' ' && c != '\n' && c != '\r'){
            w.append((char) c);
            c = br.read();
        }
        return w.toString();
    }

    public static void precompute(){
        fact[0] = 1;
        for(int i = 1; i < MAXN; i++)
            fact[i] = fact[i - 1] * i % MOD;

        invFact[MAXN - 1] = modPow(fact[MAXN - 1], MOD - 2, MOD);

        for(int i = MAXN - 2; i >= 0; i--)
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
    }

    public static long modPow(long base, long exp, long mod){
        long result = 1;
        base %= mod;
        while(exp > 0){
            if ((exp & 1) == 1) result = result * base % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }

    public static long solve(int n, String s){
        List<Integer> blocks = new ArrayList<>();
        int i = 0;
        while(i < n){
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i))
                j++;
            blocks.add(j - i);
            i = j;
        }

        List<Integer> oddBlocks = new ArrayList<>();
        List<Integer> evenBlocks = new ArrayList<>();

        for(int idx = 0; idx < blocks.size(); idx++){
            if (idx % 2 == 0) oddBlocks.add(blocks.get(idx));
            else evenBlocks.add(blocks.get(idx));
        }
        long ans = permCount(oddBlocks) * permCount(evenBlocks) % MOD;
        return ans;
    }

    public static long permCount(List<Integer> list){
        if(list.isEmpty())
            return 1;
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        for(int v : list) 
            freq.merge(v, 1, Integer::sum);

        long result = fact[list.size()];

        for(int cnt : freq.values())
            result = result * invFact[cnt] % MOD;
        return result;
    }
}