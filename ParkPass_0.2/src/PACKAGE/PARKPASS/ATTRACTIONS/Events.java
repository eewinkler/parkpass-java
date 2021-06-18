package PACKAGE.PARKPASS.ATTRACTIONS;

//import java.util.ArrayList; 
//import PACKAGE.PARKPASS.PEOPLE.EntertainmentService;

public class Events extends Attraction{

	//private ArrayList<EntertainmentService> talent;
	private String time;
	
	public Events() {
		//talent = new ArrayList<EntertainmentService>();
		time = "12:00am";
	}
	
//	public void addTalent(EntertainmentService service) {
//		talent.add(service);
//	}
//	
//    public void removeTalent(EntertainmentService service) {
//    	if (isTalent(service) == true) {
//    		talent.remove(service);
//    	}	
//    }
//    
//    public ArrayList<EntertainmentService> getAttendants() {
//    	return talent;
//    }
//    
//    public boolean isTalent(EntertainmentService service) {
//		for (int i = 0; i < talent.size(); i++) {
//			if (talent.get(i) == service) {
//				return true;
//			}
//		}
//    	return false;
//    }
//	
//    public void CalcWaitTime() {
//    	
//    }
//    
//    public void CalcPowerConsumption() {
//    	
//    }
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String timer) {
		time = timer;
	}
	
}
