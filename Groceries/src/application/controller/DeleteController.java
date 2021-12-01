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
import javafx.scene.control.Alert;
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
	TextField quantityText;
	
	@FXML
	TextField costText;
	
	@FXML
	TextField searchBar;
	
	@FXML
	Text messageText;
	
	public static int location;
	
	int flag = 0;
	
	public void firstScreen(ActionEvent event) {
		
		Parent root;
		
		
		try {
			root = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
			Main.stage.setScene(new Scene(root, 600,600));
			Main.stage.show();				

		} 
		catch(Exception e) {
				e.printStackTrace();
		}	
	}
	
	/**
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
	**/
	
	  public void search() {
        MainController.currentInventory = new ViewList();
        if (!searchBar.getText().isEmpty()) {

            int key = Integer.parseInt(searchBar.getText());
            int itemNum = Delete.find(key, MainController.currentInventory);
            if (itemNum == -1) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("This ID is Not Found");
                alert.showAndWait();

            } else {
                flag = 1;
                idText.setPromptText(MainController.currentInventory.getInventory().get(itemNum).getId()+"");
                nameText.setPromptText(MainController.currentInventory.getInventory().get(itemNum).getName());
                quantityText.setPromptText(MainController.currentInventory.getInventory().get(itemNum).getQuantity());
                costText.setPromptText(MainController.currentInventory.getInventory().get(itemNum).getPrice());
                
                location = itemNum;
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter ID");
            alert.showAndWait();
        }

    }

    public void delete() {
        if (location != -1 && flag != 0) {
            MainController.currentInventory.getInventory().remove(location);
            Update.updateCsv(MainController.currentInventory);
            messageText.setText("Successfully Deleted item!");
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("You have not an Id To Remove");
            alert.showAndWait();
        }
    }

}
