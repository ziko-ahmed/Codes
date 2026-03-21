// Question : https://atcoder.jp/contests/abc450/tasks/abc450_b

import java.util.*;
import java.io.*;

public class B {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        Scanner sc = new Scanner(System.in);

        // 2. Read the number of test cases
        if (!sc.hasNextInt()) return;

        // 3. Loop through each test case
        int n = sc.nextInt();
        int arr[][] = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        // 4. Call your logic function and print the result
        String result = solve(n, arr);
        System.out.println(result);

        // Always close your sc!
        sc.close();
    }

    public static String solve(int n, int arr[][]) {
        for(int a = 0; a < n; a++){
            for(int b = a + 1; b < n; b++){
                for(int c= b + 1; c < n; c++){
                    if(arr[a][b] + arr[b][c] < arr[a][c])
                        return "Yes";
                }
            }
        }
        return "No";
    }
}