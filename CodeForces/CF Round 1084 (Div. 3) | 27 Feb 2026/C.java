import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        // System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            String result = solve(n, s);
            System.out.println(result);
        }
        sc.close();
    }

    public static String solve(int n, String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(!st.isEmpty() && st.peek() == ch)
                st.pop();
            else
                st.push(ch);
        }
        return st.isEmpty() ? "YES" : "NO";
    }
}