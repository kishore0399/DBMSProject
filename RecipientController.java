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

public class RecipientController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField recipientBlood;

    @FXML
    private TextField recipientCity;

    @FXML
    private TableView<ListBoth> recipientTable;
    @FXML
    private TableColumn<ListBoth, String> colID;

    @FXML
    private TableColumn<ListBoth, String> colCity;

    @FXML
    private TableColumn<ListBoth, Long> colContact;

    @FXML
    private TableColumn<ListBoth, String> colManager;
    
    ObservableList<ListBoth>Donor;
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
    void Home(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("Home.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

    @FXML
    void Search(ActionEvent event) {
    	String blood=recipientBlood.getText();
    	String city=recipientCity.getText();
    	
    	try {
    		createConnection();
        	Donor=FXCollections.observableArrayList();
    		String sql="Select H.hospital_name,H.hospital_city,H.hospital_number,M.manager_name from hospital H,manager M,hospitalblood B  where H.hospital_id=B.hospital_id A AND M.hospital_id=H.hospital_id AND B.blood_type='"+blood+"' AND H.hospital_city='"+city+"' ";
    	PreparedStatement stmt=con.prepareStatement(sql);
    	ResultSet rs;
    		rs = stmt.executeQuery();
    	
    	while(rs.next()) {
    		Donor.add(new ListBoth(rs.getString(1),rs.getString(2), rs.getLong(3), rs.getString(4)));
        }
        	colID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        	colCity.setCellValueFactory(new PropertyValueFactory<>("City"));
        	colContact.setCellValueFactory(new PropertyValueFactory<>("Number"));
        	colManager.setCellValueFactory(new PropertyValueFactory<>("Manager"));
        	recipientTable.setItems(Donor);
        	}
         catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	
    }

    @FXML
    void goBack2(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("Public.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

    @FXML
    void initialize() {
        assert recipientBlood != null : "fx:id=\"recipientBlood\" was not injected: check your FXML file 'Recipient.fxml'.";
        assert recipientCity != null : "fx:id=\"recipientCity\" was not injected: check your FXML file 'Recipient.fxml'.";
        assert recipientTable != null : "fx:id=\"recipientTable\" was not injected: check your FXML file 'Recipient.fxml'.";

    }
}
