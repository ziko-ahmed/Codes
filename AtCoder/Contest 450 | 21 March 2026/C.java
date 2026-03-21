// Question : https://atcoder.jp/contests/abc450/tasks/abc450_c

import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;

        int h = sc.nextInt();
        int w = sc.nextInt();
        char arr[][] = new char[h][w];
        for(int i = 0; i < h; i++){
            String s = sc.next();
            for(int j = 0 ; j < w; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        int result = solve(h, w, arr);
        System.out.println(result);

        // Always close your sc!
        sc.close();
    }

    public static int solve(int h, int w, char arr[][]) {
        int count = 0;
        boolean vis[][] = new boolean[h][w];
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(arr[i][j] == '.' && !vis[i][j]){
                    boolean onBorder = false;
                    Stack<int[]> st = new Stack<>();
                    st.push(new int[]{i, j});
                    vis[i][j] = true;
                    while(!st.isEmpty()){
                        int curr[] = st.pop();
                        int r = curr[0], c = curr[1];
                        if(r == 0 || r == h - 1 || c == 0 || c == w - 1)
                                onBorder = true;
                        int dr[] = {1, 0, 0, -1};
                        int dc[] = {0, 1, -1, 0};
                        for(int k = 0; k < 4; k++){
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            if(nr >= 0 && nr < h && nc >= 0 && nc < w && arr[nr][nc] == '.' && !vis[nr][nc]){
                                st.push(new int[]{nr, nc});
                                vis[nr][nc] = true;
                            }
                        }
                    }
                    if(!onBorder)
                        count++;
                }
            }
        }
        return count;
    }
}