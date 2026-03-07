// Question : https://atcoder.jp/contests/abc448/tasks/abc448_d

import java.util.*;
import java.io.*;

public class D {
    // ---------------------------------------------------------
    // FAST I/O CLASS
    // ---------------------------------------------------------
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

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

    static ArrayList<Integer>[] adj;
    static int[] compressedA;
    static int[] freq;
    static boolean[] hasDuplicate;
    static int duplicateCount = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        System.setOut(new PrintStream(new FileOutputStream("output.txt")));
        FastScanner sc = new FastScanner();

        String firstToken = sc.next();
        if (firstToken == null) return;
        int n = Integer.parseInt(firstToken);

        int A[] = new int[n + 1];
        int tempForSort[] = new int[n];
        for(int i = 1; i <= n; i++){
            A[i] = sc.nextInt();
            tempForSort[i - 1] = A[i];
        }

        Arrays.sort(tempForSort);
        int uniqueValues[] = new int[n];
        int uniqueLen = 0;
        for(int i = 0; i < n; i++){
            if(i == 0 || tempForSort[i] != tempForSort[i - 1])
                uniqueValues[uniqueLen++] = tempForSort[i];
        }

        compressedA = new int[n + 1];
        for(int i = 1; i <= n; i++)
            compressedA[i] = Arrays.binarySearch(uniqueValues, 0, uniqueLen, A[i]);

        adj = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++)
            adj[i] = new ArrayList<>();

        for(int i = 0; i < n - 1; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        freq = new int[uniqueLen];
        hasDuplicate = new boolean[n + 1];

        dfs(1, 0);

        StringBuilder out = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (hasDuplicate[i]) {
                out.append("Yes\n");
            } else {
                out.append("No\n");
            }
        }
        System.out.print(out);
    }

    public static void dfs(int node, int parent){
        int valId = compressedA[node];
        freq[valId]++;
        if(freq[valId] == 2)
            duplicateCount++;
        hasDuplicate[node] = (duplicateCount > 0);
        for(int neighbor : adj[node]){
            if(neighbor != parent)
                dfs(neighbor, node);
        }
        if(freq[valId] == 2)
            duplicateCount--;
        freq[valId]--;
    }
}