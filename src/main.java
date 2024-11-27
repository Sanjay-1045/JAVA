//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.time.LocalDateTime;

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
}

    class Berth
    {int rows;
        int cols;
        int isOccupied;
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
            {
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

                public void showBerths()
                {
                    System.out.println("Current Shipyard Layout:");
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            System.out.print(berths[i][j].isOccupied==1 ? "1 " : "0 ");
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

                Ship ship1 = new Ship(100,15,"SVL", LocalDateTime.parse("2024-10-27T00:00"), LocalDateTime.parse("2024-11-18T00:00"));
                Ship ship2 = new Ship(130,25,"ASW", LocalDateTime.parse("2024-11-07T00:00"), LocalDateTime.parse("2024-12-28T00:00"));

                layout.showBerths();
                layout.assignBerth(ship1); // Should assign a berth
                layout.showBerths();
                layout.assignBerth(ship2); // Should check availability
                layout.showBerths();
            }}