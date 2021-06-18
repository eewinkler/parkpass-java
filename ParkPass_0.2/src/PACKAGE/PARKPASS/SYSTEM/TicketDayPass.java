package PACKAGE.PARKPASS.SYSTEM;

import java.util.ArrayList;

import PACKAGE.PARKPASS.ATTRACTIONS.Park;
import PACKAGE.PARKPASS.ATTRACTIONS.ParkSec;
import PACKAGE.PARKPASS.ATTRACTIONS.Ride;

public class TicketDayPass {
	private Park AllPass;
	private int DateofPass; //only valid on that day
	private ArrayList<ParkSec> ParticipatingSections;
	private ArrayList<Ride> ParticipatingRides;

	public Park getAllPass() {
		return AllPass;
	}

	public void setAllPass(Park allPass) {
		AllPass = allPass;
	}

	public int getDateofPass() {
		return DateofPass;
	}

	public void setDateofPass(int dateofPass) {
		DateofPass = dateofPass;
	}

	public ArrayList<ParkSec> getParticipatingSections() {
		return ParticipatingSections;
	}

	public void setParticipatingSections(ArrayList<ParkSec> participatingSections) {
		ParticipatingSections = participatingSections;
	}

	public ArrayList<Ride> getParticipatingRides() {
		return ParticipatingRides;
	}

	public void setParticipatingRides(ArrayList<Ride> participatingRides) {
		ParticipatingRides = participatingRides;
	}
}
