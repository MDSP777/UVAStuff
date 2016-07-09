package uvastuff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N11627 {
    static int w;
    static double hSpeed;
    static Gate[] gates;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int nC = Integer.parseInt(br.readLine().trim());
        for(int x=0; x<nC; x++){
            String as = br.readLine();
            if(as==null){
                System.out.print(sb);
                return;
            }
            String[] split = as.trim().split(" ");
            w = Integer.parseInt(split[0].trim());
            hSpeed = Double.parseDouble(split[1].trim());
            int nGates = Integer.parseInt(split[2].trim());
            
            gates = new Gate[nGates];
            for(int i=0; i<nGates; i++){
                split = br.readLine().trim().split(" ");
                gates[i] = new Gate(Double.parseDouble(split[0].trim()), Double.parseDouble(split[1].trim()));
            }
            
            int nSkis = Integer.parseInt(br.readLine().trim());
            int[] skis = new int[nSkis];
            
            for(int i=0; i<nSkis; i++){
                boolean FUCK = false;
                StringBuilder asdf = new StringBuilder();
                while(true){
                    int c = br.read();
                    if(c>57 || c<48){
                        if(c==-1){
                            FUCK = true;
                            break;
                        }
                        if(asdf.length()==0) continue;
                        break;
                    }
                    asdf.append((char)c);
                }
                if(FUCK) break;
                skis[i] = Integer.parseInt(asdf.toString());
            }
            Arrays.sort(skis);
            int l = 0;
            int r = skis.length-1;
            int ans = -1;
            while(l<=r){
                int mid = (l+r)/2;
                if(canPass(skis[mid])){
                    ans = skis[mid];
                    l = mid+1;
                } else {
                    r = mid-1;
                }
            }
            if(ans==-1) sb.append("IMPOSSIBLE\n");
            else sb.append(ans+"\n");
        }
        System.out.print(sb);
        
    }

    private static boolean canPass(double vSpeed) {
        double l = gates[0].leftX;
        double r = gates[0].rightX;
        
        for(int i=1; i<gates.length; i++){
            double dist = (gates[i].leftY-gates[i-1].leftY)*hSpeed/vSpeed;
            l = Math.max(l-dist, gates[i].leftX);
            r = Math.min(r+dist, gates[i].rightX);
        }
        return l<=r;
    }
    
    static class Gate {
        double leftX;
        double leftY;
        double rightX;
        double rightY;
        
        public Gate(double x, double y){
            leftX = x;
            rightX = x+w;
            leftY = rightY = y;
        }   
    }
}
