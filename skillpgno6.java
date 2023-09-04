import java.util.Scanner;

// Shape interface
interface Shape {
    double calculateArea();
    double calculatePerimeter();
}

// Square class implementing Shape interface
class Square implements Shape {
    double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }
}

// Circle class implementing Shape interface
class Circle implements Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

// Triangle class implementing Shape interface
class Triangle implements Shape {
    double side1, side2, side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double calculateArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }
}

public class skillpgno6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select a shape: ");
        System.out.println("1. Square");
        System.out.println("2. Circle");
        System.out.println("3. Triangle");

        int choice = scanner.nextInt();

        Shape shape;

        switch (choice) {
            case 1:
                System.out.print("Enter the side length of the square: ");
                double side = scanner.nextDouble();
                shape = new Square(side);
                break;
            case 2:
                System.out.print("Enter the radius of the circle: ");
                double radius = scanner.nextDouble();
                shape = new Circle(radius);
                break;
            case 3:
                System.out.print("Enter the lengths of the triangle's three sides: ");
                double side1 = scanner.nextDouble();
                double side2 = scanner.nextDouble();
                double side3 = scanner.nextDouble();
                shape = new Triangle(side1, side2, side3);
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        double area = shape.calculateArea();
        double perimeter = shape.calculatePerimeter();

        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);

        scanner.close();
    }
}