/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uvastuff;

import java.util.Scanner;

/**
 *
 * @author MarcDominic
 */
public class N259 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean first = true;
        do{
            StringBuilder out = new StringBuilder("");
            char[] list = new char[10];
            boolean success = true;
            for(int i=0; i<10; i++){
                list[i] = '_';
            }
            String line = sc.nextLine();
            String spaces="";
            while(!line.equals("")||sc.hasNext()){
                int nAlloc=0;
                line = line.substring(0, line.length()-1);
                char app = line.charAt(0);
                String spaces2;
                int n = Integer.parseInt(line.charAt(1)+"");
                if(first){
                    spaces = line.substring(3);
                    first = false;
                    spaces2 = spaces;
                }
                else
                    spaces2 = line.substring(3);
                for(int i=0; i<spaces2.length(); i++){
                    int loc = Integer.parseInt(spaces2.charAt(i)+"");
                    if(list[loc]=='_'){
                        list[loc] = app;
                        nAlloc++;
                    }
                    else{
                        for(int j=0; j<10; j++){
                            if(list[j]=='_'&&asdf(spaces, j)){
                                list[j] = list[loc];
                                list[loc] = app;
                                nAlloc++;
                                break;
                            }
                        }
                    }
                    for(int ii=0; ii<list.length; ii++)
                        System.out.print(list[ii]);
                    System.out.println("");
                    if(nAlloc==n)break;
                }
                spaces = line.substring(3);
                line = sc.nextLine();
                if(nAlloc<n) success = false;
            }
            if(!success) System.out.println("!");
            else{
                for(int i=0; i<10; i++)
                    out.append(list[i]);
                System.out.println(out);
            }
        }while(sc.hasNext());
    }
    
    public static boolean asdf(String a, int b){
        for(int i=0; i<a.length(); i++)
            if(Integer.parseInt(a.charAt(i)+"")==b) return true;
        return false;
    }
}
