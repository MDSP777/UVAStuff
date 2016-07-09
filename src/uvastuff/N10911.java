package uvastuff;

import java.util.ArrayList;
import java.util.Scanner;

public class N10911 {
    static double[][] distanceArr;
    static double[] dpArr;
    static int n;
    static ArrayList<Person> persons;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int x, y, i, caseNo = 1;
        String name;
        while(n != 0){
            persons = new ArrayList();
            int asdf = (int)Math.pow(2, n*2);
            dpArr = new double[asdf];
            for(i=0; i<asdf; i++) dpArr[i] = -1;
            distanceArr = new double[n*2][n*2];
            for(i = 0; i < n * 2; i++){
                name = sc.next();
                x = sc.nextInt();
                y = sc.nextInt();
                persons.add(new Person(x, y, name));
            }
            int s = persons.size();
            for(i=0; i<s; i++)
                for(int j=0; j<s; j++)
                    distanceArr[i][j] = getDistance(persons.get(i), persons.get(j));
            System.out.printf("Case %d: %.2f\n", caseNo, dp(0));
            caseNo++;
            n = sc.nextInt();
        }
    }
    
    public static double dp(int bitmask){
        //System.out.println(Integer.toBinaryString(bitmask));
        double val = Double.MAX_VALUE;
        if(dpArr[bitmask]!=-1) return dpArr[bitmask];
        if(bitmask==(Math.pow(2, n*2)-1)){
            dpArr[bitmask] = 0;
            return 0;
        }
        for(int i=0; i<n*2; i++)
            if((bitmask & (1<<i))==0){
                for(int j=i+1; j<n*2; j++)
                    if((bitmask & (1<<j))==0)
                        val = Math.min(val, distanceArr[i][j]+dp(bitmask | (1<<i) | (1<<j)));
            }
        dpArr[bitmask] = val;
        return val;
    }
    
    public static double getDistance(Person p1, Person p2){
        double distance;
        int x, y;
        x = p1.x - p2.x;
        y = p1.y - p2.y;
        distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return distance;
    }
    
    public static class Person{
        int x, y;
        String name;
        
        public Person(int x, int y, String name){
            this.x = x;
            this.y = y;
            this.name = name;
        }
    }
}
