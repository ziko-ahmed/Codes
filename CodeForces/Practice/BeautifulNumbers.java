// Question : https://codeforces.com/contest/2203/problem/B

import java.util.*;
import java.io.*;

public class BeautifulNumbers {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        // System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();

            int result = beautifulNumbers(n);
            System.out.println(result);
        }

        sc.close();
    }

    public static int beautifulNumbers(long n) {
        String s = String.valueOf(n);
        int len = s.length();
        int sum = 0;
        for(int i = 0; i < len; i++)
            sum += s.charAt(i) - '0';
        if(sum <= 9)
            return 0;
        int need = sum - 9;
        List<Integer> reductions = new ArrayList<>();

        for(int i = 0; i < len; i++){
            int digit = s.charAt(i) - '0';
            if(i == 0)
                reductions.add(digit - 1);
            else
                reductions.add(digit);
        }
        Collections.sort(reductions, Collections.reverseOrder());
        int res = 0;

        for(int r : reductions){
            need -= r;
            res++;
            if (need <= 0)
                break;
        }
        return res;
    }
}