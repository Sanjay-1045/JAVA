import java.time.LocalDateTime;
import java.util.Scanner;

public class ShipyardManager {
    public static void main(String[] args) {

        Layout layout = new Layout(2, 3, 150, 30);

        Scanner scanner = new Scanner(System.in);
        int k = 0;
        while (true) {

            Ship ship = new Ship();
            System.out.printf("Enter length of Ship %d: ", k + 1);
            int length = scanner.nextInt();
            ship.length = length;

            System.out.printf("Enter breadth of Ship %d: ", k + 1);
            int breadth = scanner.nextInt();
            scanner.nextLine();
            ship.breadth = breadth;

            System.out.printf("Enter name of Ship %d: ", k + 1);
            String name = scanner.nextLine();
            ship.name = name;

            System.out.printf("Enter arrival date of Ship %d (format: yyyy-MM-dd HH:mm): ", k + 1);
            String arrivalInput = scanner.nextLine();
            LocalDateTime arrival = LocalDateTime.parse(arrivalInput);
            ship.arrival = arrival;

            System.out.printf("Enter departure date of Ship %d (format: yyyy-MM-dd HH:mm): ", k + 1);
            String departureInput = scanner.nextLine();
            LocalDateTime departure = LocalDateTime.parse(departureInput);
            ship.departure = departure;

            layout.assignBerth(ship);
            System.out.printf("Do you want to continue?Y/N");
            k++;
            String response = scanner.next();
            if (response.equalsIgnoreCase("N")) break;
        }

        layout.showBerths();

    }
}