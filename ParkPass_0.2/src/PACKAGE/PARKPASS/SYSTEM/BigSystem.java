package PACKAGE.PARKPASS.SYSTEM;

import java.io.*; //import classes
import java.io.File;
import java.util.ArrayList; 
import java.util.Scanner;
import java.util.StringTokenizer;

import PACKAGE.PARKPASS.ATTRACTIONS.Park;
import PACKAGE.PARKPASS.ATTRACTIONS.ParkSec;
import PACKAGE.PARKPASS.PEOPLE.Customer;
import PACKAGE.PARKPASS.PEOPLE.ManagementStaff;

public class BigSystem {
	 
	private ArrayList<Park> RegisteredParks; //all the parks participating and using the system	
	private ArrayList<Customer> RegisteredCustomers;
	private ArrayList<ManagementStaff> RegisteredStaff;
	private Park Away;
	private ParkSec AwaySec;
	private int curDate; //ex 2019/03/21
	private int curTime; //ex millitary time 13 00
	private static int IDindex = 10000;
	
	public BigSystem() {
		RegisteredParks = new ArrayList<Park>();
		RegisteredCustomers = new ArrayList<Customer>();
		RegisteredStaff = new ArrayList<ManagementStaff>();
	}
	
	public void CreateNewProfile(Customer d) {
		RegisteredCustomers.add(d);
	}
	
	public void ScanInCustomers(String txtfile) {
        String str = new String();
		
        File myFile = new File(txtfile);
        Scanner inputFile = null;
		try {
			inputFile = new Scanner(myFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        while (inputFile.hasNext() ) { //while there are still lines to read?
        	// Read a line from the file.
        	str = inputFile.nextLine();
        	StringTokenizer strTokenizer = new StringTokenizer(str);
        	Customer tempCu = new Customer();
        	ParkCard tempCa = new ParkCard();
        	//ProfileID FirstName LastName UserName Age Height parkPoints parkBucks milChildDiscount RewardsMember 
        	
        	tempCu.setPersonNameF(strTokenizer.nextToken()); //FIrstName
        	tempCu.setPersonNameL(strTokenizer.nextToken()); //LastName
        	tempCa.setNameID(strTokenizer.nextToken()); //Username 
        	int v1 = Integer.parseInt(strTokenizer.nextToken()); //Age
        	tempCu.setPersonAge(v1);
        	tempCa.setAge(v1);
        	double v2 = Double.parseDouble(strTokenizer.nextToken()); //Height
        	tempCu.setPersonHeight(v2);
        	tempCa.setHeight(v2);
        	tempCa.setParkPoints(Double.parseDouble(strTokenizer.nextToken())); //Parkpoints
        	tempCa.setParkBucks(Double.parseDouble(strTokenizer.nextToken())); //parkbucks
        	if(Integer.parseInt(strTokenizer.nextToken()) == 1) { //milChild DIscount
        		tempCa.setMilChildDiscount(true);
        	}
        	if(Integer.parseInt(strTokenizer.nextToken()) == 1) { //RewardMember
        		tempCa.setRewardsMember(true);
        	}
        	
        	tempCu.setPersonsCard(tempCa); //sets person card
        	tempCa.setCardOwner(tempCu);
        	
        	//tempCu.setCurLocation(Away1);
        	RegisteredCustomers.add(tempCu); //adds person to data
        	System.out.println(tempCu.getPersonNameF() +" added");
        	
        } //end scanning
        inputFile.close();//close the file!
	}//end ScanInCus
	
	// ====================================
	
	

	public Park FindPark(String Parkname) {
		for(int i = 0; RegisteredParks.size() < i; i = i+1) {
			if( Parkname.compareTo( RegisteredParks.get(i).getParkName() )==0 ) {
				return RegisteredParks.get(i);
			}
		}
		return null;
	}
	
	//used in an interface perhapse
	
	public void timeSkipFive() {
		curTime = curTime + 5;
		checkDateTime();
		System.out.print(" = = TIME is now " + this.getCurTime() + " on ");
		this.printDate(curDate);
		System.out.println("!");
		System.out.println("Checking Attraction Statuses... =====================");
		for(int i = 0; i < RegisteredParks.size(); i++) {
			System.out.println(" -> Park " +RegisteredParks.get(i).getParkName() );
			for(int j = 0; j < RegisteredParks.get(i).getAttractions().size(); j++) {
				RegisteredParks.get(i).getAttractions().get(j).isAttractionOver(curTime);
			}
		}
		System.out.println("Fully Updated! ========================");
	}
	
	
	public void timeSkipHour() {
		for(int i = 0; i < 12; i++ ) {
			timeSkipFive();
		}
	}
	
	public void timeSkipDay() {
		curTime = 700;
		curDate = curDate + 1;
		checkDateTime();
	}
	public void checkDateTime() {
		int day = curDate%100;
		int month = (curDate/100)%100;
		int year = (curDate/10000);
		int hour = curTime/100;
		int minute = curTime%100; 
		
		if(minute > 59) {
			minute = 0;
			hour = hour + 1;
		}
		if(hour > 23) {
			hour = 0;
			day = day + 1;
		}
		
		
		if(month == 1 && day > 31) {
			day = 1;
			month = month+1;
		}
		else if(month == 2 && day > 31) {
			day = 1;
			month = month+1;
		}
		else if(month == 3 && day > 28) {
			day = 1;
			month = month+1;
		}
		else if(month == 4 && day > 31) {
			day = 1;
			month = month+1;
		}
		else if(month == 5 && day > 30) {
			day = 1;
			month = month+1;
		}
		else if(month == 6 && day > 31) {
			day = 1;
			month = month+1;
		}
		else if(month == 7 && day > 30) {
			day = 1;
			month = month+1;
		}
		else if(month == 8 && day > 31) {
			day = 1;
			month = month+1;
		}
		else if(month == 9 && day > 31) {
			day = 1;
			month = month+1;
		}
		else if(month == 10 && day > 30) {
			day = 1;
			month = month+1;
		}
		else if(month == 11 && day > 31) {
			day = 1;
			month = month+1;
		}
		else if(month == 12 && day > 30) {
			day = 1;
			month = 1;
			year = year+1;
		}	
		
		curTime = (hour *100) + minute;
		curDate = (year * 10000) + (month * 100) + day; 
	}//end check time
	
	public void printDate(int date) {
		//ex 2019/03/21
		int day = date%100;
		int month = (date/100)%100;
		int year = (date/10000);
		System.out.print(month + "/" + day + "/" + year);	
	}
	
	public void printTime(int time) {
		int hour = time/100;
		int minute = time%100; 
		System.out.print(hour + ":" + minute);
	}
	
	public void addRegisteredPark(Park e) {
		RegisteredParks.add(e);
	}
	
	
		//GETTERS AND SETTERS!!!! ========================================================
	public ArrayList<Park> getRegisteredParks() {
		return RegisteredParks;
	}

	public void RegisteredParks(Park p) {
		this.RegisteredParks.add(p);
	}

	public ArrayList<Customer> getRegisteredCustomers() {
		return RegisteredCustomers;
	}

	public void setRegisteredCustomers(ArrayList<Customer> registeredCustomers) {
		RegisteredCustomers = registeredCustomers;
	}


	public int getCurDate() {
		return curDate;
	}

	public void setCurDate(int curDate) {
		this.curDate = curDate;
	}

	public int getCurTime() {
		return curTime;
	}

	public void setCurTime(int curTime) {
		this.curTime = curTime;
	}
	public static int getCardIDdata() {
		return IDindex;
	}
	public static int getCardIDNEW() {
		IDindex = IDindex+1;
		return IDindex;
	}

	public Park getAway() {
		return Away;
	}

	public void setAway(Park away) {
		Away = away;
	}

	public ParkSec getAwaySec() {
		return AwaySec;
	}

	public void setAwaySec(ParkSec awaySec) {
		AwaySec = awaySec;
	}

	public ArrayList<ManagementStaff> getRegisteredStaff() {
		return RegisteredStaff;
	}

	public void setRegisteredStaff(ArrayList<ManagementStaff> registeredStaff) {
		RegisteredStaff = registeredStaff;
	}
	

}


