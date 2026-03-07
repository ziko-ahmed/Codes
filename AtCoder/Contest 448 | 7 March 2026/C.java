// Quesition : https://atcoder.jp/contests/abc448/tasks/abc448_c

import java.util.*;
import java.io.*;

public class C {

    static class Pair {
        int val, idx;
        Pair(int v, int i){
            val = v;
            idx = i;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        System.setOut(new PrintStream(new FileOutputStream("output.txt")));
        
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] A = new int[n+1];

        for(int i=1;i<=n;i++)
            A[i] = sc.nextInt();

        Pair arr[] = new Pair[n];
        for(int i=1;i<=n;i++)
            arr[i-1] = new Pair(A[i], i);

        Arrays.sort(arr, (a,b)->Integer.compare(a.val,b.val));

        int LIMIT = Math.min(6, n);
        Pair smallest[] = new Pair[LIMIT];

        for(int i=0;i<LIMIT;i++)
            smallest[i] = arr[i];

        while(q-- > 0){
            int k = sc.nextInt();
            HashSet<Integer> removed = new HashSet<>();

            for(int i=0;i<k;i++)
                removed.add(sc.nextInt());

            for(int i=0;i<LIMIT;i++){
                if(!removed.contains(smallest[i].idx)){
                    out.println(smallest[i].val);
                    break;
                }
            }
        }
        out.flush();
    }

    // ---------------------------------------------------------
    // FAST I/O TEMPLATE
    // ---------------------------------------------------------
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}