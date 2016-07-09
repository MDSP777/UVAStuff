package uvastuff;

import java.util.ArrayList;
import java.util.Scanner;

public class N12412 {
    static ArrayList<Student> students;
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args){
        int input;
        students = new ArrayList();
        do{
            printMenu();
            input = sc.nextInt();
            sc.nextLine();
            switch(input){
                case 1: addS(); break;
                case 2: removeS(); break;
                case 3: query(); break;
                case 4: System.out.println("Showing the ranklist hurts students' self-esteem. Don't do that."); break;
                case 5: getStats(); break;
            }
        }while(input!=0);

    }
    
    public static void printMenu(){
        System.out.println("Welcome to Student Performance Management System (SPMS).\n");
        System.out.println("1 - Add\n" +
        "2 - Remove\n" +
        "3 - Query\n" +
        "4 - Show ranking\n" +
        "5 - Show Statistics\n" +
        "0 - Exit\n");
    }
    
    public static void addS(){
        while(true){
            System.out.println("Please enter the SID, CID, name and four scores. Enter 0 to finish.");
            long sid = sc.nextLong();
            if(sid==0) return;
            else{
                if(taken(sid)){
                    System.out.println("Duplicated SID.");
                    sc.nextLine();
                }
                else{
                    students.add(new Student(sid, sc.nextLong(), sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
                    sc.nextLine();
                }
            }
        }
    }
    
    public static boolean taken(long sid){
        int n = students.size();
        for(int i=0; i<n; i++)
            if(students.get(i).sid == sid) return true;
        return false;
    }
    
    public static void removeS(){
        while(true){
            int n = students.size();
            int nr = 0;
            System.out.println("Please enter SID or name. Enter 0 to finish.");
            String in = sc.nextLine();
            if(in.equals("0")) return;
            if(!hasLetters(in)){
                long delsid = Long.parseLong(in);
                for(int i=0; i<n; i++)
                    if(students.get(i).sid==delsid){
                        students.remove(i);
                        n--;
                        i--;
                        nr++;
                    }
            }
            else{
                for(int i=0; i<n; i++)
                    if(students.get(i).name.equals(in)){
                        students.remove(i);
                        n--;
                        i--;
                        nr++;
                    }
            }
            System.out.println(nr + " student(s) removed.");
        }
    }
    
    public static boolean hasLetters(String a){
        int n = a.length();
        for(int i=0; i<n; i++){
            if((a.charAt(i)>='a'&&a.charAt(i)<='z')||(a.charAt(i)>='A'&&a.charAt(i)<='Z')) return true;
        }
        return false;
    }
    
    public static void query(){
        while(true){
            System.out.println("Please enter SID or name. Enter 0 to finish.");
            String in = sc.nextLine();
            if(in.equals("0")) return;
            if(!hasLetters(in)){
                
            }
        }
    }
    
    public static void getStats(){
        System.out.println("Please enter class ID, 0 for the whole statistics.");
        int cp=0, cf=0, mp=0, mf=0, ep=0, ef=0, pp=0, pf=0;
        int pass0=0, pass1=0, pass2=0, pass3=0, pass4=0;
        double ct=0, mt=0, et=0, pt=0;
        int cid = sc.nextInt();
        int n = students.size();
        if(cid!=0){
            for(int i=0; i<n; i++){
                Student c = students.get(i);
                if(c.cid==cid){
                    if(c.cs>=60){
                        cp++;
                    }
                    else cf++;
                    ct+=c.cs;
                    if(c.ms>=60){
                        mp++;
                    }
                    else mf++;
                    mt+=c.ms;
                    if(c.es>=60){
                        ep++;
                    }
                    else ef++;
                    et+=c.es;
                    if(c.ps>=60){
                        pp++;
                    }
                    else pf++;
                    pt+=c.ps;
                    
                    int p = c.nPass();
                    if(p==4){
                        pass4++;
                        pass3++;
                        pass2++;
                        pass1++;
                    }
                    else if(p==3){
                        pass3++;
                        pass2++;
                        pass1++;
                    }
                    else if(p==2){
                        pass2++;
                        pass1++;
                    }
                    else if(p==1) pass1++;
                    else pass0++;
                }
            }
        }
        else{
            for(int i=0; i<n; i++){
                Student c = students.get(i);
                if(c.cs>=60){
                    cp++;
                }
                else cf++;
                ct+=c.cs;
                if(c.ms>=60){
                    mp++;
                }
                else mf++;
                mt+=c.ms;
                if(c.es>=60){
                    ep++;
                }
                else ef++;
                et+=c.es;
                if(c.ps>=60){
                    pp++;
                }
                else pf++;
                pt+=c.ps;
                int p = c.nPass();
                if(p==4){
                    pass4++;
                    pass3++;
                    pass2++;
                    pass1++;
                }
                else if(p==3){
                    pass3++;
                    pass2++;
                    pass1++;
                }
                else if(p==2){
                    pass2++;
                    pass1++;
                }
                else if(p==1) pass1++;
                else pass0++;
            }
        }
        
        System.out.println("Chinese");
        System.out.printf("Average Score: %.2f\n", ct/(cp+cf)+0.00001);
        System.out.println("Number of passed students: "+cp);
        System.out.println("Number of failed students: "+cf+"\n");
        
        System.out.println("Mathematics");
        System.out.printf("Average Score: %.2f\n", mt/(mp+mf)+0.00001);
        System.out.println("Number of passed students: "+mp);
        System.out.println("Number of failed students: "+mf+"\n");
        
        System.out.println("English");
        System.out.printf("Average Score: %.2f\n", et/(ep+ef)+0.00001);
        System.out.println("Number of passed students: "+ep);
        System.out.println("Number of failed students: "+ef+"\n");
        
        System.out.println("Programming");
        System.out.printf("Average Score: %.2f\n", pt/(pp+pf)+0.00001);
        System.out.println("Number of passed students: "+pp);
        System.out.println("Number of failed students: "+pf+"\n");
        
        System.out.println("Overall:");
        System.out.println("Number of students who passed all subjects: "+pass4+"\n" +
        "Number of students who passed 3 or more subjects: "+pass3+"\n" +
        "Number of students who passed 2 or more subjects: "+pass2+"\n" +
        "Number of students who passed 1 or more subjects: "+pass1+"\n" +
        "Number of students who failed all subjects: "+pass0+"\n");
    }
    
    public static class Student{
        long sid, cid;
        String name;
        int cs, ms, es, ps;
        int rank;
        int total;
        double ave;
        
        public Student(long sid, long cid, String name, int cs, int ms, int es, int ps){
            this.sid = sid;
            this.cid = cid;
            this.name = name;
            this.cs = cs;
            this.ms = ms;
            this.es = es;
            this.ps = ps;
            total = cs+ms+es+ps;
            ave = total/4;
        }
        
        public int nPass(){
            int p = 0;
            if(cs>=60)p++;
            if(ms>=60)p++;
            if(es>=60)p++;
            if(ps>=60)p++;
            return p;
        }
    }
}
