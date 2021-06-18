package PACKAGE.PARKPASS.SYSTEM;
 
import java.util.ArrayList;

import PACKAGE.PARKPASS.ATTRACTIONS.Ride;
import PACKAGE.PARKPASS.PEOPLE.Customer;
import PACKAGE.PARKPASS.PEOPLE.Person;
 
public class ParkCard {
    private String NameID; 
    private int CardID;
    private Person CardOwner;
    private String Password;
    private int Age;
    private double Height;
    private double parkPoints;
    private double parkBucks;
    private ArrayList<Customer> friendsList;
    private ArrayList<TicketSingle> ParkCardTickets;
    private ArrayList<TicketDayPass> ParkCardDayPasses;
    private boolean milChildDiscount;
    private boolean RewardsMember; 
 
    public ParkCard(){
    	 NameID = "Unnamed"; 
    	 CardID = 0;
    	 Password = "password";
    	 //CardOwner;
    	 Age = 0;
    	 Height = 0.0;
    	 parkPoints = 0.0;
    	 parkBucks = 0.0;
    	 friendsList = new ArrayList<Customer>();
    	 ParkCardTickets = new ArrayList<TicketSingle>(); 
    	 ParkCardDayPasses = new ArrayList<TicketDayPass>(); 
    	 milChildDiscount = false;
    	 RewardsMember = false; 
    	
    }
    public ParkCard(String ID, int i, Person guy, boolean two, boolean three, int a, double h,double p, double b ){
    	NameID = ID; 
	   	 CardID = i;
	   	 CardOwner = guy;
	   	 Age = a;
	   	 Height = h;
	   	 parkPoints = p;
	   	 parkBucks = b;
	   	 ParkCardTickets = new ArrayList<TicketSingle>();
	   	 ParkCardDayPasses = new ArrayList<TicketDayPass>();
	   	 milChildDiscount = two;
	   	 RewardsMember = three; 
    }
    
    public void QuickAddFriend(Customer f) {
    	friendsList.add(f);
    }
    
    public void QuickRemoveFriend(Customer f) {
    	friendsList.remove(f);
    }
    
    public void TransferTickets(Customer g, TicketSingle t) {
    	g.getCard().QuickAddTicket(t);
    	this.removeTicket(t);
    }
    
    public void PrintTicketList() {
    	for (int i = 0; i < ParkCardTickets.size(); ++i) {
    		System.out.println(i + " " + this.getParkCardTickets().get(i).getRideTicket().getAttName());
    	}
    }
    
    public void PrintFriendsList() {
    	for (int i = 0; i < friendsList.size(); ++i) {
    		System.out.println(i + " " + friendsList.get(i).getPersonNameF() + " " + friendsList.get(i).getPersonNameL() + " " + friendsList.get(i).getCard().getNameID());
    	}
    }
    
    public void QuickAddTicket(TicketSingle s){
    	ParkCardTickets.add(s);
    }
    public void QuickAddFunds(double n) {
    	parkBucks = parkBucks + n;
    }
    
    public void removeTicket(TicketSingle s) {
    	ParkCardTickets.remove(s);
    }
 
    public void subBalance(double ammount){
    	parkBucks = parkBucks - ammount;
    }
 
    public void addBalance(double ammount){
    	parkBucks = parkBucks + ammount;
    }

    //GETTERS AND SETTERS
    public boolean CheckAge(int age) { //not old enough
    	if(Age < age) {
    		return false;
    	}
    	else {
    		return true;
    	}
    }
    public boolean CheckHeight(double h) {//not tall enough
    	if(Height < h) {
    		return false;
    	}
    	else {
    		return true;
    	}
    }
    public boolean CheckPB(double required) { //don't have enough money on card
    	if(parkBucks < required) {
    		return false;
    	}
    	else {
    		return true;
    	}
    }
    
	public String getNameID() {
		return NameID;
	}
	public void setNameID(String a) {
		NameID = a;
	}

	public int getCardID() {
		return CardID;
	}

	public void setCardID(int cardID) {
		CardID = cardID;
	}

	public Person getCardOwner() {
		return CardOwner;
	}

	public void setCardOwner(Person cardOwner) {
		CardOwner = cardOwner;
	}

	public int getAge() {
		return Age;
	}
	public void setAge(int a) {
		Age = a;
	}

	public double getHeight() {
		return Height;
	}
	public void setHeight(double h) {
		Height = h;
	}

	public double getParkPoints() {
		return parkPoints;
	}

	public void setParkPoints(double parkPoints) {
		this.parkPoints = parkPoints;
	}

	public double getParkBucks() {
		return parkBucks;
	}

	public void setParkBucks(double parkBucks) {
		this.parkBucks = parkBucks;
	}

	public ArrayList<TicketSingle> getParkCardTickets() {
		return ParkCardTickets;
	}

	public void setParkCardTickets(ArrayList<TicketSingle> parkCardTickets) {
		ParkCardTickets = parkCardTickets;
	}

	public ArrayList<TicketDayPass> getParkCardDayPasses() {
		return ParkCardDayPasses;
	}

	public void setParkCardDayPasses(ArrayList<TicketDayPass> parkCardDayPasses) {
		ParkCardDayPasses = parkCardDayPasses;
	}

	public boolean isMilChildDiscount() {
		return milChildDiscount;
	}

	public void setMilChildDiscount(boolean milChildDiscount) {
		this.milChildDiscount = milChildDiscount;
	}

	public boolean isRewardsMember() {
		return RewardsMember;
	}

	public void setRewardsMember(boolean rewardsMember) {
		RewardsMember = rewardsMember;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public ArrayList<Customer> getFriendsList() {
		return friendsList;
	}
	public void setFriendsList(ArrayList<Customer> friendsList) {
		this.friendsList = friendsList;
	}
    
}
 
 
 
