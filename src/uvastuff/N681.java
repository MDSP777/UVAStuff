package uvastuff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class N681 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        System.out.println(nC);
        for(int a=0; a<nC; a++){
//        while(true){
            ArrayList<Point> points = new ArrayList<>();
            ArrayList<Point> oPoints = new ArrayList<>();
            int n = sc.nextInt();
//            if(n==0) break;
            int[] x = new int[n];
            int[] y = new int[n];
            int startx = -9999, starty = -9999;
            int startidx = -1;
            int lowestx = Integer.MAX_VALUE;
            int lowesty = Integer.MAX_VALUE;
            int lowestIndex = -1;
            
            for(int i=0; i<n; i++) {
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
                if(startx < x[i]) {
                    startx = x[i];
                    starty = y[i];
                    startidx = i;
                }
                if(y[i]==lowesty){
                    if(x[i]<lowestx){
                        lowestx = x[i];
                        lowesty = y[i];
                        lowestIndex = i;
                    }
                } else if(y[i]<lowesty){
                    lowestx = x[i];
                    lowesty = y[i];
                    lowestIndex = i;
                }
                if(i!=n-1)
                oPoints.add(new Point(x[i], y[i]));
            }
            Collections.rotate(oPoints, oPoints.size()-lowestIndex);
            points.add(new Point(startx, starty));
            if(a!=nC-1) sc.nextInt();
            boolean[] visited = new boolean[n];
            int countx = startx, county = starty, count = 1;
            int idx = startidx;
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
                points.add(new Point(x[i], y[i]));
                startx = x[i];
                starty = y[i];
                idx = i;
                visited[i] = true;
            }
            
            System.out.println(points.size()+1);
            for(Point p: oPoints){
                if(isPartOfCH(p, points))
                    System.out.println(p);
            }
            System.out.println(lowestx+" "+lowesty);
            if(a!=nC-1) System.out.println("-1");
        }

    }
    
    public static int cp(int x1, int y1, int x2, int y2, int x3, int y3) {
        int v1x = x2-x1;
        int v1y = y2-y1;
        int v2x = x3-x1;
        int v2y = y3-y1;
        return v1x*v2y - v2x*v1y;
    }

    private static boolean isPartOfCH(Point point, ArrayList<Point> points) {
        for(Point p: points){
            if(point.x==p.x&&point.y==p.y) return true;
        }
        return false;
    }
    
    static class Point{
        int x;
        int y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public String toString(){
            return x+" "+y;
        }
        
    }
}
