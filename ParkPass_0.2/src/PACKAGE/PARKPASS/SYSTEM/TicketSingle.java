package PACKAGE.PARKPASS.SYSTEM;

import PACKAGE.PARKPASS.ATTRACTIONS.Attraction;
import PACKAGE.PARKPASS.ATTRACTIONS.Ride;

public class TicketSingle {
	private Attraction RideTicket;
	private int expirationDate;

	public Attraction getRideTicket() {
		return RideTicket;
	}

	public void setRideTicket(Attraction attraction) {
		RideTicket = attraction;
	}

	public int getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(int expirationDate) {
		this.expirationDate = expirationDate;
	} 
}
