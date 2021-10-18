public class Bus extends Vehicle {
	public Bus() {
		
	}
    public Bus(String vin) {
        this.vin = vin;
        this.type = CarType.BUS;
    }
}
