package PACKAGE.PARKPASS.ATTRACTIONS;

import java.util.ArrayList; 
import PACKAGE.PARKPASS.PEOPLE.Customer;
 
public class Park {
	private String ParkName;
	private String ParkDescription;
	private double ParkEntranceCost; 
	private double ParkPassCost;
    private double TotalProfits;
    private int Hours[] = {700, 1700};		//first is open time and second is close time
    private ArrayList<ParkSec> ParkAreas;
    private ArrayList<Attraction> ParkAttractions;
    private ArrayList<Customer> AllCustomers;
    private ArrayList<FoodVendor> AllRestaurants;
    private ArrayList<Attraction> AllRides;
    private ArrayList<Events> AllEvents;
 
    public Park(){
    	ParkName = "none";
    	ParkDescription = "none";
    	ParkPassCost = 0.0;
    	TotalProfits = 0.0;
    	ParkAreas = new ArrayList<ParkSec>();
    	ParkAttractions = new ArrayList<Attraction>();
    	AllCustomers = new ArrayList<Customer>();
        AllRestaurants = new ArrayList<FoodVendor>();
        AllRides = new ArrayList<Attraction>();
        AllEvents = new ArrayList<Events>();
    }
    
    
    public boolean isParkOpen(int curTime) {
    	if(Hours[0] <= curTime && Hours[1] > curTime) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    
    public void enterPark(Customer cust) {
    	AllCustomers.add(cust);
    	System.out.println(" - Customer " +cust.getPersonNameF() +" has entered "+ this.getParkName() );
    	this.getArea().get(0).addCentralPath(cust); //adds people to the first area of park
    	cust.setCurPark(this);
    	cust.setCurParkSec(this.getArea().get(0) );	
    }
    
    public void exitPark(Customer cust, Park a, ParkSec b) { //a and b are away and away sec always!!!!
    	if (isInCustomers(cust) == true) {
    		AllCustomers.remove(cust);
    		cust.setCurPark(a);
    		cust.setCurParkSec(b);
    		System.out.println(" - Customer " +cust.getPersonNameF() +" has exited "+ this.getParkName() );
    	}
    }
    public void addToProfits(double prof) {
    	TotalProfits = TotalProfits + prof;
    }
    
    public double getProfits() {
    	return TotalProfits;
    }
    
    public void addArea(ParkSec sec) {    	
    	ParkAreas.add(sec);
    	sec.setPartOfPark(this);
    	System.out.println("* Section " + sec.getNameofSec() +" was added to " + this.getParkName() );
    }
    
    public void removeArea(ParkSec sec) {
    	if (isInArea(sec) == true) {
    		ParkAreas.remove(sec);
    	}
    }
    
    public ArrayList<ParkSec> getArea() {
    	return ParkAreas;
    }
    
    public boolean isInArea(ParkSec sec) {
		for (int i = 0; i < ParkAreas.size(); i++) {
			if (ParkAreas.get(i) == sec) {
				return true;
			}
		}
    	return false;
    }
    
    public void addAttraction(Attraction att) {
    	ParkAttractions.add(att);
    	System.out.println("* Attraction " +att.getAttName() + " was added to " + this.getParkName() );
    }
    
    public void removeAttraction(Attraction att) {
    	if (isInAttractions(att) == true) {
    		ParkAttractions.remove(att);
    		System.out.println(att.getAttName() + " was removed from " + this.getParkName() );
    	}	
    }
    
    public ArrayList<Attraction> getAttractions() {
    	return ParkAttractions;
    }
    
    public boolean isInAttractions(Attraction att) {
		for (int i = 0; i < ParkAttractions.size(); i++) {
			if (ParkAttractions.get(i) == att) {
				return true;
			}
		}
    	return false;
    }
    
   
    
    public ArrayList<Customer> getCustomers() {
    	return AllCustomers;
    }
    
    public boolean isInCustomers(Customer cust) {
		for (int i = 0; i < AllCustomers.size(); i++) {
			if (AllCustomers.get(i) == cust) {
				return true;
			}
		}
    	return false;
    }

	public String getParkName() {
		return ParkName;
	}

	public void setParkName(String parkName) {
		ParkName = parkName;
	}

	public String getParkDescription() {
		return ParkDescription;
	}

	public void setParkDescription(String parkDescription) {
		ParkDescription = parkDescription;
	}

	public double getParkPassCost() {
		return ParkPassCost;
	}

	public void setParkPassCost(double parkPassCost) {
		ParkPassCost = parkPassCost;
	}
    
	public ArrayList<Attraction> getAllRides() {
		for (int a = 0; a < this.getArea().size(); a = a + 1) {
			for (int b = 0; b < this.getArea().get(a).getRides().size(); b = b + 1) {
				AllRides.add(this.getArea().get(a).getRides().get(b));
			}
		}
		return AllRides;
	}
    
	public ArrayList<FoodVendor> getRestaurants() {
		for (int a = 0; a < this.getArea().size(); a = a + 1) {
			for (int b = 0; b < this.getArea().get(a).getRestaurants().size(); b = b + 1) {
				AllRestaurants.add(this.getArea().get(a).getRestaurants().get(b));
			}
		}
		return AllRestaurants;
	}
    
	public ArrayList<Events> getEvents() {
		for (int a = 0; a < this.getArea().size(); a = a + 1) {
			for (int b = 0; b < this.getArea().get(a).getEvents().size(); b = b + 1) {
				AllEvents.add(this.getArea().get(a).getEvents().get(b));
			}
		}
		return AllEvents;
	}

	public int[] getHours() {
		return Hours;
	}

	public void setHours(int hours[]) {
		Hours = hours;
	}


	public double getParkEntranceCost() {
		return ParkEntranceCost;
	}


	public void setParkEntranceCost(double parkEntranceCost) {
		ParkEntranceCost = parkEntranceCost;
	}
	
}
 
 
 
