// Question : https://atcoder.jp/contests/abc447/tasks/abc447_d

import java.util.*;
import java.io.*;

public class D {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        // System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        Scanner sc = new Scanner(System.in);

        // if (!sc.hasNextInt()) return;
        // int testCases = sc.nextInt();

        // while (testCases-- > 0) {
            String s = sc.next();

            int result = solve(s);
            System.out.println(result);
        // }

        sc.close();
    }

    public static int solve(String s){
        int availA = 0;
        int availB = 0;
        int res = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'A')
                availA++;
            else if(ch == 'B'){
                if(availA > 0){
                    availA--;
                    availB++;
                }
            }
            else if(ch == 'C'){
                if(availB > 0){
                    availB--;
                    res++;
                }
            }
        }
        return res;
    }
}