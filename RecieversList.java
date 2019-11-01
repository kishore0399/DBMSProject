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

public class RecieversList {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<HospitalReceivers> hospitalReceivers;

    @FXML
    private Label hospitalName;

    @FXML
    private TextField Search;

    @FXML
    private TextField hospitalID;
    
    @FXML
    private TableColumn<HospitalReceivers, String> colName;

    @FXML
    private TableColumn<HospitalReceivers, Integer> colAge;

    @FXML
    private TableColumn<HospitalReceivers, String> colSex;

    @FXML
    private TableColumn<HospitalReceivers, String> colDate;

    @FXML
    private TableColumn<HospitalReceivers, Long> colContact;

    @FXML
    private TableColumn<HospitalReceivers, String> colBlood;
    
    ObservableList<HospitalReceivers> receiver;
    
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
    void goBackPrivate1(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("Private.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    
    @FXML
    void addRecipient(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("HospitalDonorEntry.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

  

    @FXML
    void goDonors(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("Hospital.fxml"));
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
    void searchGroup(ActionEvent event) {
    	String bloodGroup=Search.getText();
    	
    	try {
    		createConnection();
    		receiver=FXCollections.observableArrayList();
    		String sql="Select * from hospitalblood  where hospital_id='"+null+"'";
    	PreparedStatement stmt=con.prepareStatement(sql);
    	ResultSet rs;
    		rs = stmt.executeQuery();
    	
    	while(rs.next()) {
    		receiver.add(new HospitalReceivers(rs.getString(1),0, rs.getString(2), sql, null, sql));
        }
        	colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        	colAge.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        	colSex.setCellValueFactory(new PropertyValueFactory<>("name"));
        	colDate.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        	colContact.setCellValueFactory(new PropertyValueFactory<>("name"));
        	colBlood.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        	hospitalReceivers.setItems(receiver);
        	}
         catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }

    @FXML
    void searchReceivers(ActionEvent event) {
    	String id=hospitalID.getText();
    	
    	try {
    		createConnection();
    		receiver=FXCollections.observableArrayList();
    		String sql="Select * from hospitalblood  where hospital_id='"+id+"'";
    	PreparedStatement stmt=con.prepareStatement(sql);
    	ResultSet rs;
    		rs = stmt.executeQuery();
    	
    	while(rs.next()) {
    		receiver.add(new HospitalReceivers(rs.getString(1),0, rs.getString(2), sql, null, sql));
        }
        	colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        	colAge.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        	colSex.setCellValueFactory(new PropertyValueFactory<>("name"));
        	colDate.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        	colContact.setCellValueFactory(new PropertyValueFactory<>("name"));
        	colBlood.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        	hospitalReceivers.setItems(receiver);
        	}
         catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }

    @FXML
    void initialize() {
        assert hospitalReceivers != null : "fx:id=\"hospitalReceivers\" was not injected: check your FXML file 'HospitalRecipient.fxml'.";
        assert hospitalName != null : "fx:id=\"hospitalName\" was not injected: check your FXML file 'HospitalRecipient.fxml'.";
        assert Search != null : "fx:id=\"Search\" was not injected: check your FXML file 'HospitalRecipient.fxml'.";
        assert hospitalID != null : "fx:id=\"hospitalID\" was not injected: check your FXML file 'HospitalRecipient.fxml'.";

    }
}
