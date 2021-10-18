import java.util.HashMap;
import java.util.Map;

public class Level {

    private final int levelId;
    
    public int getLevelId() {
		return levelId;
	}

	private ParkingSpot[] spots;
    private Map<String, Integer> locatorMap;

    public Level(int id, int busSpots, int carSpots, int motorSpots) {
        levelId = id;
        this.locatorMap = new HashMap<>();
        spots = new ParkingSpot[busSpots + carSpots + motorSpots];
        for (int ib = 0; ib < busSpots; ib++) spots[ib] = new ParkingSpot(CarType.BUS);
        for (int ic = busSpots; ic < busSpots + carSpots; ic++) spots[ic] = new ParkingSpot(CarType.CAR);
        for (int im = busSpots + carSpots; im < busSpots + carSpots + motorSpots; im++) spots[im] = new ParkingSpot(CarType.MOTOR);

    }
    
    public int getLevelSize() {
    	return this.spots.length;
    }

    public boolean canPark(Vehicle v) {

        for (int i = 0; i < spots.length; i++) {
            if (spots[i].canPark(v)) return true;
        }
        return false;
    }

    public boolean goPark(Vehicle v) {
        if (!canPark(v)) return false;
        for (int i = 0; i < spots.length; i++) {
            ParkingSpot s = spots[i];
            if (s.canPark(v)) {
                s.goPark(v);
                locatorMap.put(v.vin, i);
                return true;
            }
        }
        return false;
    }
    
    public int lookUp(String vin) {
    	if (locatorMap.containsKey(vin) ) {
    		return locatorMap.get(vin);
    	}
    	return -1;
    }
    
    public void printLevel() {
    	for (int i = 0; i < spots.length; i++) {
    		System.out.print(spots[i].isEmpty() ? "[    ]" : "[" + spots[i].getVin() + "]");
    	}
    	System.out.println();
    }
}
