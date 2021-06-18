package PACKAGE.PARKPASS.ATTRACTIONS;

import java.util.ArrayList;

public class ParkTransit {

	private String description;
	private ArrayList<String> route;
	
	public ParkTransit() {
		description = "none";
		route = new ArrayList<String>();
	}
	
	public void setDescription(String desc) {
		description = desc;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setRoute(ArrayList<String> r) {
		route = r;
	}
	
	public ArrayList<String> getRoute() {
		return route;
	}
	
}
