package Aug7Training;

import java.util.*;
import java.io.*;
 
public class ConvexHull {
     
    public static int cp(int x1, int y1, int x2, int y2, int x3, int y3) {
        int v1x = x2-x1;
        int v1y = y2-y1;
        int v2x = x3-x1;
        int v2y = y3-y1;
        return v1x*v2y - v2x*v1y;
    }
     
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        int cases = 1;
        while(true) {
            int n = s.nextInt();
            if(n == 0) break;
            int[] x = new int[n];
            int[] y = new int[n];
            int startx = -9999, starty = -9999;
            int startidx = -1;
            for(int i=0; i<n; i++) {
                x[i] = s.nextInt();
                y[i] = s.nextInt();
                if(startx < x[i]) {
                    startx = x[i];
                    starty = y[i];
                    startidx = i;
                }
            }
            boolean[] visited = new boolean[n];
            int countx = startx, county = starty, count = 1;
            int idx = startidx;
            out.append(startx+" "+starty+"\n");
            while(true) {
                int i=0;
                while(visited[i])
                    i++;
                for(int j=i+1; j<n; j++) {
                    if(visited[j] || j == idx) continue;
                    int cross = cp(startx, starty, x[i], y[i], x[j], y[j]);
                    if(cross > 0) i = j;
                    else if(cross == 0 && y[i] < y[j]) i = j;
                }
                if(i == startidx) break;
                countx += x[i];
                county += y[i];
                out.append(x[i]+" "+y[i]+"\n");
                count++;
                startx = x[i];
                starty = y[i];
                idx = i;
                visited[i] = true;
            }
            System.out.printf("%.4f %.4f\n", (float)countx/count, (float)county/count);
            System.out.print(out);
        }
    }
}