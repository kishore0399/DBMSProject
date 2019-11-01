package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddDetailsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label hospitalName;

    @FXML
    private TextField donorID;

    @FXML
    private TextField donorName;

    @FXML
    private TextField donorAge;

    @FXML
    private TextField donorSex;

    @FXML
    private TextField donorContact;

    @FXML
    private TextField donorCity;

    @FXML
    private TextField donorPassword;

    @FXML
    private TextField hospitalID;

    @FXML
    private TextField donorDate;

    @FXML
    private TextField recipientID;

    @FXML
    private TextField recipientName;

    @FXML
    private TextField recipientAge;

    @FXML
    private TextField recipientSex;

    @FXML
    private TextField recipientCity;

    @FXML
    private TextField recipientContact;

    @FXML
    private TextField recipientBlood;

    @FXML
    private TextField HospitalID;

    @FXML
    private TextField recipientDate;

    @FXML
    private TextField donorBlood;
    
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
    void donorDetails(ActionEvent event) {
    	createConnection();
    	String id=donorID.getText();
	    String name=donorName.getText();
	    String donor_age=donorAge.getText();
	    String sex=donorSex.getText();
	    String city=donorCity.getText();
	    String blood_type=donorBlood.getText();
	    //String bank_id=donor_bank.getText();
	    String hospital_id=hospitalID.getText();
	    long phone=Long.valueOf( donorContact.getText());
	    String passw=donorPassword.getText();
	    //String passwordCheck=password_check.getText();
	    String donated=donorDate.getText();
    	if(!id.equals(null)) {
    		//System.out.println("Success");
    		try {
				PreparedStatement stmt=con.prepareStatement("INSERT INTO  donor VALUES(?,?,?,?,?,?,?,?,?,?,?)");
				stmt.setString(1, id);
				stmt.setString(2, name);
				stmt.setString(3, donor_age);
				stmt.setString(4, sex);
				stmt.setString(5, city);
				stmt.setLong(6, phone);
				stmt.setString(7, blood_type);
				stmt.setString(8,passw);
				stmt.setString(9,hospital_id);
				stmt.setString(10,null);
				stmt.setString(11,donated);
				stmt.execute();
				System.out.println("VALUES ENTERED");
				stmt.close();
    		} catch (SQLException e) {
				System.out.println("ERROR"+e);
			}
    		
    	}
    	else {
    		System.out.println("Fail");
    	}
    }

    @FXML
    void recipientDetails(ActionEvent event) {
    	String id1=recipientID.getText();
	    String name1=recipientName.getText();
	    String reciever_age=recipientAge.getText();
	    String sex1=recipientSex.getText();
	    String city1=recipientCity.getText();
	    String blood_type1=recipientBlood.getText();
	    //String bank_id=donor_bank.getText();
	    String hospital_id1=HospitalID.getText();
	    long phone1=Long.valueOf( recipientContact.getText());
	    //String passw=donorPassword.getText();
	    //String passwordCheck=password_check.getText();
	    String donated1=recipientDate.getText();
    	if(!id1.equals(null)) {
    		//System.out.println("Success");
    		try {
				PreparedStatement stmt=con.prepareStatement("INSERT INTO  recipient VALUES(?,?,?,?,?,?,?,?,?)");
				stmt.setString(1, id1);
				stmt.setString(2, name1);
				stmt.setString(3, reciever_age);
				stmt.setString(4, sex1);
				stmt.setString(5, city1);
				stmt.setLong(6, phone1);
				stmt.setString(7, blood_type1);
				//stmt.setString(8,passw);
				stmt.setString(8,hospital_id1);
			//	stmt.setString(10,null);
				stmt.setString(9,donated1);
				stmt.execute();
				System.out.println("VALUES ENTERED");
				stmt.close();
    		} catch (SQLException e) {
				System.out.println("ERROR"+e);
			}
    		catch (Exception e) {
				System.out.println("ERROR"+e);
			}
    		
    	}
    }
    
    @FXML
    void goBack(ActionEvent event) throws Exception {
    	Parent pane=FXMLLoader.load(getClass().getResource("Hospital.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

    @FXML
    void logOut(ActionEvent event) throws Exception {
    	Parent pane=FXMLLoader.load(getClass().getResource("Main.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

    @FXML
    void initialize() {
        assert hospitalName != null : "fx:id=\"hospitalName\" was not injected: check your FXML file 'HospitalDonorEntry.fxml'.";
        assert donorID != null : "fx:id=\"donorID\" was not injected: check your FXML file 'HospitalDonorEntry.fxml'.";
        assert donorName != null : "fx:id=\"donorName\" was not injected: check your FXML file 'HospitalDonorEntry.fxml'.";
        assert donorAge != null : "fx:id=\"donorAge\" was not injected: check your FXML file 'HospitalDonorEntry.fxml'.";
        assert donorSex != null : "fx:id=\"donorSex\" was not injected: check your FXML file 'HospitalDonorEntry.fxml'.";
        assert donorContact != null : "fx:id=\"donorContact\" was not injected: check your FXML file 'HospitalDonorEntry.fxml'.";
        assert donorCity != null : "fx:id=\"donorCity\" was not injected: check your FXML file 'HospitalDonorEntry.fxml'.";
        assert donorPassword != null : "fx:id=\"donorPassword\" was not injected: check your FXML file 'HospitalDonorEntry.fxml'.";
        assert hospitalID != null : "fx:id=\"hospitalID\" was not injected: check your FXML file 'HospitalDonorEntry.fxml'.";
        assert donorDate != null : "fx:id=\"donorDate\" was not injected: check your FXML file 'HospitalDonorEntry.fxml'.";
        assert recipientID != null : "fx:id=\"recipientID\" was not injected: check your FXML file 'HospitalDonorEntry.fxml'.";
        assert recipientName != null : "fx:id=\"recipientName\" was not injected: check your FXML file 'HospitalDonorEntry.fxml'.";
        assert recipientAge != null : "fx:id=\"recipientAge\" was not injected: check your FXML file 'HospitalDonorEntry.fxml'.";
        assert recipientSex != null : "fx:id=\"recipientSex\" was not injected: check your FXML file 'HospitalDonorEntry.fxml'.";
        assert recipientCity != null : "fx:id=\"recipientCity\" was not injected: check your FXML file 'HospitalDonorEntry.fxml'.";
        assert recipientContact != null : "fx:id=\"recipientContact\" was not injected: check your FXML file 'HospitalDonorEntry.fxml'.";
        assert recipientBlood != null : "fx:id=\"recipientBlood\" was not injected: check your FXML file 'HospitalDonorEntry.fxml'.";
        assert HospitalID != null : "fx:id=\"HospitalID\" was not injected: check your FXML file 'HospitalDonorEntry.fxml'.";
        assert recipientDate != null : "fx:id=\"recipientDate\" was not injected: check your FXML file 'HospitalDonorEntry.fxml'.";
        assert donorBlood != null : "fx:id=\"donorBlood\" was not injected: check your FXML file 'HospitalDonorEntry.fxml'.";

    }
}
