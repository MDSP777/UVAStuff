
import java.util.Scanner;

public class CodeJamPractice {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt(); 
        sc.nextLine();
        for(int x=1; x<=nC; x++){
            char[][] grid = new char[4][4];
            for(int i=0; i<4; i++)
                grid[i] = sc.nextLine().toCharArray();
            if(checkX(grid)) System.out.println("Case #"+x+": X won");
            else if(checkO(grid)) System.out.println("Case #"+x+": O won");
            else if(checkDraw(grid)) System.out.println("Case #"+x+": Draw");
            else System.out.println("Case #"+x+": Game has not completed");
            sc.nextLine();
        }

    }

    private static boolean checkX(char[][] grid) {
        int s1 = 'X'+'X'+'X'+'T';
        int s2 = 'X'+'X'+'X'+'X';
        
        for(int i=0; i<4; i++){
            int sum1 = 0;
            int sum2 = 0;
            for(int j=0; j<4; j++){
                sum1+=grid[i][j];
                sum2+=grid[j][i];
            }
            if(sum1==s1 || sum1==s2 || sum2==s1 || sum2==s2) return true;
        }
        
        int sum1 = 0;
        int sum2 = 0;
        for(int i=0; i<4; i++){
            sum1+=grid[i][i];
            sum2+=grid[i][3-i];
        }
        if(sum1==s1 || sum1==s2 || sum2==s1 || sum2==s2) return true;
        return false;
    }
    
    private static boolean checkO(char[][] grid) {
        int s1 = 'O'+'O'+'O'+'T';
        int s2 = 'O'+'O'+'O'+'O';
        
        for(int i=0; i<4; i++){
            int sum1 = 0;
            int sum2 = 0;
            for(int j=0; j<4; j++){
                sum1+=grid[i][j];
                sum2+=grid[j][i];
            }
            if(sum1==s1 || sum1==s2 || sum2==s1 || sum2==s2) return true;
        }
        
        int sum1 = 0;
        int sum2 = 0;
        for(int i=0; i<4; i++){
            sum1+=grid[i][i];
            sum2+=grid[i][3-i];
        }
        if(sum1==s1 || sum1==s2 || sum2==s1 || sum2==s2) return true;
        return false;
    }

    private static boolean checkDraw(char[][] grid) {
        for(int i=0; i<4; i++)
            for(int j=0; j<4; j++)
                if(grid[i][j]=='.') return false;
        return true;
    }
}
