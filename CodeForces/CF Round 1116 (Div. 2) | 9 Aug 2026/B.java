// Question : https://codeforces.com/contest/2256/problem/B

import java.util.*;
import java.io.*;

public class B {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        // System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
        String s = sc.next();
            long result = solve(n, s);
            System.out.println(result);
        }

        sc.close();
    }

    public static long solve(int n, String s) {
        StringBuilder evens = new StringBuilder();
        StringBuilder odds = new StringBuilder();

        for(int i = 0; i < n; i++){
            if(i % 2 == 0)
                evens.append(s.charAt(i));
            else
                odds.append(s.charAt(i));
        }
        long ans = countValid(evens.toString()) * countValid(odds.toString());
        return ans;
    }

    public static long countValid(String str) {
        boolean pat1 = true; // represents 0, 1, 0, 1...
        boolean pat2 = true; // reepresents 1, 0, 1, 0...
        
        long ans = 0;
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if (ch == '?') continue;

            int val = ch - '0';
            int expPat1 = i % 2; 
            int expPat2 = 1 - expPat1; 
            
            if(val != expPat1) 
                pat1 = false;
            if(val != expPat2)
                pat2 = false;
        }
        if(pat1) 
            ans++;
        if(pat2) 
            ans++;
        return ans;
    }
}