package PACKAGE.PARKPASS.ATTRACTIONS;

import java.util.ArrayList; 

import PACKAGE.PARKPASS.PEOPLE.Customer;

public class Ride extends Attraction{

	public Ride() {
		AttName = "unknown";
    	belongstoPark = new Park();
    	inParkSec = new ParkSec();
    	isOpen = false;
    	duration = 0;
    	maxInAttraction = 0;
    	singleTicketCost = 0.0;
    	inAttraction = new ArrayList<Customer>();
    	inQueue = new ArrayList<Customer>();
    	
		ageRequirement = 0;
		heightRequirement = 0;
	}
	
	public Ride(String a, Park b, ParkSec c, boolean d, int e, int f, double g, int h, double i) {
		AttName = a;
    	belongstoPark = b;
    	b.addAttraction(this);
    	inParkSec = c;
    	c.addSecAttractions(this);
    	isOpen = d;
    	duration = e;
    	maxInAttraction = f;
    	singleTicketCost = g;
    	inAttraction = new ArrayList<Customer>();
    	inQueue = new ArrayList<Customer>();
    	
		ageRequirement = h;
		heightRequirement = i;
	}
   
}
