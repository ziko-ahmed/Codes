// Question : https://codeforces.com/contest/2209/problem/C

import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            solve(n, sc);
        }

        sc.close();
    }

    public static void solve(int n, Scanner sc) {
        int tri[][] = {{1, 2}, {2, 3}, {1, 3}};
        for(int i = 0; i < 3; i++){
            System.out.println("? " + tri[i][0] + " " + tri[i][1]);
            System.out.flush();
            int ans = sc.nextInt();
            if(ans == 1){
                System.out.println("! " + tri[i][0]);
                System.out.flush();
                return;
            }
            if(ans == -1)
                System.exit(0);
        }
        for(int i = 4; i < 2 * n; i += 2){
            System.out.println("? " + i + " " + (i + 1));
            System.out.flush();
            int ans = sc.nextInt();
            if(ans == 1){
                System.out.println("! " + i);
                System.out.flush();
                return;
            }
            if(ans == -1)
                System.exit(0);
        }
        System.out.println("! " + (2 * n));
        System.out.flush();
    }
}