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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class BankDonors {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<BankDonorsList> bankDonor;

    @FXML
    private Label bloodbankName;

    @FXML
    private TextField search;

    @FXML
    private TextField ownID;
    
    @FXML
    private TableColumn<BankDonorsList, String> coloName;

    @FXML
    private TableColumn<BankDonorsList, Number > colAge;

    @FXML
    private TableColumn<BankDonorsList, String> colCity;

    @FXML
    private TableColumn<BankDonorsList, Long> colContact;

    @FXML
    private TableColumn<BankDonorsList, String> colBlood;

    @FXML
    private TableColumn<BankDonorsList, String> colDate;
    
    ObservableList<BankDonorsList> details;
    
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
    void addDonors(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("BankDonorEntry.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    
    @FXML
    void goManagers(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("ManagerEntry.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    
    @FXML
    void goBank(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("HospitalBank.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    @FXML
    void goBackPrivate1(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("Private.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

    @FXML
    void goHospitals(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("BankHospitals.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

    @FXML
    void listDonors(ActionEvent event) {
    	String id=ownID.getText();
    	try {
    		createConnection();
        	details=FXCollections.observableArrayList();
    		String sql="Select * from donor  where bank_id='"+id+"'";
    	PreparedStatement stmt=con.prepareStatement(sql);
    	ResultSet rs;
    		rs = stmt.executeQuery();
    	
    	while(rs.next()) {
    		details.add(new BankDonorsList(rs.getString(2),rs.getInt(3), rs.getString(7), rs.getLong(6), rs.getString(5),rs.getString(11)));
        }
        	coloName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        	colAge.setCellValueFactory(new PropertyValueFactory<>("Age"));
        	colCity.setCellValueFactory(new PropertyValueFactory<>("City"));
        	colContact.setCellValueFactory(new PropertyValueFactory<>("Number"));
        	colBlood.setCellValueFactory(new PropertyValueFactory<>("Blood"));
        	colDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        	bankDonor.setItems(details);
        	}
         catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }

    @FXML
    void searchBlood(ActionEvent event) {
    	String id=ownID.getText();
    	String blood=search.getText();
    	try {
    		createConnection();
        	details=FXCollections.observableArrayList();
    		String sql="Select * from donor  where bank_id='"+id+"' AND donor_blood='"+blood +"'";
    	PreparedStatement stmt=con.prepareStatement(sql);
    	ResultSet rs;
    		rs = stmt.executeQuery();
    	
    	while(rs.next()) {
    		details.add(new BankDonorsList(rs.getString(2),rs.getInt(3), rs.getString(7), rs.getLong(6), rs.getString(5),rs.getString(11)));
        }
        	coloName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        	colAge.setCellValueFactory(new PropertyValueFactory<>("Age"));
        	colCity.setCellValueFactory(new PropertyValueFactory<>("City"));
        	colContact.setCellValueFactory(new PropertyValueFactory<>("Number"));
        	colBlood.setCellValueFactory(new PropertyValueFactory<>("Blood"));
        	colDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        	bankDonor.setItems(details);
        	}
         catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
    
    @FXML
    void viewBlood(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("BankBloodDetails.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

    @FXML
    void initialize() {
        assert bankDonor != null : "fx:id=\"bankDonor\" was not injected: check your FXML file 'BankDonors.fxml'.";
        assert bloodbankName != null : "fx:id=\"bloodbankName\" was not injected: check your FXML file 'BankDonors.fxml'.";
        assert search != null : "fx:id=\"search\" was not injected: check your FXML file 'BankDonors.fxml'.";
        assert ownID != null : "fx:id=\"ownID\" was not injected: check your FXML file 'BankDonors.fxml'.";

    }
}
