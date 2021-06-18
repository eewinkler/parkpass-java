package PACKAGE.PARKPASS.PEOPLE;

//import java.util.ArrayList;

import PACKAGE.PARKPASS.ATTRACTIONS.Attraction;
import PACKAGE.PARKPASS.ATTRACTIONS.Park;
import PACKAGE.PARKPASS.ATTRACTIONS.ParkSec;
import PACKAGE.PARKPASS.ATTRACTIONS.Ride;
import PACKAGE.PARKPASS.SYSTEM.ParkCard;

public abstract class Person {
    protected String PersonNameF;
    protected String PersonNameL;
    protected int PersonAge;
    protected double PersonHeight;
    protected ParkCard PersonsCard;
    protected Attraction curLocation;
    protected Park curPark;
    protected ParkSec curParkSec;
    
    public void changeSection(ParkSec Newsec) {
    	//CHECK IF IT IS IN THE PARK
    	for (int i = 0; i < this.getCurPark().getArea().size(); i++) {
    		if (this.getCurPark().getArea().get(i) == Newsec) {
    			this.getCurPark().getArea().get(i).getCentralPath().remove(this);
    			this.setCurParkSec(Newsec);
    			Newsec.addCentralPath(this);
    			System.out.println(" - - Customer " + this.getPersonNameF() +" has moved to section "+ this.getCurParkSec().getNameofSec() + ".");
    		}
    		else {
    			System.out.println(" - - Park area " + Newsec.getNameofSec() + " does not exist within the park. " + this.getPersonNameF() + " remains in park area " + this.getCurParkSec().getNameofSec() + ".");
    		}
    	}
    }
       
	public ParkCard getCard() {
		return PersonsCard;
	}
	public void setPersonsCard(ParkCard personsCard) {
		PersonsCard = personsCard;
	}
	public Attraction getCurLocation() {
		return curLocation;
	}
	public void setCurLocation(Attraction curLocation) {
		this.curLocation = curLocation;
	}
	public String getPersonNameF() {
		return PersonNameF;
	}
	public void setPersonNameF(String personNameF) {
		PersonNameF = personNameF;
	}
	public String getPersonNameL() {
		return PersonNameL;
	}
	public void setPersonNameL(String personNameL) {
		PersonNameL = personNameL;
	}
	public int getPersonAge() {
		return PersonAge;
	}
	public void setPersonAge(int personAge) {
		PersonAge = personAge;
	}
	public double getPersonHeight() {
		return PersonHeight;
	}
	public void setPersonHeight(double personHeight) {
		PersonHeight = personHeight;
	}
	public Park getCurPark() {
		return curPark;
	}
	public void setCurPark(Park curPark) {
		this.curPark = curPark;
	}
	public ParkSec getCurParkSec() {
		return curParkSec;
	}
	public void setCurParkSec(ParkSec curParkSec) {
		this.curParkSec = curParkSec;
	}

	public abstract void PurchaseTicket(Attraction theRide);
}
 
 
 
