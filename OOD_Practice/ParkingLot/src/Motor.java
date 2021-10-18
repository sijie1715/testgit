public class Motor extends Vehicle {
	public Motor() {
		
	}
    public Motor(String vin) {
        this.vin = vin;
        this.type = CarType.MOTOR;
    }
}
