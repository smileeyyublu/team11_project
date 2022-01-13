import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
    private LocalDate date;
    private LocalTime time;
    private String location;
    private String operator;
    private String flight;
    private String route;
    private String type;
    private String registration;
    private String cnIn;
    private int aboard;
    private int fatalities;
    private int ground;
    private int survivors;
    private double survivalRate;
    private String summary;
    private String clustID;

    public Flight(LocalDate date, LocalTime time,
                  String location, String operator, String flight,
                  String route, String type, String registration, String cnIn,
                  int aboard, int fatalities, int ground, int survivors,
                  double survivalRate, String summary, String clustID) {
        this.date = date;
        this.time = time;
        this.location = location;
        this.operator = operator;
        this.flight = flight;
        this.route = route;
        this.type = type;
        this.registration = registration;
        this.cnIn = cnIn;
        this.aboard = aboard;
        this.fatalities = fatalities;
        this.ground = ground;
        this.survivors = survivors;
        this.survivalRate = survivalRate;
        this.summary = summary;
        this.clustID = clustID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getCnIn() {
        return cnIn;
    }

    public void setCnIn(String cnIn) {
        this.cnIn = cnIn;
    }

    public int getAboard() {
        return aboard;
    }

    public void setAboard(int aboard) {
        this.aboard = aboard;
    }

    public int getFatalities() {
        return fatalities;
    }

    public void setFatalities(int fatalities) {
        this.fatalities = fatalities;
    }

    public int getGround() {
        return ground;
    }

    public void setGround(int ground) {
        this.ground = ground;
    }

    public int getSurvivors() {
        return survivors;
    }

    public void setSurvivors(int survivors) {
        this.survivors = survivors;
    }

    public double getSurvivalRate() {
        return survivalRate;
    }

    public void setSurvivalRate(double survivalRate) {
        this.survivalRate = survivalRate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getClustID() {
        return clustID;
    }

    public void setClustID(String clustID) {
        this.clustID = clustID;
    }

    @Override
    public String toString() {
        return "date=" + date +
                ", time=" + time +
                ", location='" + location + '\'' +
                ", operator='" + operator + '\'' +
                ", flight='" + flight + '\'' +
                ", route='" + route + '\'' +
                ", type='" + type + '\'' +
                ", registration='" + registration + '\'' +
                ", cnIn='" + cnIn + '\'' +
                ", aboard=" + aboard +
                ", fatalities=" + fatalities +
                ", ground=" + ground +
                ", survivors=" + survivors +
                ", survivalRate=" + survivalRate +
                ", summary='" + summary + '\'' +
                ", clustID='" + clustID;
    }
}
