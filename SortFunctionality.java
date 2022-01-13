import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SortFunctionality {

    public static List<Flight> sort(List<Flight> flights, Scanner scanner) {
        List<Flight> temporary = flights;
        System.out.println("Enter Field based on which you want to sort");
        String input = scanner.next();
        System.out.println("Please enter order of sorting i.e. ASC / DESC");
        String order = scanner.next();
        switch (input) {
            case "date":
                sortBasedOnColumn(temporary, order, Comparator.comparing(Flight::getDate));
                break;
            case "time":
                sortBasedOnColumn(temporary, order, Comparator.comparing(Flight::getTime));
                break;
            case "location":
                sortBasedOnColumn(temporary, order, Comparator.comparing(Flight::getLocation));
                break;
            case "operator":
                sortBasedOnColumn(temporary, order, Comparator.comparing(Flight::getOperator));
                break;
            case "flight":
                sortBasedOnColumn(temporary, order, Comparator.comparing(Flight::getFlight));
                break;
            case "route":
                sortBasedOnColumn(temporary, order, Comparator.comparing(Flight::getRoute));
                break;
            case "type":
                sortBasedOnColumn(temporary, order, Comparator.comparing(Flight::getType));
                break;
            case "registration":
                sortBasedOnColumn(temporary, order, Comparator.comparing(Flight::getRegistration));
                break;
            case "cnin":
                sortBasedOnColumn(temporary, order, Comparator.comparing(Flight::getCnIn));
                break;
            case "aboard":
                sortBasedOnColumn(temporary, order, Comparator.comparing(Flight::getAboard));
                break;
            case "fatalities":
                sortBasedOnColumn(temporary, order, Comparator.comparing(Flight::getFatalities));
                break;
            case "ground":
                sortBasedOnColumn(temporary, order, Comparator.comparing(Flight::getGround));
                break;
            case "survivors":
                sortBasedOnColumn(temporary, order, Comparator.comparing(Flight::getSurvivors));
                break;
            case "survivalrate":
                sortBasedOnColumn(temporary, order, Comparator.comparing(Flight::getSurvivalRate));
                break;
            case "summary":
                sortBasedOnColumn(temporary, order, Comparator.comparing(Flight::getSummary));
                break;
            case "clustid":
                sortBasedOnColumn(temporary, order, Comparator.comparing(Flight::getClustID));
                break;
            default:
                System.out.println("Invalid option!");
        }
        System.out.println("Please use list functionality to see the sorted flights");
        return temporary;
    }

    private static void sortBasedOnColumn(List<Flight> temporary, String order, Comparator<Flight> comparing) {
        Collections.sort(temporary, comparing);
        if (order.equalsIgnoreCase("DESC")) {
            Collections.reverse(temporary);
        }
    }
}
