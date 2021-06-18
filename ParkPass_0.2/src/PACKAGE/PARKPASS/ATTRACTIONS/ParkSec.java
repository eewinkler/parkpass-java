package PACKAGE.PARKPASS.ATTRACTIONS;

import java.util.ArrayList; 

import PACKAGE.PARKPASS.PEOPLE.Person;

public class ParkSec {
 
    private double SecProfits;
    private Park PartOfPark;
    private String NameofSec;
    private String SecDescription;
    private ArrayList<Person> CentralPath;
    private ArrayList<Attraction> SecAttractions;
    private ArrayList<FoodVendor> Restaurants;
    private ArrayList<Ride> Rides;
    private ArrayList<Events> Event;
 
    public ParkSec(){
        SecProfits = 0.0;
        PartOfPark = new Park();
        SecAttractions = new ArrayList <Attraction>();
        CentralPath = new ArrayList <Person>();
        NameofSec = "none";
        SecDescription = "none";
        Restaurants = new ArrayList<FoodVendor>();
        Rides = new ArrayList<Ride>();
        Event = new ArrayList<Events>();
    }
    public void addCentralPath(Person c) {
    	CentralPath.add(c);
    	System.out.println(" - - Customer " +c.getPersonNameF() +" has moved to the section "+ this.getNameofSec()+ "!");
    }
    
    
	public double getSecProfits() {
		return SecProfits;
	}

	public void setSecProfits(double secProfits) {
		SecProfits = secProfits;
	}

	public Park getPartOfPark() {
		return PartOfPark;
	}

	public void setPartOfPark(Park partOfPark) {
		PartOfPark = partOfPark;
	}

	public ArrayList<Attraction> getSecAttractions() {
		return SecAttractions;
	}

	public void addSecAttractions(Attraction c) {
		SecAttractions.add(c);
    	System.out.println("* * Attraction " +c.getAttName() +" is currently operating in "+ this.getNameofSec() );

	}
    
    public void removeSecAttractions(Attraction att) {
    	if (isInAttractions(att) == true) {
    		SecAttractions.remove(att);
    	}
    }
    
    public boolean isInAttractions(Attraction att) {
    	for (int i = 0; i < SecAttractions.size(); i++) {
			if (SecAttractions.get(i) == att) {
				return true;
			}
		}
    	return false;
    }

	public String getNameofSec() {
		return NameofSec;
	}

	public void setNameofSec(String nameofSec) {
		NameofSec = nameofSec;
	}

	public String getSecDescription() {
		return SecDescription;
	}

	public void setSecDescription(String secDescription) {
		SecDescription = secDescription;
	}
	
	public ArrayList<Attraction> getRides() {
		return SecAttractions;
	}

	public void addRide(Ride r) {
		Rides.add(r);
		SecAttractions.add(r);
		r.setParkSection(this);
		r.setPark(PartOfPark);
	}
    
    public void removeRide(Ride att) {
    	if (isInAttractions(att) == true) {
    		SecAttractions.remove(att);
    		Rides.remove(att);
    	}
    }
    
	public ArrayList<FoodVendor> getRestaurants() {
		return Restaurants;
	}

	public void addRestaurant(FoodVendor r) {
		Restaurants.add(r);
		SecAttractions.add(r);
		r.setParkSection(this);
		r.setPark(PartOfPark);
	}
    
    public void removeRestaurant(FoodVendor att) {
    	if (isInAttractions(att) == true) {
    		SecAttractions.remove(att);
    		Restaurants.remove(att);
    	}
    }
    
	public ArrayList<Events> getEvents() {
		return Event;
	}

	public void addEvent(Events r) {
		Event.add(r);
		SecAttractions.add(r);
		r.setParkSection(this);
		r.setPark(PartOfPark);
	}
    
    public void removeEvent(Events att) {
    	if (isInAttractions(att) == true) {
    		SecAttractions.remove(att);
    		Event.remove(att);
    	}
    }

	public ArrayList<Person> getCentralPath() {
		return CentralPath;
	}

	public void setCentralPath(ArrayList<Person> centralPath) {
		CentralPath = centralPath;
	}
    
}
 
 
