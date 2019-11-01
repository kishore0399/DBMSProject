package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class BankBloodController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<BloodTable2> tableBlood;

    @FXML
    private TableColumn<BloodTable2, String> colBloodGroup;

    @FXML
    private TableColumn<BloodTable2, String> colQuantity;

    @FXML
    private TableColumn<BloodTable2, String> colCost;

    	ObservableList<BloodTable2> view;
    	
    	 Connection con;
 	    void createConnection() {
 			try {
 				Class.forName("com.mysql.jdbc.Driver");
 				 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank?useSSL=false&serverTimezone=UTC","root"," ");
 			} catch (ClassNotFoundException e) {
 				e.printStackTrace(); 
 			} catch (SQLException e) {
 				e.printStackTrace();
 			}
 		}
    
    @FXML
    private TextField bankID;

    @FXML
    private TextField bloodGroup;

    @FXML
    private TextField bloodQuantity;

    @FXML
    private TextField BankID;

    @FXML
    private TextField bloodCost;

    @FXML
    void goBack(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("BankDonors.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

    @FXML
    void logOut(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("Main.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

    @FXML
    void updateDetails(ActionEvent event) {
    	String id=bankID.getText();
    	String blood=bloodGroup.getText();
    	//double quantity=bloodQuantity.;
    	//int cost=bloodCost.getAnchor();
    }

    @FXML
    void viewDetails(ActionEvent event) {
    	String id=BankID.getText();
    	try {
    		createConnection();
    		view=FXCollections.observableArrayList();
    		String sql="Select * from bankblood  where bank_id='"+id+"'";
    	PreparedStatement stmt=con.prepareStatement(sql);
    	ResultSet rs;
    		rs = stmt.executeQuery();
    	
    	while(rs.next()) {
    		view.add(new BloodTable2(rs.getString(1),rs.getDouble(2),rs.getInt(3)));
        }
        	colBloodGroup.setCellValueFactory(new PropertyValueFactory<>("Blood"));
        	colQuantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        	colCost.setCellValueFactory(new PropertyValueFactory<>("Cost"));

        	tableBlood.setItems(view);
        	}
         catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }

    @FXML
    void initialize() {
        assert tableBlood != null : "fx:id=\"tableBlood\" was not injected: check your FXML file 'BankBloodDetails.fxml'.";
        assert colBloodGroup != null : "fx:id=\"colBloodGroup\" was not injected: check your FXML file 'BankBloodDetails.fxml'.";
        assert colQuantity != null : "fx:id=\"colQuantity\" was not injected: check your FXML file 'BankBloodDetails.fxml'.";
        assert colCost != null : "fx:id=\"colCost\" was not injected: check your FXML file 'BankBloodDetails.fxml'.";
        assert bankID != null : "fx:id=\"bankID\" was not injected: check your FXML file 'BankBloodDetails.fxml'.";
        assert bloodGroup != null : "fx:id=\"bloodGroup\" was not injected: check your FXML file 'BankBloodDetails.fxml'.";
        assert bloodQuantity != null : "fx:id=\"bloodQuantity\" was not injected: check your FXML file 'BankBloodDetails.fxml'.";
        assert BankID != null : "fx:id=\"BankID\" was not injected: check your FXML file 'BankBloodDetails.fxml'.";
        assert bloodCost != null : "fx:id=\"bloodCost\" was not injected: check your FXML file 'BankBloodDetails.fxml'.";

    }
}
