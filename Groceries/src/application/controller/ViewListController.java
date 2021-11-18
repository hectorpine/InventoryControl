package application.controller;

import application.Main;
import application.model.ViewList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;

public class ViewListController {
	
	@FXML
	TextArea listArea;

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
	
	public void initialize() {
		
		ViewList inventory = new ViewList();
		System.out.println(inventory.toString());
		listArea.setText(inventory.toString());
		
	}

	public TextArea getListArea() {
		return listArea;
	}

	public void setListArea(TextArea listArea) {
		this.listArea = listArea;
	}
	
	
	
}






