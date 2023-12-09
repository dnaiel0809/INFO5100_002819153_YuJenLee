import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

abstract class Shape implements java.io.Serializable {
    //    protected double area;
    static protected String color = "black";
    protected double height;
    protected double width;
    protected double radius;

    public abstract double calculateArea();
    public abstract double calculatePerimeter();

    public void getColor() {
        System.out.println(color);
    }


};
class Triangle extends Shape{
    Triangle(double h, double w){
        height=h;
        width=w;
    }

    public double calculateArea() {
        return height*width/2;
    }
    public double calculatePerimeter() {
        return (height+width)*2;
    }


};
class Rectangle extends Shape{
    Rectangle(double h, double w){
        height=h;
        width=w;
    }
    public double calculateArea() {
        return height*width;

    }
    public double calculatePerimeter() {
        return (height+width)*2;
    }


} ;

class Square extends Shape{
    Square(double h, double w){
        height=h;
        width=w;
    }
    public double calculateArea() {
        return height*width/2;
    }
    public double calculatePerimeter() {
        return (height+width)*2;
    }


};

class Circle extends Shape{
    Circle(double r){
        radius = r;
    }
    public double calculateArea() {
        return radius*radius*3.14;
    }
    public double calculatePerimeter() {
        return 2*radius;
    }

};
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        Triangle triangle = new Triangle(2,3);
//        Rectangle rectangle = new Rectangle(4,5);
//        Square square = new Square(6,3);
//        Circle circle = new Circle(5);


        try {
            FileOutputStream fileOut = new FileOutputStream("shape.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(triangle);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /shape.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }


        Triangle e = null;
        try {
            FileInputStream fileIn = new FileInputStream("shape.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (Triangle) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Triangle class not found");
            c.printStackTrace();
            return;
        }


        System.out.println("Triangle area:");
        System.out.println(e.calculateArea());
        System.out.println("Triangle perimeter:");
        System.out.println(e.calculatePerimeter());

//        triangle.getColor();
//        square.getColor();
//        System.out.println("Circle area:");
//        System.out.println(circle.calculateArea());
//        System.out.println("Circle perimeter:");
//        System.out.println(circle.calculatePerimeter());
//        System.out.println("Square area:");
//        System.out.println(square.calculateArea());
//        System.out.println("Square perimeter:");
//        System.out.println(square.calculatePerimeter());
//        System.out.println("Triangle area:");
//        System.out.println(triangle.calculateArea());
//        System.out.println("Triangle perimeter:");
//        System.out.println(triangle.calculatePerimeter());
//        System.out.println("Rectangle area:");
//        System.out.println(rectangle.calculateArea());
//        System.out.println("Rectangle perimeter:");
//        System.out.println(rectangle.calculatePerimeter());

    }
}
