package PACKAGE.PARKPASS.ATTRACTIONS;

import java.util.ArrayList;  

import PACKAGE.PARKPASS.PEOPLE.Customer;
import PACKAGE.PARKPASS.PEOPLE.Person;
 
public abstract class Attraction {
    protected String AttName;
    protected String AttDesc;
    protected Park belongstoPark;
    protected ParkSec inParkSec;
    protected boolean isOpen;
    protected int startTime; //
    protected int duration; 
    protected int maxInAttraction;
    protected double singleTicketCost;
    protected ArrayList<Customer> inAttraction;
    protected ArrayList<Customer> inQueue; 
    protected int ageRequirement;
	protected double heightRequirement;
    
    public Attraction() {
    	AttName = "unknown";
    	belongstoPark = new Park();
    	inParkSec = new ParkSec();
    	isOpen = false;
    	duration = 0;
    	startTime = 700;
    	maxInAttraction = 0;
    	singleTicketCost = 0.0;
    	inAttraction = new ArrayList<Customer>();
    	inQueue = new ArrayList<Customer>();
    }
    
    public void isAttractionOver(int curTime) {
    	if(duration + startTime <= curTime) {//ride is over!
    		System.out.println(" < = " +this.getAttName() + " is over, exiting...");
    		this.LeaveAttraction();
    		System.out.println(" < = " +this.getAttName() + " is now loading...");
        	this.QueueToAtt(curTime);
    	}
    	else {
    		return;
    	}
    }
    
   
    
    
    public void closeRide() {
    	int removing = 10000;
    	isOpen = false;
    	System.out.println(" < = " + AttName + " is being closed.");
    	
    	if (inAttraction.size() < maxInAttraction) {
    		removing = inAttraction.size();
    	}
    	else {
    		removing = maxInAttraction;
    	}
    	
    	for (int i = 0; i < removing; ++i) {
    		System.out.println(" < - " +inAttraction.get(0).getPersonNameF() +" is being kicked off of " + this.getAttName() );
    		this.getParkSection().addCentralPath(inAttraction.get(0));
    		inAttraction.remove(0);
    	}
    	
    }
    
    public void Reopen() {
    	isOpen = true;
    }
    
    public void QueueToAtt(int starttime) { //automation to make things work over time...
    	int adding = 100000000;
    	if (inQueue.size() < maxInAttraction) {
    		adding = inQueue.size();
    	}
    	else {
    		adding = maxInAttraction;
    	}
    	 
    	for (int i = 0; i < adding; ++i) {
    		inAttraction.add(inQueue.get(0));
    		System.out.println(" < - " +inAttraction.get(i).getPersonNameF() +" is on " + this.getAttName() );
    		inQueue.remove(0);
    	}
    	startTime = starttime;
    }
    
    public void LeaveAttraction() {
    	int removing = 1000000;
    	if (inAttraction.size() < maxInAttraction) {
    		removing = inAttraction.size();
    	}
    	else {
    		removing = maxInAttraction;
    	}
    	
    	for (int i = 0; i < removing; ++i) {
    		System.out.println(" < - " +inAttraction.get(0).getPersonNameF() +" had fun on " + this.getAttName() );
    		this.getParkSection().addCentralPath(inAttraction.get(0));
    		inAttraction.remove(0);
    	} 
    }
 
    public int CalcWaitTime() {
    	return ((inQueue.size())/maxInAttraction)*duration;
    }
    
    public void leaveingAttraction(Person cust) {
    	if (isInAttraction(cust) == true) {
    		inAttraction.remove(cust);
    	}	
    }
    
    
    public boolean isInAttraction(Person cust) {
		for (int i = 0; i < inAttraction.size(); i++) {
			if (inAttraction.get(i) == cust) {
				return true;
			}
		}
    	return false;
    }
    
    public void addInQueue(Customer cust) {
    	inQueue.add(cust);
    }
    
    public void removeInQueue(Customer cust) {
    	if (isInQueue(cust) == true) {
    		inQueue.remove(cust);
    	}
    }
    public void addInAttraction(Customer cust) {
    	inAttraction.add(cust);
    }

    public boolean isInQueue(Customer cust) {
		for (int i = 0; i < inQueue.size(); i++) {
			if (inQueue.get(i) == cust) {
				return true;
			}
		}
    	return false;
    }
    
    
    //SETTERS AND GETTERS ==================================
    public void setAttName(String name) {
    	AttName = name;
    }
    public String getAttName() {
    	return AttName;
    }
    public void setPark(Park park) {
    	belongstoPark = park;
    }
    public Park getPark() {
    	return belongstoPark;
    }
    public void setParkSection(ParkSec name) {
    	inParkSec = name;
    }
    public ParkSec getParkSection() {
    	return inParkSec;
    }
    public void setOpen(boolean open) {
    	isOpen = open;
    }
    public boolean getOpen() {
    	return isOpen;
    }
    public void setStayTime(int time) {
    	duration = time;
    }
    public int getStayTime() {
    	return duration;
    }
    public void setMax(int per) {
    	maxInAttraction = per;
    }
    public int getMax() {
    	return maxInAttraction;
    }
    
    public ArrayList<Customer> getInAttraction() {
    	return inAttraction;
    }
    public ArrayList<Customer> getInQueue() {
    	return inQueue;
    }
	public double getSingleTicketCost() {
		return singleTicketCost;
	}
	public void setSingleTicketCost(double singleTicketCost) {
		this.singleTicketCost = singleTicketCost;
	}

	public String getAttDesc() {
		return AttDesc;
	}

	public void setAttDesc(String attDesc) {
		AttDesc = attDesc;
	}

	public int getAgeRequirement() {
		return ageRequirement;
	}

	public void setAgeRequirement(int ageRequirement) {
		this.ageRequirement = ageRequirement;
	}

	public double getHeightRequirement() {
		return heightRequirement;
	}

	public void setHeightRequirement(int heightRequirement) {
		this.heightRequirement = heightRequirement;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
 
}
 

