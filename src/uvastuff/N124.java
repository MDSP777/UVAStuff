/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uvastuff;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author MarcDominic
 */
public class N124 {
    static int total;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int i=1; i<=nC; i++){
            total = 0;
            int x = sc.nextInt(), y = sc.nextInt();
            getPath(0, 0, x-1, y-1);
            System.out.println("Case "+i+": "+total);
        }
    }
    
    public static void getPath(int currX, int currY, int x, int y){
        if(currX==x && currY==y) total++;
        if(currX>x||currY>y){}
        else{
            getPath(currX+1, currY, x, y);
            getPath(currX, currY+1, x, y);
        }
    }
    
    /*public static void getPath(int x, int y){
        BigInteger one = new BigInteger(Integer.toString(x+y-2));
        one = fac(one);
        BigInteger two = fac(new BigInteger(Integer.toString(x-1))).multiply(fac(new BigInteger(Integer.toString(y-1))));
        System.out.println(one.divide(two));
    }
    
    public static BigInteger fac(BigInteger a){
        BigInteger total = new BigInteger("1");
        while(a.compareTo(new BigInteger("1"))>0){
            total = total.multiply(a);
            a = a.subtract(new BigInteger("1"));   
        }
        return total;
    }*/
}
