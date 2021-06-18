package PACKAGE.PARKPASS.GUI;

import PACKAGE.PARKPASS.SYSTEM.BigSystem;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginGUI extends Application {
	Stage window;
	Scene Login;
	static BigSystem main;

	public static void main(String[] args) {
		//main = maen; //passes in the database
		launch(args); //starts application
	}

	public void start(Stage primaryStage) throws Exception {
		//initialize the loginscreen!
		window = primaryStage;
		window.setTitle("LOGIN");
		
		GridPane Logrid = new GridPane();
		Logrid.setPadding(new Insets(10,10,10,10)); //side cussion
		Logrid.setVgap(8); //vertical gap
		Logrid.setHgap(10); //horizontal gap
		
		
		//Name label
		Label LoginnameLabel = new Label ("Username: ");
		GridPane.setConstraints(LoginnameLabel, 0, 0); //appear in top left
		
		//name input
		TextField LoginnameInput = new TextField("Default text");
		GridPane.setConstraints(LoginnameInput, 1, 0);
		
		//password label
		Label LoginpassLabel = new Label ("Password: ");
		GridPane.setConstraints(LoginpassLabel, 0, 1); //appear in top left
		
		//password input
		TextField LoginpassInput = new TextField();
		LoginpassInput.setPromptText("Password");
		GridPane.setConstraints(LoginpassInput, 1, 1);
		
		Button loginbutton = new Button("Login");
		loginbutton.setOnAction(e -> { //upon sucsessful login go to the main menu
			AlertBox.display("title of window", "Message");
			for(int i = 0; i < main.getRegisteredStaff().size(); i++) {
				if( main.getRegisteredStaff().get(i).getCard().getPassword().compareTo( LoginpassInput.getText() ) == 0 ) {
					if( main.getRegisteredStaff().get(i).getCard().getNameID().compareTo( LoginnameInput.getText() ) == 0 ) {
						//is a staff member launch staff gui
						
					}
				}
			}
			
			//check through customers
			for(int i = 0; i < main.getRegisteredStaff().size(); i++) {
				if( main.getRegisteredCustomers().get(i).getCard().getPassword().compareTo( LoginpassInput.getText() ) == 0 ) {
					if( main.getRegisteredCustomers().get(i).getCard().getNameID().compareTo( LoginnameInput.getText() ) == 0 ) {
						//customer exists
						
					}
				}
			}
			
			//if person does not exist...
			
			
		});
		GridPane.setConstraints(loginbutton, 1, 2);
		
		//adding buttons
		Logrid.getChildren().addAll(LoginnameLabel, LoginnameInput, LoginpassLabel, LoginpassInput, loginbutton);

		//space for number pannel
		
		
		
		
		BorderPane Loginbp = new BorderPane();
		Loginbp.setCenter(Logrid); //sets center to be the pasword stuff
		Logrid.setAlignment(Pos.CENTER); //centers the login!!
		
		
		Scene Login = new Scene(Loginbp, 1000, 500);
		window.setScene(Login);
		window.show();
		//end of the setting up LOGIN SCREEN -----------------------
		// -----------------------------------------------
	}
}
