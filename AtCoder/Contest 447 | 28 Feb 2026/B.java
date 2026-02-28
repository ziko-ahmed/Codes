// Question : https://atcoder.jp/contests/abc447/tasks/abc447_b

import java.util.*;
import java.io.*;

public class B {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        // System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        Scanner sc = new Scanner(System.in);

        // if (!sc.hasNextInt()) return;
        // int t = sc.nextInt();

        // while (t-- > 0) {
            String s = sc.next();

            String result = solve(s);
            System.out.println(result);
        // }

        sc.close();
    }

    public static String solve(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            max = Math.max(max, map.get(ch));
        }
        StringBuilder res = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(map.get(ch) != max)
                res.append(ch);
        }
        return res.toString();
    }
}