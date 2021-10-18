public class Car extends Vehicle {
	public Car() {
		
	}
    public Car(String vin) {
        this.vin = vin;
        this.type = CarType.CAR;
    }
}
