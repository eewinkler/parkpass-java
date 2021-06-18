package PACKAGE.PARKPASS.GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import PACKAGE.PARKPASS.ATTRACTIONS.Park;
import PACKAGE.PARKPASS.SYSTEM.BigSystem;
import PACKAGE.PARKPASS.SYSTEM.ParkCard;
import PACKAGE.PARKPASS.SYSTEM.ParkSystem;
import PACKAGE.PARKPASS.ATTRACTIONS.ParkSec;
import PACKAGE.PARKPASS.ATTRACTIONS.Ride;
import PACKAGE.PARKPASS.PEOPLE.Customer;
import PACKAGE.PARKPASS.PEOPLE.ManagementStaff;

public class TicketStationGUI extends Application {
	
	private static Park curPrk;
	private static ParkCard curUser;
	
	Stage window;
	Scene Main;
	Scene CAccount;
	ListView<String> UserTickets;
	ListView<String> UserFriends;
	
	
	public static void main(String[] args) {
		BigSystem sy = new BigSystem();
		sy.setCurDate(20191112); //setting time
		sy.setCurTime(800); //
		
		
		sy.ScanInCustomers("CustomersTest.txt");
		//all customers loaded in
		

		//MainSystem.ScanInPark("SpringFling");
		
    	Park testPark = new Park();
    	testPark.setParkName("Jurassic Park");
    	ParkSec testSec1 = new ParkSec();
    	testSec1.setNameofSec("Entrance Walkway");
    	ParkSec testSec2 = new ParkSec();
    	testSec2.setNameofSec("Zaboomoofu Forest");
    	ParkSec testSec3 = new ParkSec();
    	testSec3.setNameofSec("Space Base");
    	
    	
    	ParkSystem TicketBooth = new ParkSystem();
    	TicketBooth.setCurPark(testPark);
    	//TicketBooth.set
    	
    	
    	testPark.addArea(testSec1); //adds to section and the park
    	testPark.addArea(testSec2); //adds to section and the park
    	testPark.addArea(testSec3); //adds to section and the park
    	
    	//Ride(String name, Park bigpark, ParkSec parksection, boolean open, int durat, int numpeople, double cost, int mina, double minh) 
    	Ride Ride1 = new Ride("Decimator", testPark, testSec1, true, 15, 3, 6.50, 20, 0.0 );
    	Ride Ride2 = new Ride("Hype", testPark, testSec2, true, 20, 6, 6.50, 10, 0.0 );
    	Ride Ride3 = new Ride("Big Z", testPark, testSec3, false, 10, 2, 6.50, 10, 0.0 );
    	Ride Ride4 = new Ride("RumpleRide", testPark, testSec3, true, 10, 10, 6.50, 10, 0.0 );
    	//rides are all interconnected now
    	
    	
    	
    	//MANUAL
    	sy.addRegisteredPark(testPark);
    	
    	curPrk = testPark;
    	curUser = sy.getRegisteredCustomers().get(0).getCard();
		
		launch(args); //starts application
	}

	public void start(Stage primaryStage) throws Exception {
		//initialize the loginscreen!
		window = primaryStage;
		window.setTitle("MAIN MENU");
		
		
		//end of the setting up LOGIN SCREEN -----------------------
		// ---------------------------------------------------------
		
		//top menu
		BorderPane topMenu = new BorderPane();
		topMenu.setPadding(new Insets(10,10,10,10));
		
		VBox Acc = new VBox();
		Acc.setPadding(new Insets(10,10,10,10));
		
		Label Ac1 = new Label(curUser.getNameID() );
		Label Ac2 = new Label(curUser.getCardOwner().getPersonNameF() + ", " +curUser.getCardOwner().getPersonNameL() );
		Label Ac3 = new Label("ParkBucks: $" + curUser.getParkBucks() +"0" );
		Acc.getChildren().addAll(Ac1,Ac2, Ac3);
		topMenu.setLeft(Acc);
		
		HBox mb = new HBox();
		Button btn1 = new Button("Edit Account");
		btn1.setOnAction(e -> { 
			
		});
		Button btn11 = new Button("Upgrade Account");
		Button btn111 = new Button("Add Funds");
		btn1.setOnAction(e -> { 
			
			//curUser.addBalance(ammount);
		});
		mb.getChildren().addAll(btn1,btn11,btn111);
		topMenu.setBottom(mb);
		
		//left menu tickets
		VBox leftMenu = new VBox(5);
		leftMenu.setPadding(new Insets(10,10,10,10));
		UserTickets = new ListView<>();	
		Label a1 = new Label ("My Purchased Tickets: ");
		Button btn2 = new Button("Purchase Ticket");
		btn2.setOnAction(e -> {
			PurchaseTicketGUI.display(curUser, curPrk);
		});
		Button btn22 = new Button("Transfer Ticket");
		Button btn222 = new Button("Add Funds");
		Button btn2222 = new Button("Transfer Funds");
		leftMenu.getChildren().addAll(a1, btn2, btn22,btn222,btn2222, UserTickets);
		
		
		//right menu friends
		VBox rightMenu = new VBox(5);
		rightMenu.setPadding(new Insets(10,10,10,10));
		UserFriends = new ListView<>();
		Label a2 = new Label ("My Registered Friends: ");
		Button btn3 = new Button("Add Friends");
		Button btn33 = new Button("Remove Friends");
		Button btn333 = new Button("Transfer Funds");
		Button btn3333 = new Button("Transfer Ticket");
		rightMenu.getChildren().addAll(a2,btn3,btn33,btn333,btn3333, UserFriends);
		
		//set up home screen
		BorderPane boderPane = new BorderPane();
		boderPane.setTop(topMenu);
		boderPane.setLeft(leftMenu);
		boderPane.setRight(rightMenu);
		Scene Main = new Scene(boderPane, 1000, 500);
		
		//error displaying next scene
		window.setScene(Main);
		window.show();
		
		
	}

	
	
//	private boolean isInt(TextField input, String message) {
//		try {
//			int age = Integer.parseInt(input.getText() );
//			return true;
//		
//		} catch (NumberFormatException e){
//			return false;
//		}
//	}
}
