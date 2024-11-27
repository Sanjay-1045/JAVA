//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.time.LocalDateTime;
import java.util.Scanner;


class Ship {
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

    class Berth
    {int rows;
        int cols;
        int isOccupied;
        String shipName;
        int len;
        int brd;
        LocalDateTime occupiedUntil;

        public Berth(int rows,int cols,int len,int brd)
        {this.rows=rows;
            this.cols=cols;
            this.isOccupied=0;
            this.len=len;
            this.brd=brd;
            this.occupiedUntil=null;}

            public int canAccommodate(Ship ship)
            {boolean isDateOld=false;
                if(occupiedUntil!=null && occupiedUntil.isBefore(LocalDateTime.now()))
                {
                    isDateOld=true;
                }
                if(isOccupied==1 && isDateOld)
                    isOccupied=0;

            return (ship.length <= len && ship.breadth <= brd && isOccupied == 0) ? 1 : 0;

        }
    }
        class Layout
        {
            Berth[][] berths;
            int rows;
            int cols;

            public Layout(int rows, int cols, int len, int brd) {
                this.rows=rows;
                this.cols=cols;
                berths=new Berth[rows][cols];
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        berths[i][j] = new Berth(i, j, len, brd);
                    }

                }}
            public static String padRight(String s, int n) {
                return String.format("%-" + n + "s", s);}
                public void showBerths()
                {
                    System.out.println("Current Shipyard Layout:");
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            String berth=berths[i][j].isOccupied==1 ? berths[i][j].shipName : "Not_Occuppied";
                            System.out.print(padRight(berth,20)+"|");
                        }
                        System.out.println();
                    }
                }
                public int isExitBlocked()
                {
                {for (int j = 0; j < cols; j++) {
                    if (berths[rows- 1][j].isOccupied == 1)
                        return 1;


                }}
                    return 0;}


                public Berth availableBerth (Ship ship)
                {
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            if (isExitBlocked() == 0) {
                                if (berths[i][j].canAccommodate(ship) == 1) {
                                    return berths[i][j];
                                }
                            }
                        }
                    }
                    return null;
                }

                public void assignBerth (Ship ship){
                    Berth berthAvailable = availableBerth(ship);
                    if (berthAvailable!=null) {
                        berthAvailable.isOccupied = 1;
                        berthAvailable.occupiedUntil = ship.departure;
                        berthAvailable.shipName=ship.name;
                        System.out.printf("Ship %s assigned to Berth (%d, %d)", ship.name, berthAvailable.rows, berthAvailable.cols);
                    } else {
                        System.out.printf("No available berth for Ship %s.%n", ship.name);
                    }
                }
            }


        class Main{
            public static void main(String[] args) {
                //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
                // to see how IntelliJ IDEA suggests fixing it.
                Layout layout= new Layout(2,3,150,30);

                Scanner scanner = new Scanner(System.in);
                int k=0;
                while(true) {

                    Ship ship=new Ship();
                    System.out.printf("Enter length of Ship %d: ", k + 1);
                    int length = scanner.nextInt();
                    ship.length=length;

                    System.out.printf("Enter breadth of Ship %d: ", k + 1);
                   int breadth = scanner.nextInt();
                    scanner.nextLine();
                    ship.breadth=breadth;

                    System.out.printf("Enter name of Ship %d: ", k + 1);
                    String name = scanner.nextLine();
                    ship.name=name;

                    System.out.printf("Enter arrival date of Ship %d (format: yyyy-MM-dd HH:mm): ", k + 1);
                    String arrivalInput = scanner.nextLine();
                    LocalDateTime arrival = LocalDateTime.parse(arrivalInput);
                    ship.arrival=arrival;

                    System.out.printf("Enter departure date of Ship %d (format: yyyy-MM-dd HH:mm): ", k + 1);
                    String departureInput = scanner.nextLine();
                    LocalDateTime departure = LocalDateTime.parse(departureInput);
                    ship.departure=departure;

                    layout.assignBerth(ship);
                    System.out.printf("Do you want to continue?Y/N");
                    k++;
                    String response=scanner.next();
                    if(response.equalsIgnoreCase("N"))
                    break;
                }

                layout.showBerths();

            }}