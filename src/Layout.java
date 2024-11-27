public class Layout {
    Berth[][] berths;
    int rows;
    int cols;
    public Layout(int rows, int cols, int len, int brd) {
        this.rows = rows;
        this.cols = cols;
        berths = new Berth[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                berths[i][j] = new Berth(i, j, len, brd);
            }
        }
    }
    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
    public void showBerths() {
        System.out.println("Current Shipyard Layout:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String berth = berths[i][j].isOccupied == 1 ? berths[i][j].shipName : "Not_Occuppied";
                System.out.print(padRight(berth, 20) + "|");
            }
            System.out.println();
        }
    }
    public int isExitBlocked(int currentRow, int currentColumn) {
        if (currentRow == 0)
            return 0;

        for (int i = currentRow - 1; i >= 0; i--) {
            if (berths[i][currentColumn].isOccupied == 1)
                return 1;
        }
        return 0;
    }
    public Berth availableBerth(Ship ship) {
        for (int i = rows-1; i >=0; i--) {
            for (int j = 0; j < cols; j++) {
                if (isExitBlocked(i, j) == 0) {
                    if (berths[i][j].canAccommodate(ship) == 1) {
                        return berths[i][j];
                    }
                }
            }
        }
        return null;
    }
    public void assignBerth(Ship ship) {
        Berth berthAvailable = availableBerth(ship);
        if (berthAvailable != null) {
            berthAvailable.isOccupied = 1;
            berthAvailable.occupiedUntil = ship.departure;
            berthAvailable.shipName = ship.name;
            System.out.printf("Ship %s assigned to Berth (%d, %d)", ship.name, berthAvailable.rows, berthAvailable.cols);
        } else {
            System.out.printf("No available berth for Ship %s.%n", ship.name);
        }
    }
}



