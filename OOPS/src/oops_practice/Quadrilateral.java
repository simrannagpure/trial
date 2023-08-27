package oops_practice;
import java.util.*;

// Do not edit the Quadrilateral class
abstract class Quadrilateral {
    double side1;
    double side2;
    double side3;
    double side4;

    public Quadrilateral(double side1, double side2, double side3, double side4) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.side4 = side4;
    }

    protected abstract double getArea();

    protected double getPerimeter() {
        return (side1+side2+side3+side4);
    }
}

// Implement class Parallelogram and methods getArea() and getPerimeter()
class Parallelogram extends Quadrilateral {
    //Write your code here
    private double side1;
    private double side2;
    private double height_para;
    //constructor
    public Parallelogram(double side1, double side2, double height_para){
        super(side1, side2, side1, side2);
        this.side1 = side1;
        this.side2 = side2;
        this.height_para = height_para;
    }
    //methods
    public double getArea(){
        return side1*height_para;
    }
    public double getPerimeter(){
        return 2*(side1+side2);
    }
}

// Implement class Rhombus and methods getArea() and getPerimeter()
class Rhombus extends Parallelogram {
    //Write your code here
    private double side;
    private double height_rh;
    //constructor
    public Rhombus(double side, double height_rh){
        super(side, side, height_rh);
        this.side = side;
        this.height_rh = height_rh;
    }
    //method
    public double getArea(){
        return side*height_rh;
    }
    public double getPerimeter(){
        return 4*side;
    }
}

//Implement class Rectangle and methods getArea() and getPerimeter()
class Rectangle extends Parallelogram {
    //Write your code here
    private double length;
    private double height_rect;
    //constructor
    public Rectangle(double length, double height_rect){
        super(length, length, height_rect);
        this.length = length;
        this.height_rect = height_rect;
    }
    public double getArea(){
        return length*height_rect;
    }
    public double getPerimeter(){
        return 2*(length+height_rect);
    }
}
//Implement class Square and methods getArea() and getPerimeter()
class Square extends Rhombus {
    //Write your code here
    private double side_sq;
    //constructor
    public Square(double side_sq){
        super(side_sq, side_sq);
        this.side_sq = side_sq;
    }
    public double getArea(){
        return side_sq*side_sq;
    }
    public double getPerimeter(){
        return 4*side_sq;
    }
}



// Do not edit the Main class
class Main1 {
    public static void main(String[] args) {
        //Write your code here
        Scanner scan = new Scanner(System.in);
        double side1 = scan.nextDouble();
        double side2 = scan.nextDouble();
        double height_para = scan.nextDouble();
        double side = scan.nextDouble();
        double height_rh = scan.nextDouble();
        double length = scan.nextDouble();
        double height_rect = scan.nextDouble();
        double side_sq = scan.nextDouble();
        if(side1<0 || side2<0 || side<0 || side_sq<0 || length<0 || height_rect<0 || height_rh<0 || height_para<0){
            System.out.println("Length of a side cannot be negative. Please Enter a positive integer");
        }else {
            //parallelogram
            Parallelogram p1 = new Parallelogram(side1, side2, height_para);
            System.out.println("Perimeter of Parallelogram is " + p1.getPerimeter() + "and Area of Parallelogram is " + p1.getArea());
            //Rhombus
            Rhombus rh = new Rhombus(side, height_rh);
            System.out.println("Perimeter of Rhombus is " + rh.getPerimeter() + "and Area of Rhombus is " + rh.getArea());
            //Rectangle
            Rectangle rect = new Rectangle(length, height_rect);
            System.out.println("Perimeter of Rectangle is " + rect.getPerimeter() + " and Area of Rectangle is " + rect.getArea());
            //Square
            Square sq = new Square(side_sq);
            System.out.println("Perimeter of Square is " + sq.getPerimeter() + " and Area of Square is " + sq.getArea()
            );
            scan.close();
        }
    }
}