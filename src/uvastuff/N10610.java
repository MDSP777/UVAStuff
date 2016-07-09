package uvastuff;

import java.util.ArrayList;
import java.util.Scanner;

public class N10610 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int v, t;
        v = sc.nextInt(); t = sc.nextInt();
        while(v!=0 || t!=0){
            Point curPos = new Point(sc.nextDouble(), sc.nextDouble()); 
            Point targetPos = new Point(sc.nextDouble(), sc.nextDouble());
            ArrayList<Point> points = new ArrayList();
            sc.nextLine();
            String nextPoint = sc.nextLine();
            points.add(curPos);
            boolean cond = true;
            if(nextPoint.length()<2) cond = false;
            while(cond){
                String[] split = nextPoint.split(" ");
                points.add(new Point(Double.parseDouble(split[0]), Double.parseDouble(split[1])));
                nextPoint = sc.nextLine();
                if(nextPoint.length()<2) cond = false;
            }
            points.add(targetPos);
            computeShortest(curPos, targetPos, points, v, t*60);
            v = sc.nextInt(); t = sc.nextInt();
        }
    }
    
    public static void computeShortest(Point curPos, Point targetPos, ArrayList<Point> points, int v, int t){
        int tHoles = 0;
        double maxD = v*t;
        Point bestPoint = curPos;
        while(!curPos.equals(targetPos)){
            double best = curPos.distance(targetPos);
            for(int i=0; i<points.size(); i++){
                Point candidate = points.get(i);
                if(candidate.distance(targetPos)<=best && curPos.distance(candidate)<=maxD){
                    bestPoint = candidate;
                    best = candidate.distance(targetPos);
                }
            }
            if(bestPoint.equals(curPos)){
                System.out.println("No.");
                return;
            }
            
            if(!bestPoint.equals(targetPos)) tHoles++;  
            curPos = bestPoint;
        }
        if(tHoles==1)System.out.println("Yes, visiting "+tHoles+" other hole.");
        else
        System.out.println("Yes, visiting "+tHoles+" other holes.");
    }
    
    public static class Point{
        public double x, y;
        
        public Point(double x, double y){
            this.x = x;
            this.y = y;
        }
        public boolean equals(Point target){
            if(this.x==target.x && this.y==target.y) return true;

            return false;
        }
        
        public double distance(Point target){
            return Math.hypot(this.x-target.x, this.y-target.y);
        }
    }
}