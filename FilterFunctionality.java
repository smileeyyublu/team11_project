import java.beans.PropertyDescriptor;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FilterFunctionality {
    public static List<Flight> filter(List<Flight> flights, Scanner scanner) {
        List<Operation> operations = new ArrayList<>();
        while (true) {
            Operation operation = new Operation();
            System.out.println("Enter the field name on which you want to filter: ");
            String field = scanner.next();
            operation.setField(field);
            boolean isBetween = false;
            System.out.println("Select operation type for " + field + ": ");
            if (field.equalsIgnoreCase("date")) {
                System.out.println("1. In specific year");
                System.out.println("2. In specific month");
                System.out.println("3. in specific day");
                int c = scanner.nextInt();
                switch (c) {
                    case 1:
                        operation.setOperation("year"); break;
                    case 2:
                        operation.setOperation("month"); break;
                    case 3:
                        operation.setOperation("day"); break;
                }
            } else if (field.equalsIgnoreCase("aboard") || field.equalsIgnoreCase("fatalities") || field.equalsIgnoreCase("ground") || field.equalsIgnoreCase("survivors") || field.equalsIgnoreCase("survivalrate")) {
                System.out.println("1. equals (eq)");
                System.out.println("2. greater than (gt)");
                System.out.println("3. less than (lt)");
                System.out.println("4. greater than and equal to (ge)");
                System.out.println("5. less than and equal to (le)");
                System.out.println("6. between (bt)");
                System.out.println("7. null");
                int c = scanner.nextInt();
                switch (c) {
                    case 1:
                        operation.setOperation("eq"); break;
                    case 2:
                        operation.setOperation("gt"); break;
                    case 3:
                        operation.setOperation("lt"); break;
                    case 4:
                        operation.setOperation("ge"); break;
                    case 5:
                        operation.setOperation("le"); break;
                    case 6:
                        operation.setOperation("bt"); isBetween = true; break;
                    case 7:
                        operation.setOperation("null"); break;
                }
            } else {
                System.out.println("1. startsWith");
                System.out.println("2. endsWith");
                System.out.println("3. contains");
                System.out.println("4. null");
                int c = scanner.nextInt();
                switch (c) {
                    case 1:
                        operation.setOperation("startsWith");
                        break;
                    case 2:
                        operation.setOperation("endsWith");
                        break;
                    case 3:
                        operation.setOperation("contains");
                        break;
                    case 4:
                        operation.setOperation("null");
                        break;
                }
            }
            if(isBetween) {
                System.out.println("Enter start range: ");
                int start = scanner.nextInt();
                System.out.println("Enter end range: ");
                int end = scanner.nextInt();
                operation.setStartRange(start);
                operation.setEndRange(end);
                isBetween = false;
            } else {
                System.out.println("Enter the search data accordingly: ");
                scanner.nextLine();
                String searchData = scanner.nextLine();
                operation.setData(searchData);
            }
            operations.add(operation);
            System.out.println("Do you want to add more filters? (y/n)");
            String input = scanner.next();
            if (input.equalsIgnoreCase("n")) break;
        }
        List<Flight> filtered = flights;
        for (Operation operation : operations) {
            String field = operation.getField();
            if (field.equalsIgnoreCase("date") || field.equalsIgnoreCase("time")) {
                filtered = dateOperation(filtered, operation);
            } else if (field.equalsIgnoreCase("aboard") || field.equalsIgnoreCase("fatalities") || field.equalsIgnoreCase("ground") || field.equalsIgnoreCase("survivors") || field.equalsIgnoreCase("survivalrate")) {
                 filtered = numericOperation(filtered, operation);
            } else {
                filtered = stringOperation(filtered, operation);
            }

        }
        return filtered;
    }

    public static List<Flight> numericOperation(List<Flight> flights, Operation operation) {
        List<Flight> filtered = new ArrayList<>();
        try {
            for (Flight flight : flights) {
                Double data;
                if(!operation.getField().equals("survivalrate")) {
                    Integer temp = (Integer) new PropertyDescriptor(operation.getField(), Flight.class).getReadMethod().invoke(flight);
                    data = Double.parseDouble(String.valueOf(temp));
                } else {
                    data = (Double) new PropertyDescriptor(operation.getField(), Flight.class).getReadMethod().invoke(flight);
                }

                if (operation.getOperation().equals("eq")) {
                    if ((data == Double.parseDouble(operation.getData()))) {
                        filtered.add(flight);
                    }
                }
                if (operation.getOperation().equals("gt")) {
                    if ((data > Double.parseDouble(operation.getData()))) {
                        filtered.add(flight);
                    }
                }
                if (operation.getOperation().equals("lt")) {
                    if ((data < Double.parseDouble(operation.getData()))) {
                        filtered.add(flight);
                    }
                }
                if (operation.getOperation().equals("ge")) {
                    if ((data >= Double.parseDouble(operation.getData()))) {
                        filtered.add(flight);
                    }
                }
                if (operation.getOperation().equals("le")) {
                    if ((data <= Double.parseDouble(operation.getData()))) {
                        filtered.add(flight);
                    }
                }
                if (operation.getOperation().equals("bt")) {
                    if ((data >= Double.parseDouble(String.valueOf(operation.getStartRange())) && data <= Double.parseDouble(String.valueOf(operation.getEndRange())))) {
                        filtered.add(flight);
                    }
                }
                if (operation.getOperation().equals("null")) {
                    if (Objects.isNull(data)) {
                        filtered.add(flight);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong! Try Again");
        }
        return filtered;
    }

    public static List<Flight> stringOperation(List<Flight> flights, Operation operation) {
        List<Flight> filtered = new ArrayList<>();
        try {
            for (Flight flight : flights) {
                String data = (String) new PropertyDescriptor(operation.getField(), Flight.class).getReadMethod().invoke(flight);
                if (operation.getOperation().equals("startsWith")) {
                    if (data.toLowerCase().startsWith(operation.getData().toLowerCase())) {
                        filtered.add(flight);
                    }
                }
                if (operation.getOperation().equals("endsWith")) {
                    if (data.toLowerCase().endsWith(operation.getData().toLowerCase())) {
                        filtered.add(flight);
                    }
                }
                if (operation.getOperation().equals("contains")) {
                    if (data.toLowerCase().contains(operation.getData().toLowerCase())) {
                        filtered.add(flight);
                    }
                }
                if (operation.getOperation().equals("null")) {
                    if (data.isEmpty()) {
                        filtered.add(flight);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong! Try Again");
        }
        return filtered;
    }

    public static List<Flight> dateOperation(List<Flight> flights, Operation operation) {
        List<Flight> filtered = new ArrayList<>();
        try {
            for (Flight flight : flights) {
                LocalDate data = (LocalDate) new PropertyDescriptor(operation.getField(), Flight.class).getReadMethod().invoke(flight);
                if (operation.getOperation().equals("year")) {
                   if(data.getYear() == Integer.parseInt(operation.getData())) {
                       filtered.add(flight);
                   }
                }
                if (operation.getOperation().equals("month")) {
                    if(data.getMonth() == Month.valueOf(operation.getData())) {
                        filtered.add(flight);
                    }
                }
                if (operation.getOperation().equals("day")) {
                    if(data.getDayOfMonth() == Integer.parseInt(operation.getData())) {
                        filtered.add(flight);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong! Try Again");
        }
        return filtered;
    }
}
