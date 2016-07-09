package uvastuff;

import java.util.Scanner;

public class N11624 {
    static char[][] grid;
    static int row;
    static int col;
    static boolean isAlive;
    
    static int[] xInc = {-1, 1, 0, 0};
    static int[] yInc = {0, 0, -1, 1};
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int x=0; x<nC; x++){
            row = sc.nextInt();
            col = sc.nextInt();
            sc.nextLine();
            grid = new char[row][];
            for(int i=0; i<row; i++)
                grid[i] = sc.nextLine().toCharArray();
            int ans = 0;
            isAlive=true;
            while(!won() && isAlive){
//                print();
                for(int i=0; i<row; i++)
                    for(int j=0; j<col; j++){
                        if(grid[i][j]=='J'){
                            for(int k=0; k<4; k++){
                                int curX = i+xInc[k];
                                int curY = j+yInc[k];
                                if(curX>=0 && curX<row && curY>=0 && curY<col && grid[curX][curY]=='.'){
                                    grid[curX][curY] = 'j';
                                }
                            }
                        }
                    }
                
                for(int i=0; i<row; i++)
                    for(int j=0; j<col; j++){
                        if(grid[i][j]=='F'){
                            for(int k=0; k<4; k++){
                                int curX = i+xInc[k];
                                int curY = j+yInc[k];
                                if(curX>=0 && curX<row && curY>=0 && curY<col && grid[curX][curY]!='#'){
                                    grid[curX][curY] = 'f';
                                }
                            }
                        }
                    }
                isAlive = false;
                for(int i=0; i<row; i++)
                    for(int j=0; j<col; j++){
                        if(grid[i][j]=='J' || grid[i][j]=='j')
                            isAlive=true;
                        if(grid[i][j]=='j')
                            grid[i][j]='J';
                        else if(grid[i][j]=='f')
                            grid[i][j]='F';
                    }
                ans++;
            }
            if(!isAlive)
                System.out.println("IMPOSSIBLE");
            else System.out.println(ans+1);
        }

    }

    private static boolean won() {
        for(int i=0; i<col; i++)
            if(grid[0][i]=='J' || grid[row-1][i]=='J')
                return true;
        for(int j=0; j<row; j++)
            if(grid[j][0]=='J' || grid[j][col-1]=='J')
                return true;
        return false;
    }
    
    static void print(){
        System.out.println("");
        for(int i=0; i<row; i++)
            System.out.println(grid[i]);
    }
}
