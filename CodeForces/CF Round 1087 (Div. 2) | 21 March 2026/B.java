// Question : https://codeforces.com/contest/2209/problem/B#

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
            int arr[] = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            List<Integer> res = solve(n, arr);
            for(int num : res)
                System.out.print(num + " ");
            System.out.println();
        }

        sc.close();
    }

    public static List<Integer> solve(int n, int arr[]) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int greater = 0;
            int smaller = 0;
            for(int j = i + 1; j < n; j++){
                if(arr[j] > arr[i])
                    greater++;
                else if(arr[j] < arr[i])
                    smaller++;
            }
            res.add(Math.max(greater, smaller));
        }
        return res;
    }
}