import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Passenger Plane Crashes Dataset Operations:");
        Scanner scanner = new Scanner(System.in);
        List<Flight> flights  = FileReader.readData();
        List<Flight> data = new ArrayList<>(flights);;
        List<Flight> output = null;
        boolean isColumnFunctionality = false;
        while (true) {
            System.out.println("1. List");
            System.out.println("2. Sort");
            System.out.println("3. Search");
            System.out.println("4. List Column Names");
            System.out.println("5. Filter");
            System.out.println("6. Exit");
            System.out.println("Enter choice: ");
            int input = scanner.nextInt();
            switch (input){
                case 1: output = ListFunctionality.listFunctionality(flights, scanner); break;
                case 2: output = SortFunctionality.sort(flights, scanner); break;
                case 3: output = SearchFunctionality.search(flights, scanner); break;
                case 4: ListFunctionality.listColumnNames(); isColumnFunctionality = true; break;
                case 5: output = FilterFunctionality.filter(flights, scanner); break;
                case 6: System.exit(0);
                default:
                    System.out.println("Wrong Input! Try Again");
            }
            if(!isColumnFunctionality) {
                System.out.println("Do you want to use the previous command input (y/n)");
                String userPrevious = scanner.next();
                if(userPrevious.equalsIgnoreCase("y")) {
                    flights = output;
                } else {
                    flights = data;
                }
            }
            isColumnFunctionality = false;
        }
    }
}
