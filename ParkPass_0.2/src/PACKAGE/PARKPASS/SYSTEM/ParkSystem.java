package PACKAGE.PARKPASS.SYSTEM;

import PACKAGE.PARKPASS.ATTRACTIONS.Events;
import PACKAGE.PARKPASS.ATTRACTIONS.Park;
import PACKAGE.PARKPASS.ATTRACTIONS.Ride;
import PACKAGE.PARKPASS.PEOPLE.Customer;
import PACKAGE.PARKPASS.PEOPLE.Person;

import java.util.Scanner;

public class ParkSystem {
	private Park curPark;
	private Customer curAttendant; 
	private Ride curRide; //away if on mobile
	private Events curEvent;
	
	
	public ParkSystem() {
		curPark = new Park();
		curAttendant = new Customer();
		curRide = new Ride();
	}
	
	public void SystemIdlePark(BigSystem MainSys) {
		String ksel;
		boolean loop = true;
		boolean NEWLOOP = true;
		boolean loopS = true;
		boolean loopMini = true;
		boolean loopdiloop = true;
		Scanner kboard = new Scanner(System.in); 
		
		while (curPark.isParkOpen(MainSys.getCurTime()) == true) {
		
			System.out.println("Hello! We hope you are enjoying "+curPark.getParkName() +"." );
			if(curRide.getAttName() != "unknown") {
				System.out.println("Welcome to the " + curRide.getAttName() );
			}
			
			System.out.println("Please scan your card:");
			if(curRide.getAttName() != "unknown") {
				System.out.println("(9) To jump in Queue for " +curRide.getAttName()); // when station is at ride entrance
			}
			System.out.println("(0) Scan Card");
			System.out.println("(1) Signing In");
			System.out.println("(2) Manual Create Account");
			
			while(loopS == true) {
				ksel = kboard.next();
				if( ksel.compareTo("1") == 0) { //sign in
					while(loopMini == true) {
						System.out.println("Enter Password:");
						ksel = kboard.next();
						if(ksel.compareTo( curAttendant.getCard().getPassword() ) == 0) { //password correct
							System.out.println("Signed In!");
							loopMini = false; //ends loopMini
						}
						else { //incorrect password
							System.out.println("Incorrect Password, Try Again");
						}
						
					}
					loopS = false; //ends loopS
					loopMini = true;
					//NEXT CASE
				}
				else if(ksel.compareTo("2") == 0) { 
					while(loopMini == true) {
						ParkCard tempCard = new ParkCard();
						
						if (curAttendant.getCard().getNameID() != "Unnamed") {
							System.out.println("Account already created.");
							loopMini = false;
						}
						
						System.out.println("Enter New UserName:");
						tempCard.setNameID( kboard.next() );
						tempCard.setCardID( BigSystem.getCardIDNEW() ); //creates new ID number
						System.out.println("Enter Age: ");
						tempCard.setAge( kboard.nextInt() );
						System.out.println("Enter Height (in feet): ");
						tempCard.setHeight( kboard.nextDouble() );
						System.out.println("Are you in the military? (y/n) ");
						if (kboard.next() == "y") {
							tempCard.setMilChildDiscount(true);
						}
						else {
							tempCard.setMilChildDiscount(false);
						}
						System.out.println("Enter New Password:");
						tempCard.setPassword(kboard.next());
						//set new card to person
						tempCard.setCardOwner(curAttendant);
						curAttendant.setPersonsCard(tempCard);
						
						System.out.println("Your account has been created! Your personal ParkCard has been dispensed.");
						loopMini = false;						
					}
					loopS = false;
					loopMini = true;
				}
				
				else if (ksel.compareTo("9") == 0 && curRide.getAttName() != "unknown") {
					System.out.println("HaveFun!");
					curAttendant.goOnRide(curRide);
					loopS = false;
					loop = false;
				}
				
				else if (ksel.compareTo("0") == 0) {
					System.out.println("Checking Card");
					if(curAttendant.getCard().getNameID() != "Unnamed") {
						System.out.println("You are signed in. Welcome " + curAttendant.getCard().getNameID() + "!");
						loopS = false;
					}
					else {
						System.out.println("You do not have a card! Creating Account and despensing card");
						ParkCard tempCard = new ParkCard();
						
						tempCard.setAge(curAttendant.getPersonAge() );
						tempCard.setNameID(curAttendant.getPersonNameF() + "TempProfile" );
						tempCard.setHeight(curAttendant.getPersonHeight() );
						
						//set the new card
						tempCard.setCardOwner(curAttendant);
						curAttendant.setPersonsCard(tempCard);
						loopS = false;
					}
				}
				else {//catch
					System.out.println("Improper Input.");
				}
			}
			
			//Person Scanned in
			while(loop == true) {
				loopdiloop = true;
				NEWLOOP = true;
				//if person is a customer
				System.out.println(String.format("Hello! We hope you are enjoying %s! How can I help you today?", curPark.getParkName() ));
				System.out.println("(1) Show Wait times for Rides, Places to eat, Events and Activities");
				System.out.println("(2) Friends");
				System.out.println("(3) Update Account");
				//if over the age limit
				System.out.println("(4) Upgrade to a Membership (18+)");
				System.out.println("(5) Add Money to Card/Account (18+)");
				System.out.println("(6) Purchase Tickets/Passes (18+)");
				System.out.println("(7) Exit");
				ksel = kboard.next();
				
				if(ksel.compareTo("1") == 0) { //Show Rides and wait times
					System.out.println("(1) Wait times for Rides, Places to eat, Events and Activities");
					System.out.println("(2) Places to Eat");
					System.out.println("(3) Events and Activities");
					ksel = kboard.next();
						if( ksel.compareTo("1") == 0) { //sign in
							printWaitTimes();						
						}
						else if( ksel.compareTo("2") == 0) { //sign in
							printRestaurants();
						}
						else if( ksel.compareTo("3") == 0) { //sign in
							printEvents();
						}
						else {
							System.out.println("Improper Input");
						}
				}
				else if(ksel.compareTo("2") == 0) { //FRIENDS
					while (loopdiloop == true) {
						System.out.println("(1) Find My Friends");
						System.out.println("(2) Trade Tickets With Friends");
						System.out.println("(3) Add Friends");
						System.out.println("(4) Remove Friends");
						System.out.println("(5) Quit");
						
						ksel = kboard.next();
						if( ksel.compareTo("1") == 0) { //sign in
							for (int i = 0; i < curAttendant.getCard().getFriendsList().size(); ++i) {
					    		System.out.println(i + " " + curAttendant.getCard().getFriendsList().get(i).getPersonNameF() + " " + curAttendant.getCard().getFriendsList().get(i).getPersonNameL() + " is in park area " + curAttendant.getCard().getFriendsList().get(i).getCurParkSec().getNameofSec());
					    	}						
						}
						else if( ksel.compareTo("2") == 0) { //sign in
							if (curAttendant.getCard().getFriendsList().size() == 0) {
								System.out.println("Sorry, you do not have anyone on your Friends List at this time.");
							}
							else if (curAttendant.getCard().getParkCardTickets().size() == 0){
								System.out.println("Sorry, you do not have any tickets to trade at this time.");
							}
							else {
							curAttendant.getCard().PrintFriendsList();
							System.out.println("Enter username of friend you would like to trade with: ");
							ksel = kboard.next();
							for (int k = 0; k < curAttendant.getCard().getFriendsList().size(); k++) {
								if (ksel.compareTo(curAttendant.getCard().getFriendsList().get(k).getCard().getNameID()) == 0) {
									Customer name = curAttendant.getCard().getFriendsList().get(k);
									if (name.getCard().getParkCardTickets().size() == 0){
										System.out.println("Sorry, your friend does not have any tickets to trade at this time.");
									}
									else {
										curAttendant.getCard().PrintTicketList();
										System.out.println("Enter ticket number you would like to give to friend: ");
										ksel = kboard.next();
										int temp = Integer.parseInt(ksel);
										if ((Integer.parseInt(ksel) < curAttendant.getCard().getParkCardTickets().size()) && (Integer.parseInt(ksel) >= 0)) {
											int temp2 = Integer.parseInt(ksel);
										}
										else {
											System.out.println("Improper ticket number.");
										}
										name.getCard().PrintTicketList();
										System.out.println("Enter ticket number you would like to get from friend: ");
										ksel = kboard.next();
										if ((Integer.parseInt(ksel) < name.getCard().getParkCardTickets().size()) && (Integer.parseInt(ksel) >= 0)) {
											TicketSingle temp2 = name.getCard().getParkCardTickets().get(Integer.parseInt(ksel) );
										}
										else {
											System.out.println("Improper ticket number.");
										}
										curAttendant.getCard().getParkCardTickets().remove(curAttendant.getCard().getParkCardTickets().get(temp));
										curAttendant.getCard().getParkCardTickets().add(name.getCard().getParkCardTickets().get(Integer.parseInt(ksel)));
										curAttendant.getCard().getFriendsList().get(k).getCard().getParkCardTickets().remove(name.getCard().getParkCardTickets().get(Integer.parseInt(ksel)));
										curAttendant.getCard().getFriendsList().get(k).getCard().getParkCardTickets().add(curAttendant.getCard().getParkCardTickets().get(temp));
										System.out.println("You and your friends have switched selected tickets!");
									}
								}
								else {
									System.out.println("This username is not on your friends list.");
								}
							}
							}
						}
						else if(ksel.compareTo("3") == 0) { //sign in
							System.out.println("Enter username: ");
							ksel = kboard.next();
							for (int h = 0; h < curAttendant.getCurPark().getCustomers().size(); h++) {
								if (ksel.compareTo(curAttendant.getCurPark().getCustomers().get(h).getCard().getNameID()) == 0) {
									System.out.println(curAttendant.getCard().getFriendsList().get(h).getCard().getNameID() + " has been added to your Friends List.");
									curAttendant.getCard().getFriendsList().add(curAttendant.getCurPark().getCustomers().get(h));
									curAttendant.getCurPark().getCustomers().get(h).getCard().getFriendsList().add(curAttendant);
								}
							}
							System.out.println(ksel + " was not found in this park and can not be added to your Friends List.");
						}
						else if( ksel.compareTo("4") == 0) { //sign in
							curAttendant.getCard().PrintFriendsList();
							System.out.println("Enter friend's username: ");
							for (int k = 0; k < curAttendant.getCard().getFriendsList().size(); k++) {
								if (ksel.compareTo(curAttendant.getCard().getFriendsList().get(k).getCard().getNameID()) == 0) {
									System.out.println(curAttendant.getCard().getFriendsList().get(k).getCard().getNameID() + " has been removed from your Friends List.");
									curAttendant.getCard().getFriendsList().get(k).getCard().getFriendsList().remove(curAttendant);
									curAttendant.getCard().getFriendsList().remove(curAttendant.getCard().getFriendsList().get(k));
								}
							}
							System.out.println(ksel + " was not found on your friends list and can not be removed.");
						}
						else if( ksel.compareTo("5") == 0) { //sign in
							loopdiloop = false;
						}
						else {
							System.out.println("Imporper Input");
						}
					}
				}
				else if(ksel.compareTo("3") == 0) {//update account
					while (NEWLOOP == true) {
						System.out.println("Which part of account would you like to change?");
						System.out.println("(1) Username");
						System.out.println("(2) Age");
						System.out.println("(3) Height");
						System.out.println("(4) Military Distinction");
						System.out.println("(5) Password");
						ksel = kboard.next();
						if (ksel.compareTo("1") == 0) {
							System.out.println("What would you like your new username to be?");
							ksel = kboard.next();
							curAttendant.getCard().setNameID(ksel);
							System.out.println("Username changed to " + ksel + ".");
							NEWLOOP = false;
						}
						else if (ksel.compareTo("2") == 0) {
							System.out.println("What would you like your new age to be?");
							ksel = kboard.next();
							curAttendant.getCard().setAge(Integer.parseInt(ksel));
							System.out.println("Age changed to " + ksel + " years old.");
							NEWLOOP = false;
						}
						else if (ksel.compareTo("3") == 0) {
							System.out.println("What would you like your new height to be? (in feet)");
							ksel = kboard.next();
							curAttendant.getCard().setHeight(Double.parseDouble(ksel));
							System.out.println("Height changed to " + ksel + " feet tall.");
							NEWLOOP = false;
						}
						else if (ksel.compareTo("4") == 0) {
							if (curAttendant.getCard().isMilChildDiscount() == false) {
								curAttendant.getCard().setMilChildDiscount(true);
								System.out.println("You now have military distinction.");
							}
							else {
								curAttendant.getCard().setMilChildDiscount(false);
								System.out.println("You have removed your military distinction.");
							}
							NEWLOOP = false;
						}
						else if (ksel.compareTo("5") == 0) {
							System.out.println("What would you like your new password to be?");
							ksel = kboard.next();
							curAttendant.getCard().setPassword(ksel);
							System.out.println("Password changed to " + ksel + ".");
							NEWLOOP = false;
						}
						else {
							System.out.println("Improper input.");
						}
					}
				}
				else if(ksel.compareTo("4") == 0) {//update account
					if (curAttendant.getCard().isRewardsMember() == true) {
						System.out.println("You are already a rewards member! Congratulations!");
					}
					else {
						if (curAttendant.getCard().getParkBucks() >= 20.0) {
							System.out.println("If you would like to become a rewards member, it will cost 20 ParkBucks. Do you agree? (y/n)");
							ksel = kboard.next();
							if (ksel == "y") {
								curAttendant.getCard().setParkBucks((curAttendant.getCard().getParkBucks() - 20));
								System.out.println("You are now a rewards member. Congratulations!");
								curAttendant.getCard().setRewardsMember(true);
							}
						}
						else {
							System.out.println("You do not currently have enough ParkBucks to become a member. You will need 20 ParkBucks.");
						}
					}
				}
				else if(ksel.compareTo("5") == 0) {//update account
					System.out.println("How many ParkBucks would you like to add to your account?");
					ksel = kboard.next();
					curAttendant.getCard().setParkBucks((curAttendant.getCard().getParkBucks()) + Integer.parseInt(ksel));
					System.out.println(ksel + " ParkBucks have been added to your account.");
				}
				else if(ksel.compareTo("6") == 0) {//update account
					System.out.println("All Rides:");
					for (int y = 0; y < curAttendant.getCurPark().getArea().size(); y++) {
						for (int z = 0; z < curAttendant.getCurPark().getArea().get(y).getRides().size(); z++) {
							System.out.println("	" + curAttendant.getCurPark().getArea().get(y).getRides().get(z).getAttName());
						}
					}
					System.out.println("Which ride would you like to buy ticket(s) for?");
					ksel = kboard.next();
					for (int h = 0; h < curAttendant.getCurPark().getArea().size(); h++) {
						for (int d = 0; d < curAttendant.getCurPark().getArea().get(h).getRides().size(); d++) {
							if (ksel.compareTo(curAttendant.getCurPark().getArea().get(h).getRides().get(d).getAttName()) == 0) {
								String ridename = ksel;
								System.out.println("How many tickets would you like to buy for this ride? (Max 5 tickets)");
								ksel = kboard.next();
								int numba = Integer.parseInt(ksel);
								if ((Integer.parseInt(ksel) <= 5) && (Integer.parseInt(ksel) > 0)) {
									System.out.println("This ride will cost " + curAttendant.getCurPark().getArea().get(h).getRides().get(d).getSingleTicketCost() + " ParkBucks per ticket. Continue? (y/n)");
									ksel = kboard.next();
									if (ksel == "y") {
										if (curAttendant.getCard().getParkBucks() >= ((curAttendant.getCurPark().getArea().get(h).getRides().get(d).getSingleTicketCost())*numba)) {
											for (int g = 0; g < numba; g++) {
												curAttendant.PurchaseTicket(curAttendant.getCurPark().getArea().get(h).getRides().get(d));
											}
											System.out.println(numba + " tickets purhased for " + curAttendant.getCurPark().getArea().get(h).getRides().get(d).getAttName() + ".");
										}
										else {
											System.out.println("You do not have enough funds to purchase this many tickets for this ride.");
										}
									}
								}
								else {
									System.out.println("Improper ticket amount.");
								}		 
							}
							else {
								System.out.println("This ride does not exist in this park.");
							}
						}
					}
					
				}
				else if(ksel.compareTo("7") == 0) {//update account
					System.out.println("Goodbye!");
					kboard.close();
					loop = false;
				}
				else {
					System.out.println("Improper Input");				
				}
			}
		}
		System.out.println("Goodbye!");
		kboard.close();
		loop = false;
	}
		
	//END MAIN ============================================
	public void printWaitTimes() {
		for(int i = 0; i < curPark.getArea().size(); i = i+1) {
			System.out.println(curPark.getArea().get(i).getNameofSec());
			for (int j = 0; j < curPark.getArea().get(i).getRides().size(); j = j + 1) {				
				System.out.println("		" + curPark.getArea().get(i).getRides().get(j).getAttName() + " is a " + curPark.getArea().get(i).getRides().get(j).CalcWaitTime() + " minute wait in " + curPark.getArea().get(i).getNameofSec() );
			}
		}
	}
	public void printRestaurants() {
		for(int i = 0; i < curPark.getArea().size(); i = i+1) {
			System.out.println(curPark.getArea().get(i).getNameofSec());
			for (int j = 0; j < curPark.getArea().get(i).getRestaurants().size(); j = j + 1) {	
				System.out.println(("		" + curPark.getArea().get(i).getRestaurants().get(j).getAttName()));
			}
		}
	}
	public void printEvents() {
		for(int i = 0; i < curPark.getArea().size(); i = i+1) {
			System.out.println(curPark.getArea().get(i).getNameofSec());
			for (int j = 0; j < curPark.getArea().get(i).getEvents().size(); j = j + 1) {	
				System.out.println(("		" + curPark.getArea().get(i).getEvents().get(j).getAttName()));
			}
		}
	}
	//buying a ticket...
		public void purchaseTicket(Ride theRide) {
			System.out.println("Attempting to Purchase Ticket...");
			curAttendant.PurchaseTicket(theRide);
		}
	
//GETTERS AND SETTERS ===============================================================
	public Park getCurPark() {
		return curPark;
	}
	public void setCurPark(Park curPark) {
		this.curPark = curPark;
	}
	public Person getcurAttendant() {
		return curAttendant;
	}
	public void enterCustomer(Customer curAttendant) {
		this.curAttendant = curAttendant;
		System.out.println(curAttendant.getPersonNameF() +" is at a ParkSystem");
	}
	
	public Ride getCurRide() {
		return curRide;
	}
	public void setCurLocation(Ride curLocation) {
		this.curRide = curLocation;
	}

	public Events getCurEvent() {
		return curEvent;
	}

	public void setCurEvent(Events curEvent) {
		this.curEvent = curEvent;
	}
	
}
