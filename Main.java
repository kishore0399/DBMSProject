
package application;
	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			Parent root=FXMLLoader.load(Main.class.getResource("/application/Main.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(true);
			primaryStage.show();
			primaryStage.setTitle("BLOOD BANK MANAGING SYSTEM");
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*public static  Connection getConnection() throws Exception {
		try {
			String driver="com.mysql.jdbc.Driver";
			String url="jdbc:mysql//localhost/database";
		}
		
		return null;
		
	}*/
	public static void main(String[] args) {
		launch(args);
	}
}
