// Question : https://atcoder.jp/contests/abc450/tasks/abc450_e
// Gave TLE after 14/15

import java.util.*;
import java.io.*;

public class E {

    static final long LIMIT = (long) 1e18;
    static long[] len = new long[100];
    static long[][] cnt = new long[100][26];

    static String X, Y;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        Scanner sc = new Scanner(System.in);

        X = sc.next();
        Y = sc.next();
        int Q = sc.nextInt();

        len[1] = X.length();
        len[2] = Y.length();

        for(char ch : X.toCharArray())
            cnt[1][ch - 'a']++;
        for(char ch : Y.toCharArray())
            cnt[2][ch - 'a']++;
        for(int i = 3; i < 100; i++){
            len[i] = Math.min(LIMIT, len[i - 1] + len[i - 2]);

            for(int c = 0; c < 26; c++)
                cnt[i][c] = Math.min(LIMIT, cnt[i - 1][c] + cnt[i - 2][c]);
        }

        while (Q-- > 0) {
            long L = sc.nextLong();
            long R = sc.nextLong();
            char c = sc.next().charAt(0);

            int n = 2;
            while (len[n] < R) n++;

            long ans = solve(n, L, R, c - 'a');
            System.out.println(ans);
        }
    }

    static long solve(int n, long L, long R, int c) {
        long res = 0;

        Deque<long[]> stack = new ArrayDeque<>();
        stack.push(new long[]{n, L, R});

        while(!stack.isEmpty()){
            long[] cur = stack.pop();
            n = (int) cur[0];
            L = cur[1];
            R = cur[2];

            if(L > R)
                continue;

            while(true){
                if(L > R)
                    break;

                if(n == 1){
                    res += countBase(X, L, R, (char)(c + 'a'));
                    break;
                }
                if(n == 2){
                    res += countBase(Y, L, R, (char)(c + 'a'));
                    break;
                }
                if(L == 1 && R == len[n]){
                    res += cnt[n][c];
                    break;
                }
                long leftLen = len[n - 1];

                if(R <= leftLen)
                    n = n - 1;
                else if(L > leftLen){
                    L -= leftLen;
                    R -= leftLen;
                    n = n - 2;
                }
                else{
                    stack.push(new long[]{n - 2, 1, R - leftLen});
                    n = n - 1;
                    R = leftLen;
                }
            }
        }

        return res;
    }

    static long countBase(String s, long L, long R, char c) {
        long ans = 0;
        for(long i = L; i <= R && i <= s.length(); i++){
            if (s.charAt((int)i - 1) == c)
                ans++;
        }
        return ans;
    }
}