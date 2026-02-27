// Question : https://codeforces.com/contest/2203/problem/A

import java.util.*;
import java.io.*;

public class TowerOfBoxes {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int d = sc.nextInt();

            int result = towerOfBoxes(n, m, d);
            System.out.println(result);
        }

        sc.close();
    }
    public static int towerOfBoxes(int n, int m, int d) {
        int maxOnTop = d / m; 
        int maxPerTower = maxOnTop + 1; 
        return (int) Math.ceil((double) n / maxPerTower);
    }
}