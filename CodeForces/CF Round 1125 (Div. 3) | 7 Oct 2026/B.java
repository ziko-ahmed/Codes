// Question : https://codeforces.com/contest/2275/problem/B

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

            solve(n, s);
        }

        sc.close();
    }

    public static void solve(int n, String s) {
        Stack<Integer> st = new Stack<>();
        boolean printed[] = new boolean[n + 1];
        for(int i = 0; i < n; i++){
            int doc = i + 1;
            char ch = s.charAt(i);
            if(ch == '1')
                st.push(doc);
            else if(ch == '2'){
                if(!st.isEmpty())
                    printed[st.pop()] = true;
                else
                    printed[doc] = true;
            }
            else
                printed[doc] = true;
        }
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(!printed[i])
                count++;
        }
        System.out.println(count);
        for(int i = 1; i <= n; i++){
            if(!printed[i])
                System.out.print(i + " ");
        }
        System.out.println();
    }
}