import java.util.*;
import java.io.*;

public class C {
    static int[] used = new int[1000005];
    static int[] lastSeen = new int[1000005];
    static int currentTestCase = 0;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        // System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while (t-- > 0) {
            currentTestCase++;
            int n = sc.nextInt();
            
            int[][] S = new int[n][];
            for (int i = 0; i < n; i++) {
                int l = sc.nextInt();
                int[] temp = new int[l];
                for (int j = 0; j < l; j++) {
                    temp[j] = sc.nextInt();
                }
                
                int[] unique = new int[l];
                int k = 0;
                int blogId = currentTestCase * 3005 + i; 
                
                for (int j = l - 1; j >= 0; j--) {
                    int val = temp[j];
                    if (lastSeen[val] != blogId) {
                        lastSeen[val] = blogId;
                        unique[k++] = val;
                    }
                }
                S[i] = Arrays.copyOf(unique, k);
            }

            solve(n, S);
        }

        sc.close();
    }

    public static void solve(int n, int[][] S) {
        boolean[] picked = new boolean[n];
        List<Integer> Q = new ArrayList<>();
        for(int step = 0; step < n; step++){
            int best_idx = -1;
            for(int i = 0; i < n; i++){
                if (picked[i]) continue;
                
                if (best_idx == -1)
                    best_idx = i;
                else{
                    if(compareFiltered(S[i], S[best_idx]) < 0)
                        best_idx = i;
                }
            }
            picked[best_idx] = true;
            for(int val : S[best_idx]){
                if(used[val] != currentTestCase){
                    used[val] = currentTestCase;
                    Q.add(val);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Q.size(); i++){
            sb.append(Q.get(i));
            if (i < Q.size() - 1) sb.append(" ");
        }
        System.out.println(sb.toString());
    }

    private static int compareFiltered(int[] arr1, int[] arr2){
        int p1 = 0, p2 = 0;
        int n1 = arr1.length, n2 = arr2.length;
        
        while(true){
            while(p1 < n1 && used[arr1[p1]] == currentTestCase)
                p1++;
            while(p2 < n2 && used[arr2[p2]] == currentTestCase)
                p2++;
            
            if(p1 == n1 && p2 == n2) 
                return 0;
            
            if(p1 == n1) 
                return -1;
            if(p2 == n2) 
                return 1;
        
            if(arr1[p1] != arr2[p2])
                return Integer.compare(arr1[p1], arr2[p2]);
            p1++;
            p2++;
        }
    }
}