package application.controller;

import application.Main;
import application.model.Item;
import application.model.Update;
import application.model.ViewList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UpdateController {
	
	@FXML
	TextField idText;
	
	@FXML
	TextField nameText;
	
	@FXML
	Button updateButton;
	
	//public static ViewList currentInventory;
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
		
		int key = Integer.parseInt(idText.getText());
		int itemNum = Update.find(key,MainController.currentInventory);
		
		if(itemNum == -1) {
			
			System.out.println("NOT FOUND\n");
		}
		else {
			
			
			Item found = MainController.currentInventory.getInventory().get(itemNum);
			location = itemNum;
			nameText.setText(found.getName());
			
		}
		
	}
	
	public void update() {
		
		MainController.currentInventory.getInventory().get(location).setName(nameText.getText());
		System.out.println("updating");
		Update.updateCsv(MainController.currentInventory);
		System.out.println("updating");
		
		
	}
	
	
	
}
