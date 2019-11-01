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

	public class UpdateBloodDetails {

	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private TextField HospitalID;

	    @FXML
	    private TextField bloodGroup;

	    @FXML
	    private TextField bloodQuantity;

	    @FXML
	    private TextField hospitalID;

	    @FXML
	    private TableView<BloodTable> tableBlood;

	    @FXML
	    private TableColumn<BloodTable, ?> colBloodGroup;

	    @FXML
	    private TableColumn<BloodTable, ?> colQuantity;
	    
	    ObservableList<BloodTable> view;
	    
	    Connection con;
	    void createConnection() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank?useSSL=false&serverTimezone=UTC","root","");
			} catch (ClassNotFoundException e) {
				e.printStackTrace(); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	    @FXML
	    void goBack(ActionEvent event) throws IOException {
	    	Parent pane=FXMLLoader.load(getClass().getResource("Hospital.fxml"));
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
	    	String id=HospitalID.getText();
	    	//double quan=bloodQuantity.getTypeSelector();
	    }

	    @FXML
	    void viewDetails(ActionEvent event) {
	    	String id=hospitalID.getText();
	    	try {
	    		createConnection();
	    		view=FXCollections.observableArrayList();
	    		String sql="Select * from hospitalblood  where hospital_id='"+id+"'";
	    	PreparedStatement stmt=con.prepareStatement(sql);
	    	ResultSet rs;
	    		rs = stmt.executeQuery();
	    	
	    	while(rs.next()) {
	    		view.add(new BloodTable(rs.getString(1),rs.getDouble(2)));
	        }
	        	colBloodGroup.setCellValueFactory(new PropertyValueFactory<>("Blood"));
	        	colQuantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
	        	tableBlood.setItems(view);
	        	}
	         catch (SQLException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}

	    }

	    @FXML
	    void initialize() {
	        assert HospitalID != null : "fx:id=\"HospitalID\" was not injected: check your FXML file 'updateBlood.fxml'.";
	        assert bloodGroup != null : "fx:id=\"bloodGroup\" was not injected: check your FXML file 'updateBlood.fxml'.";
	        assert bloodQuantity != null : "fx:id=\"bloodQuantity\" was not injected: check your FXML file 'updateBlood.fxml'.";
	        assert hospitalID != null : "fx:id=\"hospitalID\" was not injected: check your FXML file 'updateBlood.fxml'.";
	        assert tableBlood != null : "fx:id=\"tableBlood\" was not injected: check your FXML file 'updateBlood.fxml'.";
	        assert colBloodGroup != null : "fx:id=\"colBloodGroup\" was not injected: check your FXML file 'updateBlood.fxml'.";
	        assert colQuantity != null : "fx:id=\"colQuantity\" was not injected: check your FXML file 'updateBlood.fxml'.";

	    }
	

}

