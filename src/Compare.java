
import java.util.ArrayList;
import java.util.Collections;

public class Compare {
    public static void main(String[] args){
        ArrayList<Person> p = new ArrayList();
        p.add(new Person("Bryan", 20));
        p.add(new Person("Marc", 18));
        p.add(new Person("Avril", 18));
        p.add(new Person("Rissa", 18));
        p.add(new Person("Shayane", 18));
        p.add(new Person("Glenn", 17));
        
        Collections.sort(p);
        for(int i=0; i<p.size(); i++)
            p.get(i).sayHi();
    }
    
    static class Person implements Comparable<Person>{
        String name;
        int age;
        
        public Person(String n, int a){
            name = n;
            age = a;
        }
        
        public void sayHi(){
            System.out.println("Hi, my name is "+name+" and I am "+age+" years old!");
        }

        public int compareTo(Person o) {
            return name.compareTo(o.name);
        }
    }
}
