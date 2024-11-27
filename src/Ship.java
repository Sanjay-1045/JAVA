import java.time.LocalDateTime;

public class Ship {
    int length;
    int breadth;
    String name;
    LocalDateTime arrival;
    LocalDateTime departure;
    public Ship(int length, int breadth, String name, LocalDateTime arrival, LocalDateTime departure) {
        this.length = length;
        this.breadth = breadth;
        this.name = name;
        this.arrival = arrival;
        this.departure = departure;
    }
    public Ship() {
    }
}

