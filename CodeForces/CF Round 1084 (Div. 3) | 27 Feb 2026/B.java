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
            int a[] = new int[n];
            for(int i = 0; i < n; i++)
                a[i] = sc.nextInt();

            int result = solve(n, a);
            System.out.println(result);
        }
        sc.close();
    }

    public static int solve(int n, int a[]) {
        return isSorted(a) ? n : 1;
    }

    private static boolean isSorted(int a[]){
        int n = a.length;
        for(int i = 0; i < n - 1; i++){
            if(a[i] > a[i + 1])
                return false;
        }
        return true;
    }
}