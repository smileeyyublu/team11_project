import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileReader {
    public static List<Flight> readData() {
        List<Flight> flights = new ArrayList<>();
        Path pathToFile = Paths.get("src/Large_Passenger_Plane_Crashes_1933_to_2009.csv");
        boolean header = true;
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.ISO_8859_1)) {
            String line = br.readLine();
            while (line != null) {
                if (header) {
                    header = false;
                    line = br.readLine();
                    continue;
                }
                String[] attributes = line.split(",");
                Flight flight = createFlight(attributes);
                flights.add(flight);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return flights;
    }

    private static Flight createFlight(String[] metadata) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
        LocalDate date = null;
        if (!Objects.equals(metadata[0], "")) {
            date = LocalDate.parse(metadata[0], formatter);
        }

        LocalTime time = null;
        if (!Objects.equals(metadata[1], "")) {
            if(metadata[1].length() == 4) {
                metadata[1] = "0" + metadata[1];
            }
            time = LocalTime.parse(metadata[1]);
        }

        String location = metadata[2];
        String operator = metadata[3];
        String flight = metadata[4];
        String route = metadata[5];
        String type = metadata[6];
        String registration = metadata[7];
        String cnIn = metadata[8];
        int aboard = 0;
        if (!Objects.equals(metadata[9], "")) {
            aboard = Integer.parseInt(metadata[9]);
        }
        int fatalities = 0;
        if (!Objects.equals(metadata[10], "")) {
            fatalities = Integer.parseInt(metadata[10]);
        }
        int ground = 0;
        if (!Objects.equals(metadata[11], "")) {
            ground = Integer.parseInt(metadata[11]);
        }
        int survivors = 0;
        if (!Objects.equals(metadata[12], "")) {
            survivors = Integer.parseInt(metadata[12]);
        }
        double survivalRate = 0;
        if (!Objects.equals(metadata[12], "")) {
            survivalRate = Double.parseDouble(metadata[13]);
        }
        String summary = metadata[14];
        String clustID = metadata[15];
        return new Flight(date, time, location, operator, flight, route, type, registration, cnIn, aboard, fatalities, ground, survivors, survivalRate, summary, clustID);
    }
}

