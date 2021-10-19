import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Level[] levels;
    private Map<String, Integer> locatorMap;

    public ParkingLot(int n, int[][] config) {
        // config refers to vehicle type;
        levels = new Level[n];
        this.locatorMap = new HashMap<>();
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
                locatorMap.put(v.vin, i);
                return true;
            }
        }
        return false;
    }
    
    
    public int[] lookUp(String vin) {
    	int[] loc = new int[] {-1, -1};
    	if (locatorMap.containsKey(vin)) {
    		loc[0] = locatorMap.get(vin);
    		loc[1] = levels[loc[0]].lookUp(vin);
    		return loc;
    	}
    	
    	return loc;
    }
    
    public void leavePark(String vin) {
    	if (locatorMap.containsKey(vin)) {
    		levels[locatorMap.get(vin)].leavePark(vin);
    	} else {
    		throw new IllegalArgumentException("Vehicle not parked in this parking lot. ");
    	}
    }
    
    public void printMap() {
    	System.out.println("===== printing parking lot =====");
    	int height = this.levels.length;
    	for (int m = height - 1; m >= 0; m--) {
    		Level curLevel = this.levels[m];
    		curLevel.printLevel();
    	}
    }
}


