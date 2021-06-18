package PACKAGE.PARKPASS.SYSTEM;

import PACKAGE.PARKPASS.ATTRACTIONS.Park;
import PACKAGE.PARKPASS.ATTRACTIONS.ParkSec;
import PACKAGE.PARKPASS.ATTRACTIONS.Ride;

public class DriverP1 {

	public static void main(String[] args) {
		
		BigSystem sy = new BigSystem();
		sy.setCurDate(20191112); //setting time
		sy.setCurTime(800); //
		
		
		sy.ScanInCustomers("CustomersTest.txt");
		//all customers loaded in
		

		//MainSystem.ScanInPark("SpringFling");
		
    	Park testPark = new Park();
    	testPark.setParkName("Jurassic Park");
    	ParkSec testSec1 = new ParkSec();
    	testSec1.setNameofSec("Entrance Walkway");
    	ParkSec testSec2 = new ParkSec();
    	testSec2.setNameofSec("Zaboomoofu Forest");
    	ParkSec testSec3 = new ParkSec();
    	testSec3.setNameofSec("Space Base");
    	
    	
    	ParkSystem TicketBooth = new ParkSystem();
    	TicketBooth.setCurPark(testPark);
    	//TicketBooth.set
    	
    	
    	testPark.addArea(testSec1); //adds to section and the park
    	testPark.addArea(testSec2); //adds to section and the park
    	testPark.addArea(testSec3); //adds to section and the park
    	
    	//Ride(String name, Park bigpark, ParkSec parksection, boolean open, int durat, int numpeople, double cost, int mina, double minh) 
    	Ride Ride1 = new Ride("Decimator", testPark, testSec1, true, 15, 3, 6.50, 20, 0.0 );
    	Ride Ride2 = new Ride("Hype", testPark, testSec2, true, 20, 6, 6.50, 10, 0.0 );
    	Ride Ride3 = new Ride("Big Z", testPark, testSec3, false, 10, 2, 6.50, 10, 0.0 );
    	Ride Ride4 = new Ride("RumpleRide", testPark, testSec3, true, 10, 10, 6.50, 10, 0.0 );
    	//rides are all interconnected now
    	
    	
    	//MANUAL
    	sy.addRegisteredPark(testPark);
    	
    	//Admit all people to park
    	for(int i = 0; i < sy.getRegisteredCustomers().size(); i=i+1) {
    		testPark.enterPark(sy.getRegisteredCustomers().get(i) ); //adds customer to the park!!
    	}
    	
    	//sy.getRegisteredCustomers().get(1).
    	
    	TicketSingle t1 = new TicketSingle();
    	t1.setRideTicket(Ride1);
    	sy.getRegisteredCustomers().get(1).getCard().QuickAddTicket(t1);
    	sy.getRegisteredCustomers().get(0).getCard().QuickAddTicket(t1);
    	
    	sy.getRegisteredCustomers().get(1).goOnRide(Ride1);
    	sy.getRegisteredCustomers().get(0).goOnRide(Ride1);
    	
    	TicketBooth.enterCustomer(sy.getRegisteredCustomers().get(3)); //person 3 gets added to the booth
    	TicketBooth.SystemIdlePark(sy);
    	
    	sy.timeSkipHour();
    	//Ride1.closeRide();
    	
    	sy.getRegisteredCustomers().get(1).PurchaseTicket(Ride1);
    	sy.getRegisteredCustomers().get(2).PurchaseTicket(Ride1);
    	sy.getRegisteredCustomers().get(5).PurchaseTicket(Ride1);
    	
	}
	
}
