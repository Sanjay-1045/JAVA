import java.time.LocalDateTime;

public class Berth {
    int rows;
    int cols;
    int isOccupied;
    String shipName;
    int len;
    int brd;
    LocalDateTime occupiedUntil;

    public Berth(int rows, int cols, int len, int brd) {
        this.rows = rows;
        this.cols = cols;
        this.isOccupied = 0;
        this.len = len;
        this.brd = brd;
        this.occupiedUntil = null;
    }

    public int canAccommodate(Ship ship) {
        boolean isDateOld = false;
        if (occupiedUntil != null && occupiedUntil.isBefore(LocalDateTime.now())) {
            isDateOld = true;
        }
        if (isOccupied == 1 && isDateOld) isOccupied = 0;

        return (ship.length <= len && ship.breadth <= brd && isOccupied == 0) ? 1 : 0;

    }
}

