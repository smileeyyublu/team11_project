import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class SearchFunctionality {

    public static List<Flight> search(List<Flight> flights, Scanner scanner) {
        List<Flight> output = new ArrayList<>();
        System.out.println("Enter the field you want to search on: ");
        String field = scanner.next();
        System.out.println("Enter the search text: ");
        String searchText = scanner.next();
        try {
            performOperation(flights, output, field, searchText);
        } catch (Exception e) {
            System.out.println("Invalid data provided!");
            return flights;
        }
        System.out.println("Use List functionality to see the searched data");
        return output;

    }

    private static void performOperation(List<Flight> flights, List<Flight> output, String field, String searchText) {
        field =field.toLowerCase(Locale.ROOT);
        switch (field) {
            case "date":
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
                LocalDate date = LocalDate.parse(searchText, formatter);
                for (Flight flight : flights) {
                    if (flight.getDate().isEqual(date)) {
                        output.add(flight);
                    }
                }
                break;
            case "time":
                LocalTime time = LocalTime.parse(searchText);
                for (Flight flight : flights) {
                    if (flight.getTime().equals(time)) {
                        output.add(flight);
                    }
                }
                break;
            case "location":
                for (Flight flight : flights) {
                    if (flight.getLocation().contains(searchText)) {
                        output.add(flight);
                    }
                }
                break;
            case "operator":
                for (Flight flight : flights) {
                    if (flight.getOperator().contains(searchText)) {
                        output.add(flight);
                    }
                }
                break;
            case "flight":
                for (Flight flight : flights) {
                    if (flight.getFlight().contains(searchText)) {
                        output.add(flight);
                    }
                }
                break;
            case "route":
                for (Flight flight : flights) {
                    if (flight.getRoute().contains(searchText)) {
                        output.add(flight);
                    }
                }
                break;
            case "type":
                for (Flight flight : flights) {
                    if (flight.getType().contains(searchText)) {
                        output.add(flight);
                    }
                }
                break;
            case "registration":
                for (Flight flight : flights) {
                    if (flight.getRegistration().contains(searchText)) {
                        output.add(flight);
                    }
                }
                break;
            case "cnin":
                for (Flight flight : flights) {
                    if (flight.getCnIn().contains(searchText)) {
                        output.add(flight);
                    }
                }
                break;
            case "aboard":
                for (Flight flight : flights) {
                    if (flight.getAboard() == Integer.parseInt(searchText)) {
                        output.add(flight);
                    }
                }
                break;
            case "fatalities":
                for (Flight flight : flights) {
                    if (flight.getFatalities() == Integer.parseInt(searchText)) {
                        output.add(flight);
                    }
                }
                break;
            case "ground":
                for (Flight flight : flights) {
                    if (flight.getGround() == Integer.parseInt(searchText)) {
                        output.add(flight);
                    }
                }
                break;
            case "survivors":
                for (Flight flight : flights) {
                    if (flight.getSurvivors() == Integer.parseInt(searchText)) {
                        output.add(flight);
                    }
                }
                break;
            case "survivalrate":
                for (Flight flight : flights) {
                    if (flight.getSurvivalRate() == Double.parseDouble(searchText)) {
                        output.add(flight);
                    }
                }
                break;
            case "summary":
                for (Flight flight : flights) {
                    if (flight.getSummary().contains(searchText)) {
                        output.add(flight);
                    }
                }
                break;
            case "clustid":
                for (Flight flight : flights) {
                    if (flight.getClustID().contains(searchText)) {
                        output.add(flight);
                    }
                }
                break;
            default:
                System.out.println("Invalid option!");
        }
    }
}
