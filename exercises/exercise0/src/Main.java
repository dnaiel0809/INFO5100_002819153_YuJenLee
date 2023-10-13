// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;

class Student {
    static int id=0;
    String name;
    Phone phone;
    Backpack backpack;
    String country;
    String gender;
    String birthday;
    int age;
    int degree;
    Student(String name){
        System.out.println("student constructor is called.");
        id+=1;
        this.name = name;
        phone = new Phone();
        backpack = new Backpack();
        System.out.println("id: "+id);
        System.out.println("name: "+this.name);
    }
    void getID(){
        System.out.println(id);
    }
    void walk(){ System.out.println(name+" walks.");}
    void talk(){}
    void look(){}
}
class Phone {
    static int id;
    String brand;
    Phone(){
        id+=1;
        System.out.println("Phone construct is called.");
        System.out.println("id: "+id);
    }
    void call(){System.out.println("Phone called.");}
    void open(){System.out.println("Phone opened.");}
    void takePhoto(){System.out.println("Phone took photo.");}
}
class Table {
    static int id;
    String brand;
    void move(){System.out.println("Table moved.");}
    void sell(){System.out.println("Table sold.");}
    void turn(){System.out.println("Table turned.");}
    Table(){
        id+=1;
        System.out.println("Table construct is called.");
        System.out.println("id: "+id);
    }
}
class Chair {
    static int id;
    String brand;
    void move(){System.out.println("Table moved.");}
    void sell(){System.out.println("Table sold.");}
    void turn(){System.out.println("Table turned.");}
    Chair(){
        id+=1;
        System.out.println("Chair construct is called.");
        System.out.println("id: "+id);
    }
}
class Wheel {
    static int id;
    int count;
    void move(){System.out.println("Table moved.");}
    void sell(){System.out.println("Table sold.");}
    void turn(){System.out.println("Table turned.");}

    Wheel(){
        id+=1;
        System.out.println("Wheel construct is called.");
        System.out.println("id: "+id);
    }
}
class Backpack {
    static int id;
    String color;


    void open(){System.out.println("Backpack open.");}
    void close(){System.out.println("Backpack close.");}
    void takeOutStuff(){System.out.println("Backpack took out stuff.");}
    Backpack(){
        id+=1;
        System.out.println("Backpack construct is called.");
        System.out.println("id: "+id);
    }
}
class Light {
    static int id;
    boolean openOrNot;

    void open(){System.out.println("Light opened.");}
    void changeLightBulb(){System.out.println("Light changed.");}
    void sell(){System.out.println("Light sold.");}
    Light(){
        id+=1;
        System.out.println("Light construct is called.");
        System.out.println("id: "+id);
    }
}
class Door {
    static int id;
    boolean openOrNot;
    void open(){System.out.println("Door opened.");}
    void close(){System.out.println("Door closed.");}
    void fix(){System.out.println("Door fixed.");}

    Door(){
        id+=1;
        System.out.println("Door construct is called.");
        System.out.println("id: "+id);
    }
}
class Laptop {
    static int id;
    String brand;
    void open(){System.out.println("Laptop opened.");}
    void close(){System.out.println("Laptop closed.");}
    void typing(){System.out.println("Laptop typing.");}
    Laptop(){
        id+=1;
        System.out.println("Laptop construct is called.");
        System.out.println("id: "+id);
    }
}
class Bottle {
    static int id;
    String brand;
    void open(){System.out.println("Bottle opened.");}
    void close(){System.out.println("Bottle closed.");}
    void sell(){System.out.println("Bottle sold.");}
    Bottle(){
        id+=1;
        System.out.println("Bottle construct is called.");
        System.out.println("id: "+id);
    }
}
public class Main {
    public static void main(String[] args) {
//        Print a statement in constructor to indicate creation of each instance, preferably identify each instance with unique id/name
        String[] name = {"Amber", "Derek", "Lily", "Valentina","Caroline", "Nathanael", "Kelly", "Elliot", "Tyrese", "Macie"};
        List<Student> students = new ArrayList<Student> ();

        for (int i =0;i<10;i++) {
            students.add(new Student(name[i]));
        }

        students.get(1).walk();
//        Create a Main method to instantiate at least 3 objects of each class
        Phone phone1 = new Phone();
        phone1.call();
        Phone phone2 = new Phone();
        phone2.open();
        Phone phone3 = new Phone();
        phone3.takePhoto();

        Table table1 = new Table();
        table1.move();
        Table table2 = new Table();
        table2.sell();
        Table table3 = new Table();
        table3.turn();

        Chair chair1 = new Chair();
        chair1.sell();
        Chair chair2 = new Chair();
        chair2.move();
        Chair chair3 = new Chair();
        chair3.turn();

        Wheel wheel1 = new Wheel();
        wheel1.move();
        Wheel wheel2 = new Wheel();
        wheel2.sell();
        Wheel wheel3 = new Wheel();
        wheel3.turn();

        Backpack backpack1 = new Backpack();
        backpack1.close();
        Backpack backpack2 = new Backpack();
        backpack2.open();
        Backpack backpack3 = new Backpack();
        backpack3.takeOutStuff();

        Light light1 = new Light();
        light1.changeLightBulb();
        Light light2 = new Light();
        light2.sell();
        Light light3 = new Light();
        light3.open();

        Door door1 = new Door();
        door1.close();
        Door door2 = new Door();
        door2.open();
        Door door3 = new Door();
        door3.fix();

        Laptop laptop1 = new Laptop();
        laptop1.close();
        Laptop laptop2 = new Laptop();
        laptop2.open();
        Laptop laptop3 = new Laptop();
        laptop3.typing();

        Bottle bottle1 = new Bottle();
        bottle1.close();
        Bottle bottle2 = new Bottle();
        bottle2.open();
        Bottle bottle3 = new Bottle();
        bottle3.sell();


    }
}