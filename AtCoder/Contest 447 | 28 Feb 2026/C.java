// Question : https://atcoder.jp/contests/abc447/tasks/abc447_c

import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        // System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        Scanner sc = new Scanner(System.in);

        // if (!sc.hasNextInt()) return;
        // int testCases = sc.nextInt();

        // while (testCases-- > 0) {
            String s = sc.next();
            String t = sc.next();

            int result = solve(s, t);
            System.out.println(result);
        // }

        sc.close();
    }

    public static int solve(String s, String t){
        List<Integer> aCountsS = new ArrayList<>();
        StringBuilder skeletonS = new StringBuilder();
        int count = 0;
        
        for(char ch : s.toCharArray()){
            if(ch == 'A')
                count++;
            else{
                aCountsS.add(count);
                skeletonS.append(ch);
                count = 0;
            }
        }
        aCountsS.add(count);

        List<Integer> aCountsT = new ArrayList<>();
        StringBuilder skeletonT = new StringBuilder();
        count = 0;
        
        for(char ch : t.toCharArray()){
            if (ch == 'A')
                count++;
            else{
                aCountsT.add(count);
                skeletonT.append(ch);
                count = 0;
            }
        }
        aCountsT.add(count);

        if (!skeletonS.toString().equals(skeletonT.toString()))
            return -1;

        int operations = 0;
        for(int i = 0; i < aCountsS.size(); i++)
            operations += Math.abs(aCountsS.get(i) - aCountsT.get(i));

        return operations;
    }
}