import java.util.ArrayList;
import java.util.Scanner;

public class VehicleManagement {
    private ArrayList<Vehicle> vehicleList;
    private Scanner scanner;

    public VehicleManagement() {
        vehicleList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addVehicle() {
        System.out.print("Enter registration number: ");
        String regNo = scanner.nextLine();
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter year of manufacture: ");
        int yearOfManufacture = scanner.nextInt();
        System.out.print("Enter value: ");
        double value = scanner.nextDouble();
        scanner.nextLine(); 

        Vehicle vehicle = new Vehicle(regNo, make, yearOfManufacture, value);
        vehicleList.add(vehicle);
        System.out.println("Vehicle added successfully!");
    }

    public void displayVehicleList() {
        System.out.println("List of vehicle details:");
        for (Vehicle vehicle : vehicleList) {
            System.out.println(vehicle);
        }
    }

    public void deleteVehicle() {
        System.out.print("Enter the index of the vehicle to delete:");
        int index = scanner.nextInt();
        scanner.nextLine(); 

        if (index >= 0 && index < vehicleList.size()) {
            vehicleList.remove(index);
            System.out.println("Vehicle deleted successfully!");
        } else {
            System.out.println("Invalid index. Please try again.");
        }
    }

    public void sortVehicleListByAge() {
        for (int i = 0; i < vehicleList.size() - 1; i++) {
            for (int j = 0; j < vehicleList.size() - i - 1; j++) {
                if (vehicleList.get(j).calculateAge(2024) > vehicleList.get(j + 1).calculateAge(2024)) {
                    Vehicle temp = vehicleList.get(j);
                    vehicleList.set(j, vehicleList.get(j + 1));
                    vehicleList.set(j + 1, temp);
                }
            }
        }
    }

    public void run() {
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add a vehicle");
            System.out.println("2. Display a list of vehicle details");
            System.out.println("3. Delete a vehicle");
            System.out.println("4. Sort vehicle list by age");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    displayVehicleList();
                    break;
                case 3:
                    deleteVehicle();
                    break;
                case 4:
                    sortVehicleListByAge();
                    displaySortMenu();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close(); 
    }

    public void displaySortMenu() {
        int sortChoice;
        do {
            System.out.println("\nSort Menu:");
            System.out.println("1. Sort by age (ascending)");
            System.out.println("2. Sort by age (descending)");
            System.out.println("3. Back to main menu");
            System.out.print("Enter your choice: ");
            sortChoice = scanner.nextInt();
            scanner.nextLine(); 

            switch (sortChoice) {
            case 1:
                sortVehicleListByAge();
                System.out.println("List of vehicle details sorted by age (ascending):");
                for (int i = vehicleList.size() - 1; i >= 0; i--) {
                    System.out.println(vehicleList.get(i));
                }
                break;
      
            case 2:
                sortVehicleListByAge();
                System.out.println("List of vehicle details sorted by age (descending):");
                displayVehicleList();
                break;
            case 3:
                System.out.println("Returning to main menu...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } while (sortChoice != 3);
}
            
    }