package PACKAGE.PARKPASS.PEOPLE;

import PACKAGE.PARKPASS.ATTRACTIONS.Attraction;
import PACKAGE.PARKPASS.ATTRACTIONS.Ride;
import PACKAGE.PARKPASS.SYSTEM.ParkCard;
import PACKAGE.PARKPASS.SYSTEM.TicketSingle;

public class Customer extends Person {

	
	public Customer() {
		setPersonNameF("undefined");
	    setPersonNameL("undefined");
	    setPersonAge(0);
	    setPersonHeight(0.0);
	    setPersonsCard(new ParkCard());
	}
	public Customer(String F, String L, int a, double h, ParkCard c) {
		setPersonNameF(F);
	    setPersonNameL(L);
	    setPersonAge(a);
	    setPersonHeight(h);
	    setPersonsCard(c);
	}
	
    public void PurchaseTicket(Attraction attraction) {
    	//check if ride is working
    	if(attraction.getOpen() == false) {
    		System.out.println("Ticket for "+ attraction.getAttName() +" Cannot be purchased because it is currently Closed");
    		return;
    	}
    	else if(PersonsCard.CheckAge(attraction.getAgeRequirement() ) == false ) {
    		System.out.println(" - - " + "Hi, " + PersonNameF + "!");
    		System.out.println(" - - " + "Ticket for "+ attraction.getAttName() +" Cannot be purchased because you are too young");
    		return;
    	}
    	else if(PersonsCard.CheckPB( attraction.getSingleTicketCost() ) == false) {
    		System.out.println(" - - " + "Hi, " + PersonNameF + "!");
    		System.out.println(" - - " + "Ticket for "+ attraction.getAttName() +" Cannot be purchased because you are too poor");
    		return;
    	}
    	else {//purchase ticket
    		PersonsCard.subBalance(attraction.getSingleTicketCost());
    		TicketSingle temp = new TicketSingle();
    		//add expiration date
    		temp.setRideTicket(attraction);
    		PersonsCard.getParkCardTickets().add(temp);
    		System.out.println(" - - " + "Hi, " + PersonNameF + "!");
    		System.out.println(" - - " + "Ticket for "+ attraction.getAttName() +" was sucsessfully purchased and added to your park card!");

    	}
    }
	
    public void goOnRide(Attraction r){
    	
    	for (int j = 0; j < this.getCard().getParkCardDayPasses().size(); ++j) {
    		if (this.getCard().getParkCardDayPasses().get(j).getAllPass().getParkName().compareTo(r.getPark().getParkName()) == 0) {
    			//if () add strict requirements for participating rides and areas later...
    			r.addInQueue(this);
    			System.out.println("Congratulations! You have the Day Pass.");
    			System.out.println(" - - " + this.getPersonNameF() + " is currently in line for " + r.getAttName() + ".");
    		}
    		else {
    			System.out.println(" - - You do not have a Day Pass");
    		}
    	}
    	
    	for (int i = 0; i < this.getCard().getParkCardTickets().size(); i++) {
    		if ( r.getAttName().compareTo(this.getCard().getParkCardTickets().get(i).getRideTicket().getAttName() ) == 0 ) { //if they have ticket
    			if ((r.getOpen() == true) && (PersonsCard.CheckAge(PersonAge) == true) && (PersonsCard.CheckHeight(PersonHeight) == true)) {
    				this.getCard().removeTicket(this.getCard().getParkCardTickets().get(i));
    				r.addInQueue(this);
    				System.out.println(" - - " + this.getPersonNameF() + " is currently in line for " + r.getAttName() + ".");
    			return;
    			}
    			else if ((r.getOpen() == true) && (PersonsCard.CheckAge(PersonAge) == false)){
    				System.out.println(" - - " + PersonNameF + " is not old enough for " + r.getAttName() + ".");
    			}
    			else if ((r.getOpen() == true) && (PersonsCard.CheckHeight(PersonHeight) == false)) {
    				System.out.println(" - - " + PersonNameF + " is not tall enough for " + r.getAttName() + ".");
    			}
    			else {
    	    		System.out.println(" - - "  +r.getAttName() + " is currently closed.");
    	    		return;
    			}
    		}
    		else {
    			System.out.println(" - - You do not have a ticket for " + r.getAttName());
	    		return;
    		}
    	}
    }
	
}
