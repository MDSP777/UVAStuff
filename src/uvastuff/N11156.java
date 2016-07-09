package uvastuff;

import java.util.Scanner;

public class N11156 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int x=1; x<=nC; x++){
            double totalD = 0;
            int nLines = sc.nextInt();
            sc.nextLine();
            Line[] lines = new Line[nLines];
            for(int i=0; i<nLines; i++){
                String input = sc.nextLine();
                String[] split = input.split(" ");
                lines[i] = new Line(split[0], split[1]);
                System.out.println(lines[i].x1+" "+lines[i].y1+", " + lines[i].x2+" "+lines[i].y2);
            }
        }
    }
    
    public static class Line{
        int x1, y1, x2, y2;
        double dist;
        boolean drawn;
        
        public Line(String a, String b){
            x1 = Integer.parseInt(a.charAt(1)+"")-1;
            y1 = a.charAt(0)-65;
            x2 = Integer.parseInt(b.charAt(1)+"")-1;
            y2 = b.charAt(0)-65;
            dist = Math.hypot(x1-x2, y1-y2);
            drawn = false;
        }
    }
}
