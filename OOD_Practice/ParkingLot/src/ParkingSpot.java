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
        return null;
    }
}
