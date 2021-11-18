package application;
	
import application.model.ViewList;
//import application.model.SiteUsers;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	public static Stage stage;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = new AnchorPane();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("view/Main.fxml") );
			root = (AnchorPane) loader.load();
			
			Scene scene = new Scene( root );
			primaryStage.setScene( scene );
			primaryStage.show();
			
		//	all = new SiteUsers();
			stage = primaryStage;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
