package PACKAGE.PARKPASS.GUI;

import PACKAGE.PARKPASS.ATTRACTIONS.Attraction;
import PACKAGE.PARKPASS.ATTRACTIONS.Park;
import PACKAGE.PARKPASS.ATTRACTIONS.Ride;
import PACKAGE.PARKPASS.SYSTEM.ParkCard;
import PACKAGE.PARKPASS.SYSTEM.TicketSingle;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class PurchaseTicketGUI {

	//calling:
	//button.setOnAction(e -> AlertBox.display("title of window", "Message"));
	public static void display(ParkCard curCust, Park curpark) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Purchase Ticket");
		window.setMinWidth(250);
		Label label1 = new Label();
		label1.setText("Please select ride below: ");
		ChoiceBox<String> dropdown1 = new ChoiceBox<>();
		for (int i = 0; i < curpark.getAttractions().size(); i++) {
			dropdown1.getItems().add( curpark.getAttractions().get(i).getAttName() );
		}
		
		
		Label label2 = new Label();
		label2.setText("How many tickets would you like for this ride?");
		ChoiceBox<String> dropdown2 = new ChoiceBox<>();
		for (int i = 1; i < 6; i++) {
			dropdown2.getItems().add(Integer.toString(i));
		}
		
		Button closeButton = new Button("Cancel");
		closeButton.setOnAction(e -> window.close());//window.fireEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST))); 
		
		Button purchaseFinal = new Button("Purchase");
		purchaseFinal.setOnAction(e -> {
			if(ConfirmationBox.display("Confirmation", "Are you sure you would like to buy " + dropdown2.getValue() + " tickets for " + dropdown1.getValue() + " for " + (getRideCost(dropdown1.getValue(), curpark)*Integer.parseInt(dropdown2.getValue()) + " ParkBucks?")) == true){
				if (curCust.CheckPB(Integer.parseInt(dropdown2.getValue())) == true) {
					curCust.subBalance(getRideCost(dropdown1.getValue(), curpark)*Integer.parseInt(dropdown2.getValue()));
					for (int j = 1; j <= Integer.parseInt(dropdown2.getValue()); j++) {
						TicketSingle temp = new TicketSingle();
			    		temp.setRideTicket(getRide(dropdown2.getValue(), curpark));
			    		curCust.getParkCardTickets().add(temp);
					}
					
					AlertBox.display("Purchase Successful", "Ticket(s) have been added to your account.");
				}
				else {
					AlertBox.display("Purchase Failed", "You do not currently have enough ParkBucks for this purchase.");
				}
			}

		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label1, dropdown1, label2, dropdown2, purchaseFinal, closeButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		
//		window.setOnCloseRequest(new EventHandler<WindowEvent>() {
//			public void handle(WindowEvent we) {
//				window.fireEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST));
//			}
//		});
//		
		window.showAndWait();
		
	}
	
	public void getChoice(ChoiceBox<String> choice) {
		String option = choice.getValue();
	}
	
	public static double getRideCost(String name, Park curparks) {
		for (int y = 0; y < curparks.getArea().size(); y++) {
			for (int z = 0; z < curparks.getArea().get(y).getRides().size(); z++) {
				if (name == curparks.getArea().get(y).getRides().get(z).getAttName()) {
					return curparks.getArea().get(y).getRides().get(z).getSingleTicketCost();
				}
			}
		}
		return 0.0;
	}
	
	public static Attraction getRide(String name, Park curparks) {
		for (int y = 0; y < curparks.getArea().size(); y++) {
			for (int z = 0; z < curparks.getArea().get(y).getRides().size(); z++) {
				if (name == curparks.getArea().get(y).getRides().get(z).getAttName()) {
					return curparks.getArea().get(y).getRides().get(z);
				}
			}
		}
		return null;
	}
}
