package application.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javafx.geometry.Insets;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CreateController {
	
	@FXML
	Button home;
	
	@FXML
	TextField idText;
	
	@FXML
	TextField nameText;
	

	public void initialize() {
		
	}
	
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
	
	public void addItem() {
		
		String newId = new String();
		newId = idText.getText();
		
		String newName = new String();
		newName = nameText.getText();
		
		System.out.println(newId + " "+ newName);
		
		try {
			Files.write(Paths.get("data/groceries.csv"), (newId+","+newName+"\n").getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
