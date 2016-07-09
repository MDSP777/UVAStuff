/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objecttest;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class N10189 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x, y;
        y = sc.nextInt();
        x = sc.nextInt();
        sc.nextLine();
        int t=1;
        while(!(x==0&&y==0)){
            char[][] grid = new char[y][x];
            char[][] outgrid = new char[y][x]; 
            for(int i=0; i<x; i++)
                for(int j=0; j<y; j++)
                    outgrid[j][i] = '0';
            for(int i=0; i<y; i++)
                grid[i] = sc.nextLine().toCharArray();
            for(int i=0; i<x; i++){
                for(int j=0; j<y; j++){
                    if(grid[j][i]=='*'){
                        outgrid[j][i] = '*';
                        if(j>0 && i>0 && outgrid[j-1][i-1]!='*') outgrid[j-1][i-1]++;
                        if(j>0 && outgrid[j-1][i]!='*') outgrid[j-1][i]++;
                        if(j>0 && i<x-1 && outgrid[j-1][i+1]!='*') outgrid[j-1][i+1]++;
                        
                        if(j<y-1 && i>0 && outgrid[j+1][i-1]!='*') outgrid[j+1][i-1]++;
                        if(j<y-1 && outgrid[j+1][i]!='*') outgrid[j+1][i]++;
                        if(j<y-1 && i<x-1 && outgrid[j+1][i+1]!='*') outgrid[j+1][i+1]++;
                        
                        if(i>0 && outgrid[j][i-1]!='*') outgrid[j][i-1]++;
                        if(i<x-1 && outgrid[j][i+1]!='*') outgrid[j][i+1]++;
                    }
                }
            }
            System.out.println("Field #"+ t++ +":");
            for(int i=0; i<y; i++){
                System.out.println(outgrid[i]);
            }
            y = sc.nextInt();
            x = sc.nextInt();
            if(!(x==0&&y==0)) System.out.println();
            sc.nextLine();
        }
    }
}
