package application.controller;

import application.Main;
import application.model.Delete;
import application.model.Update;
import application.model.ViewList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class DeleteController {
	
	@FXML
	Button homeButton;
	
	@FXML
	Button searchButton;
	
	@FXML
	TextField idText;
	
	@FXML
	TextField nameText;
	
	@FXML
	TextField searchBar;
	
	@FXML
	Text messageText;
	
	public static int location;
	
	public void firstScreen(ActionEvent event) {
		
		Parent root;
		
		
		try {
			root = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
			Main.stage.setScene(new Scene(root, 800,800));
			Main.stage.show();				

		} 
		catch(Exception e) {
				e.printStackTrace();
		}	
	}
	public void search() {
		MainController.currentInventory = new ViewList();
		
		int key = Integer.parseInt(searchBar.getText());
		
		int itemNum = Delete.find(key,MainController.currentInventory);
		if(itemNum == -1) {
			
			System.out.println("NOT FOUND\n");
		}
		else {
			
			
			nameText.setPromptText(MainController.currentInventory.getInventory().get(itemNum).getName());
			location = itemNum;
			
		}
		
	}
	
	public void delete() {
		
		if(location != -1) {
			
			MainController.currentInventory.getInventory().remove(location);
			Update.updateCsv(MainController.currentInventory);
			messageText.setText("Successfully Deleted item!");
		}
		

		
		
	}

}
