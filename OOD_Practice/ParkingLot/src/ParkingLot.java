import java.util.Map;

public class ParkingLot {
    private final Level[] levels;
    private Map<String, Integer> parkLevel;

    public ParkingLot(int n, int[][] config) {
        // config refers to vehicle type;
        levels = new Level[n];
        for (int i = 0; i < n; i++) {
            levels[i] = new Level(i, config[i][0], config[i][1], config[i][2]);
        }
    }

    public boolean canPark(Vehicle v) {
        for (Level l : levels) {
            if (l.canPark(v)) return true;
        }
        return false;
    }

    public boolean goPark(Vehicle v) {
        if (!canPark(v)) return false;
        for (int i = 0; i < levels.length; i++) {
            Level l = levels[i];
            if (l.canPark(v)) {
                l.goPark(v);
                parkLevel.put(v.vin, i);
                return true;
            }
        }
        return false;
    }
}


