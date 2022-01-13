import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListFunctionality {

    public static List<Flight> listFunctionality(List<Flight> flights, Scanner scanner) {
        System.out.println("1. List all the fields of each entity");
        System.out.println("2. Only Selected fields of each entity");
        System.out.println("3. List entities based on range");
        int input = scanner.nextInt();

        switch (input) {
            case 1:
                return listAllFields(flights);
            case 2:
                return listOnlySelectFields(flights, scanner);
            case 3:
                return listFlightBasedOnRange(flights, scanner);
        }
        return flights;
    }

    public static List<Flight> listAllFields(List<Flight> flights) {
        for (Flight flight : flights) {
            System.out.println(flight);
        }
        System.out.println("Number of flights shown: " + flights.size());
        return flights;
    }

    public static List<Flight> listFlightBasedOnRange(List<Flight> flights, Scanner scanner) {
        List<Flight> rangedFlights = new ArrayList<>();
        while (true) {
            System.out.println("Enter start range");
            int start = scanner.nextInt();
            System.out.println("Enter end range");
            int end = scanner.nextInt();
            if (start < 0) {
                System.out.println("Invalid start range");
                continue;
            }
            if (end > flights.size()) {
                System.out.println("Invalid end range");
                continue;
            }
            for (int i = start - 1; i < end; i++) {
                rangedFlights.add(flights.get(i));
                System.out.println(flights.get(i));
            }
            return rangedFlights;
        }
    }

    public static List<Flight> listOnlySelectFields(List<Flight> flights, Scanner scanner) {
        System.out.println("Enter fields name separated by space. Wrong field name will be ignored (ALL SMALL CASE)");
        scanner.nextLine();
        String input = scanner.nextLine();
        input = input.toLowerCase();
        for (Flight flight : flights) {
            if (input.contains("date")) {
                System.out.print(flight.getDate() + " ");
            }
            if (input.contains("time")) {
                System.out.print(flight.getTime() + " ");
            }
            if (input.contains("location")) {
                System.out.print(flight.getLocation() + " ");
            }
            if (input.contains("operator")) {
                System.out.print(flight.getOperator() + " ");
            }
            if (input.contains("flight")) {
                System.out.print(flight.getFlight() + " ");
            }
            if (input.contains("route")) {
                System.out.print(flight.getRoute() + " ");
            }
            if (input.contains("type")) {
                System.out.print(flight.getType() + " ");
            }
            if (input.contains("registration")) {
                System.out.print(flight.getRegistration() + " ");
            }
            if (input.contains("cnin")) {
                System.out.print(flight.getCnIn() + " ");
            }
            if (input.contains("aboard")) {
                System.out.print(flight.getAboard() + " ");
            }
            if (input.contains("fatalities")) {
                System.out.print(flight.getFatalities() + " ");
            }
            if (input.contains("ground")) {
                System.out.print(flight.getGround() + " ");
            }
            if (input.contains("survivors")) {
                System.out.print(flight.getSurvivors() + " ");
            }
            if (input.contains("summary")) {
                System.out.print(flight.getSummary() + " ");
            }
            if (input.contains("clustid")) {
                System.out.print(flight.getClustID() + " ");
            }
            System.out.println();
        }
        System.out.println("Number of flights shown: " + flights.size());
        return  flights;
    }

    public static void listColumnNames() {
        System.out.println("Date, Time, Location, Operator, Flight, Route, Type, Registration, cnIn, Aboard, Fatalities, Ground, Survivors, SurvivalRate, Summary, ClustID");
    }
}
