package PACKAGE.PARKPASS.GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmationBox {
	//calling:
	//button.setOnAction(e -> {
	//		boolean result = ConfirmBox.display("title of window", "Message");
	//});
	
	static boolean Answer;
	
	public static boolean display(String title, String message) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		Label label = new Label();
		label.setText(message);
		
		//two buttons
		Button yesButton = new Button("Yes");
		Button NoButton = new Button("No");
		Button closeButton = new Button("Cancel");
		closeButton.setOnAction(e -> {
			Answer = false;
			window.close(); 
		});
		
		yesButton.setOnAction(e -> {
			Answer = true;
			window.close();
		});
		
		NoButton.setOnAction(e -> {
			Answer = false;
			window.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, yesButton, NoButton, closeButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		return Answer;
		
	}
}
