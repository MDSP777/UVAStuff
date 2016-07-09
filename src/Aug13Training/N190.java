package Aug13Training;

import java.util.Scanner;

public class N190 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            Point p = new Point(sc.nextDouble(), sc.nextDouble());
            Point q = new Point(sc.nextDouble(), sc.nextDouble());
            Point r = new Point(sc.nextDouble(), sc.nextDouble());
            
            solve(p, q, r);
        }while(sc.hasNext());

    }
    
    static void solve(Point p, Point q, Point r){
        double m1x = (p.x+q.x)/2;
        double m1y = (p.y+q.y)/2;
        double m2x = (q.x+r.x)/2;
        double m2y = (q.y+r.y)/2;
        
        double s1 = -1 / ((p.y-q.y)/(p.x-q.x));
        double s2 = -1 / ((q.y-r.y)/(q.x-r.x));
        
        double b1 = m1y - s1*m1x;
        double b2 = m2y - s2*m2x;
        
        double x = (b2-b1)/(s1-s2);
        double y = s1*x + b1;
        
//        System.out.println(x);
//        System.out.println(y);
        
        double dist = Math.hypot(x-p.x, y-p.y);
//        System.out.println(dist);
        
        System.out.print("(x");
        if(x>=0){
            System.out.print(" - ");
        } else {
            System.out.print(" + ");
        }
        System.out.printf("%.3f)^2 + (y", Math.abs(x));
        if(y>=0){
            System.out.print(" - ");
        } else {
            System.out.print(" + ");
        }
        System.out.printf("%.3f)^2 = %.3f^2\n", Math.abs(y), dist);
        
        System.out.print("x^2 + y^2");
        double x2 = x*2;
        if(x2>=0){
            System.out.print(" - ");
        } else {
            System.out.print(" + ");
        }
        System.out.printf("%.3fx", Math.abs(x2));
        double y2 = y*2;
        if(y2>=0){
            System.out.print(" - ");
        } else {
            System.out.print(" + ");
        }
        System.out.printf("%.3fy", Math.abs(y2));
        
        double dist2 = x*x + y*y - dist*dist;
        if(dist2<0){
            System.out.print(" - ");
        } else {
            System.out.print(" + ");
        }
        System.out.printf("%.3f = 0\n\n", Math.abs(dist2));
    }
    
    static class Point{
        double x;
        double y;
        
        public Point(double x, double y){
            this.x = x;
            this.y = y;
        }
    }
}
