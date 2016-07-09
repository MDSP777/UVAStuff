package uvastuff;

import java.util.Scanner;

public class N572 {
    static int m, n;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        sc.nextLine();
        while(!(m==0&&n==0)){
            long total = 0;
            char[][] grid = new char[m][n];
            for(int i=0; i<m; i++)
                grid[i] = sc.nextLine().toCharArray();
            for(int i=0; i<m; i++)
                for(int j=0; j<n; j++)
                    if(grid[i][j]=='@'){
                        clean(grid, i, j);
                        total++;
                    }
            System.out.println(total);
            m = sc.nextInt();
            n = sc.nextInt();
            sc.nextLine();
        }
    }
    
    public static void clean(char[][] grid, int i, int j){
        grid[i][j] = '*';
        if(i>0 && j>0 && grid[i-1][j-1]=='@') clean(grid, i-1, j-1);
        if(j>0 && grid[i][j-1]=='@') clean(grid, i, j-1);
        if(i<m-1 && j>0 && grid[i+1][j-1]=='@') clean(grid, i+1, j-1);
        if(i>0 && grid[i-1][j]=='@') clean(grid, i-1, j);
        if(i<m-1 && grid[i+1][j]=='@') clean(grid, i+1, j);
        if(i>0 && j<n-1 && grid[i-1][j+1]=='@') clean(grid, i-1, j+1);
        if(j<n-1 && grid[i][j+1]=='@') clean(grid, i, j+1);
        if(i<m-1 && j<n-1 && grid[i+1][j+1]=='@') clean(grid, i+1, j+1);
    }
}
