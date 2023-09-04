import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Automobile {
    String model;
    double price;
    double mileage;

    public Automobile(String model, double price, double mileage) {
        this.model = model;
        this.price = price;
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Model: " + model + "\nPrice: $" + price + "\nMileage: " + mileage + " km/l";
    }
}

class Car extends Automobile {
    int horsepower;
    int numSeats;
    String type;

    public Car(String model, double price, double mileage, int horsepower, int numSeats, String type) {
        super(model, price, mileage);
        this.horsepower = horsepower;
        this.numSeats = numSeats;
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + "\nHorsepower: " + horsepower + " HP" + "\nNumber of Seats: " + numSeats + "\nType: " + type;
    }
}

class Bike extends Automobile {
    int cc;
    String bikeType;

    public Bike(String model, double price, double mileage, int cc, String bikeType) {
        super(model, price, mileage);
        this.cc = cc;
        this.bikeType = bikeType;
    }

    @Override
    public String toString() {
        return super.toString() + "\nContainer Capacity: " + cc + " CC" + "\nType: " + bikeType;
    }
}

class Customer {
    String name;
    String phoneNumber;
    String dob;
    int age;
    String address;

    public Customer(String name, String phoneNumber, String dob, int age, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPhone Number: " + phoneNumber + "\nDate of Birth: " + dob + "\nAge: " + age + "\nAddress: " + address;
    }
}

public class BMWPortal {
    private List<Automobile> products = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addProduct(Automobile product) {
        products.add(product);
    }

    public void buyProduct() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter your date of birth: ");
        String dob = scanner.nextLine();
        System.out.print("Enter your age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter your address: ");
        String address = scanner.nextLine();

        System.out.println("Available products:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(i + 1 + ". " + products.get(i).model);
        }

        System.out.print("Enter the number of the product you want to buy: ");
        int productIndex = Integer.parseInt(scanner.nextLine()) - 1;
        if (productIndex >= 0 && productIndex < products.size()) {
            Customer customer = new Customer(name, phoneNumber, dob, age, address);
            customers.add(customer);
            System.out.println("Congratulations! You've successfully bought the following product:\n" + products.get(productIndex));
        } else {
            System.out.println("Invalid product number.");
        }
    }

    public void checkProductStatus() {
        System.out.print("Enter your phone number: ");
        String phoneNumber = scanner.nextLine();

        boolean found = false;
        for (Customer customer : customers) {
            if (customer.phoneNumber.equals(phoneNumber)) {
                System.out.println("Product Status for " + customer.name + ":");
                for (Automobile product : products) {
                    System.out.println(product.model);
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No customer found with the provided phone number.");
        }
    }

    public void viewAllProducts() {
        for (Automobile product : products) {
            System.out.println(product);
            System.out.println("------------------------------");
        }
    }

    public static void main(String[] args) {
        BMWPortal bmwPortal = new BMWPortal();

        // Adding example products
        bmwPortal.addProduct(new Car("BMW M5", 95000, 10.5, 600, 5, "Sedan"));
        bmwPortal.addProduct(new Bike("BMW S1000RR", 18000, 20, 1000, "Sport Bike"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("BMW Portal Menu:");
            System.out.println("1. Buy Product");
            System.out.println("2. Check Product Status");
            System.out.println("3. View All Products");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    bmwPortal.buyProduct();
                    break;
                case 2:
                    bmwPortal.checkProductStatus();
                    break;
                case 3:
                    bmwPortal.viewAllProducts();
                    break;
                case 4:
                    System.out.println("Exiting the BMW Portal.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}