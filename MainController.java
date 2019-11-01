/**
 * Sample Skeleton for 'Main.fxml' Controller Class
 */

package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button General;

    @FXML
    private Button Private;

    @FXML
    public void GeneralView(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("Public.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    	
    }

    @FXML
    public void PrivateView(ActionEvent event) throws IOException {
    	Parent pane1=FXMLLoader.load(getClass().getResource("Private.fxml"));
    	Scene scene1=new Scene(pane1);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene1);
    	window.show();
    }

    @FXML
    void initialize() {
        assert General != null : "fx:id=\"General\" was not injected: check your FXML file 'Main.fxml'.";
        assert Private != null : "fx:id=\"Private\" was not injected: check your FXML file 'Main.fxml'.";

    }
}


