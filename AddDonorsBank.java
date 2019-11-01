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

public class AddDonorsBank {

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
	    String bank_id=hospitalID.getText();
	    //String hospital_id=hospitalID.getText();
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
				stmt.setString(10,bank_id);
				stmt.setString(9,null);
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
    void initialize() {
        assert hospitalName != null : "fx:id=\"hospitalName\" was not injected: check your FXML file 'BankDonorEntry.fxml'.";
        assert donorID != null : "fx:id=\"donorID\" was not injected: check your FXML file 'BankDonorEntry.fxml'.";
        assert donorName != null : "fx:id=\"donorName\" was not injected: check your FXML file 'BankDonorEntry.fxml'.";
        assert donorAge != null : "fx:id=\"donorAge\" was not injected: check your FXML file 'BankDonorEntry.fxml'.";
        assert donorSex != null : "fx:id=\"donorSex\" was not injected: check your FXML file 'BankDonorEntry.fxml'.";
        assert donorContact != null : "fx:id=\"donorContact\" was not injected: check your FXML file 'BankDonorEntry.fxml'.";
        assert donorCity != null : "fx:id=\"donorCity\" was not injected: check your FXML file 'BankDonorEntry.fxml'.";
        assert donorPassword != null : "fx:id=\"donorPassword\" was not injected: check your FXML file 'BankDonorEntry.fxml'.";
        assert hospitalID != null : "fx:id=\"hospitalID\" was not injected: check your FXML file 'BankDonorEntry.fxml'.";
        assert donorDate != null : "fx:id=\"donorDate\" was not injected: check your FXML file 'BankDonorEntry.fxml'.";
        assert donorBlood != null : "fx:id=\"donorBlood\" was not injected: check your FXML file 'BankDonorEntry.fxml'.";

    }
}
