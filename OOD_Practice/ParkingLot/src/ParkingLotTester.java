public class ParkingLotTester {
    public static void main(String[] args) {

    	int numOfLevel = 3;
    	// [BUS][CAR][MOTOR]
    	int[][] config = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
    	ParkingLot pk1 = new ParkingLot(numOfLevel, config);
    	pk1.printMap();
    	
    	// park a bus
    	Bus bus1 = new Bus("b001");
    	pk1.goPark(bus1);
    	pk1.printMap();

    	// park a motor
    	Motor motor1 = new Motor("m001");
    	pk1.goPark(motor1);
    	pk1.printMap();
    	
    	// park 2 more motors
    	pk1.goPark(new Motor("m002"));
    	pk1.goPark(new Motor("m003"));
    	pk1.printMap();
    	// print motor3 location
    	int[] loc = pk1.lookUp("m003");
    	System.out.println("m003 position: " + loc[0] + ", " + loc[1]);
    	
    	// motor2 leave parking lot
    	pk1.leavePark("m002");
    	pk1.printMap();
    }
}
