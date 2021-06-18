package PACKAGE.PARKPASS.SYSTEM;

import PACKAGE.PARKPASS.ATTRACTIONS.Park;
import PACKAGE.PARKPASS.ATTRACTIONS.ParkSec;
import PACKAGE.PARKPASS.ATTRACTIONS.Ride;
import PACKAGE.PARKPASS.PEOPLE.Customer;

public class DriverP2 {

public static void main(String[] args) {

BigSystem sy = new BigSystem();
sy.setCurDate(20191112); //setting time
sy.setCurTime(800); //


sy.ScanInCustomers("CustomersTest.txt");
//all customers loaded in


//MainSystem.ScanInPark("SpringFling");

    Park testPark = new Park();
    testPark.setParkName("Spring Fling");
    ParkSec testSec1 = new ParkSec();
    testSec1.setNameofSec("Entrance Area");
    ParkSec testSec2 = new ParkSec();
    testSec2.setNameofSec("Big Rides I");
    ParkSec testSec3 = new ParkSec();
    testSec3.setNameofSec("BigRides II");
   
   
    ParkSystem TicketBooth = new ParkSystem();
    TicketBooth.setCurPark(testPark);
    //TicketBooth.set
   
   
    testPark.addArea(testSec1); //adds to section and the park
    testPark.addArea(testSec2); //adds to section and the park
    testPark.addArea(testSec3); //adds to section and the park
   
    //Ride(String name, Park bigpark, ParkSec parksection, boolean open, int durat, int numpeople, double cost, int mina, double minh)
    Ride Ride1 = new Ride("Decimator", testPark, testSec1, true, 15, 3, 6.50, 20, 0.0 );
    Ride Ride2 = new Ride("Something about Nintendo Switch", testPark, testSec2, true, 20, 6, 6.50, 10, 0.0 );
    Ride Ride3 = new Ride("Star Tours", testPark, testSec3, false, 30, 2, 6.50, 10, 0.0 );
    Ride Ride4 = new Ride("MonstorMashSmashCrashSlash", testPark, testSec3, true, 10, 10, 6.50, 10, 0.0 );
    //rides are all interconnected now
   
   
    //MANUAL
    sy.addRegisteredPark(testPark);
   
    for(int i = 0; i < sy.getRegisteredCustomers().size(); i=i+1) {
    testPark.enterPark(sy.getRegisteredCustomers().get(i) ); //adds customer to the park!!
    }
   
    TicketSingle t1 = new TicketSingle();
    t1.setRideTicket(Ride1);
   
    //create a new person
    Customer Jordan = new Customer();
    Jordan.setPersonNameF("jordan");
    Jordan.setPersonNameF("xeeb");
    Jordan.setPersonHeight(8.0);
    Jordan.setPersonAge(30);
   
    TicketBooth.enterCustomer(Jordan);
    TicketBooth.SystemIdlePark(sy);
   
    Jordan.getCard().QuickAddTicket(t1);
   
    Jordan.goOnRide(Ride1);
   
    sy.timeSkipFive();
    sy.timeSkipFive();
   
    sy.getRegisteredCustomers().get(1).getCard().QuickAddTicket(t1);
    sy.getRegisteredCustomers().get(0).getCard().QuickAddTicket(t1);
   
    sy.getRegisteredCustomers().get(1).goOnRide(Ride1);
    sy.getRegisteredCustomers().get(0).goOnRide(Ride1);
   
    sy.timeSkipFive();
    sy.timeSkipFive();
    sy.timeSkipFive();
    sy.timeSkipFive();


}
   
}