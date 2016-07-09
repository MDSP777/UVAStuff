public class Animal {
    String name;
    
    public Animal(String n){
        name = n;
    }
    
    public static void yes(Animal x){
        x.name = "ABC";
    }
    
    public static void main(String[] args){
        Animal y = new Animal("A");
        yes(y);
        System.out.println(y.name);
    }
}
