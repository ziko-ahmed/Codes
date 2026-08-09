// Question : https://codeforces.com/contest/2256/problem/C

import java.util.*;
import java.io.*;

public class C {
    static int redScore = 0, blueScore = 0;
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        // System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            String s = sc.next();

            solve(n, k, s);
            System.out.println(redScore+" "+blueScore);
        }

        sc.close();
    }

    public static void solve(int n, long k, String s) {
        int len = 2 * n;
        int red = 0, blue = 0;

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                boolean isRed = (i % 2 == 0);
                int next = (i + 1) % len;
                boolean isFront = (s.charAt(next) == '0');

                if(isFront){
                    if(isRed)
                        red++;
                    else
                        blue++;
                }
                else{
                    if(isRed) 
                        blue++; 
                    else
                        red++;
                }
            }
        }
        redScore = red;
        blueScore = blue;
    }
}