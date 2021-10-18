public class ParkingSpot {
    private final CarType type;
    private Vehicle curVehicle;

    ParkingSpot(CarType type) {
        this.type = type;
        this.curVehicle = null;
    }

    public boolean canPark(Vehicle v) {
        return curVehicle == null && v.getType() == this.type;
    }
    
    public boolean isEmpty() {
    	return this.curVehicle == null;
    }
    
    public String getVin() {
    	return this.curVehicle.vin;
    }

    public synchronized boolean goPark(Vehicle v) {
        if (canPark(v)) {
            curVehicle = v;
            return true;
        }
        return false;

    }

    public Vehicle leavePark() {
        if (curVehicle != null) {
            Vehicle v = curVehicle;
            curVehicle = null;
            return v;
        }
        throw new IllegalArgumentException("No vehicle is parked in this spot.");
    }
}
