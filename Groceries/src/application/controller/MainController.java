package application.controller;

import application.Main;
import application.model.ViewList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {
	
	@FXML
	Button createButton;
	
	@FXML
	Button updateButton;
	
	@FXML
	Button viewButton;
	
	@FXML
	Button deleteButton;
	

	public static ViewList currentInventory ;
	public static Stage stage;
	
	public void intitialize() {
		
		//currentInventory = new ViewList();
		
	}
	
	public void createPage(ActionEvent event) {

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../view/Create.fxml"));
			Main.stage.setScene(new Scene(root, 600,600));
			Main.stage.show();				

		} 
		catch(Exception e) {
				e.printStackTrace();
		}	
	}
	
	public void updatePage(ActionEvent event) {

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../view/Update.fxml"));
			Main.stage.setScene(new Scene(root, 600,600));
			Main.stage.show();				

		} 
		catch(Exception e) {
				e.printStackTrace();
		}	
	}
	public void viewPage(ActionEvent event) {

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../view/ViewList.fxml"));
			Main.stage.setScene(new Scene(root, 600,600));
			Main.stage.show();				

		} 
		catch(Exception e) {
				e.printStackTrace();
		}	
	}
	
	public void deletePage(ActionEvent event) {

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../view/Delete.fxml"));
			Main.stage.setScene(new Scene(root, 600,600));
			Main.stage.show();				

		} 
		catch(Exception e) {
				e.printStackTrace();
		}	
	}
	

}
