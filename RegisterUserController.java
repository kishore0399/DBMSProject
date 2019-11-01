package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterUserController {

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField donor_id;

    @FXML
    private TextField donor_name;

    @FXML
    private TextField password;

    @FXML
    private TextField password_check;

    @FXML
    private TextField donor_hospital;

    @FXML
    private TextField donor_bank;

    @FXML
    private TextField donor_phone;

    @FXML
    private TextField donor_blood;

    @FXML
    private TextField donor_city;
   
    @FXML
    private Button goBack1;
    
    @FXML
    private TextField donorInfo_id;

    @FXML
    private TextField donorHeight;

    @FXML
    private TextField donorWeight;

    @FXML
    private TextField age;

    @FXML
    private TextField gender;
    
    @FXML
    private TextField lstDonation;
    
    @FXML
    private TextField error_field;
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
    void SubmitInfo(ActionEvent event) {
    	createConnection();
    	String infoId=donorInfo_id.getText();
    	String height=donorHeight.getText();
    	String weight=donorWeight.getText();
    	try {
			PreparedStatement stmt=con.prepareStatement("INSERT INTO  information VALUES(?,?,?)");
			stmt.setString(1, infoId);
			stmt.setString(2, height);
			stmt.setString(3, weight);
			stmt.execute();
			System.out.println("VALUES ENTERED");
			stmt.close();
		} catch (SQLException e) {
			error_field.setText("ERROR!!!");
		}
    	
    	
    }

    @FXML
    void registerUser(ActionEvent event) throws ParseException {
    	createConnection();
    	String id=donor_id.getText();
	    String name=donor_name.getText();
	    String donor_age=age.getText();
	    String sex=gender.getText();
	    String city=donor_city.getText();
	    String blood_type=donor_blood.getText();
	    String bank_id=donor_bank.getText();
	    String hospital_id=donor_hospital.getText();
	    long phone=Long.valueOf( donor_phone.getText());
	    String passw=password.getText();
	    String passwordCheck=password_check.getText();
	   // String donated=lstDonation.getText();
    	java.sql.Date date = null;
    	date(new SimpleDateFormat("dd/MM/yy",Locale.ENGLISH).parse(lstDonation.toString()));
	    if(passw.equals(passwordCheck)) {
    		System.out.println("Success");
    		try {
				PreparedStatement stmt=con.prepareStatement("INSERT INTO  donor VALUES(?,?,?,?,?,?,?,?,?,?,?)");
				stmt.setString(1, id);
				stmt.setString(2, name);
				stmt.setString(3, donor_age);
				stmt.setString(4, sex);
				stmt.setString(7, city);
				stmt.setLong(6, phone);
				stmt.setString(5, blood_type);
				stmt.setString(8,passw);
				stmt.setString(9,hospital_id);
				stmt.setString(10,bank_id);
				stmt.setDate(11,date);
				stmt.execute();
				System.out.println("VALUES ENTERED");
				stmt.close();
    		} catch (SQLException e) {
				System.out.println(e);
			}
    		
    	}
    	else {
    		System.out.println("Fail");
    	}
    	
    	}
    private void date(Date parse) {
		// TODO Auto-generated method stub
		
	}

	@FXML
    void goBack(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("Public.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }


    @FXML
    void initialize() {
        assert donor_id != null : "fx:id=\"donor_id\" was not injected: check your FXML file 'RegisterUser.fxml'.";
        assert donor_name != null : "fx:id=\"donor_name\" was not injected: check your FXML file 'RegisterUser.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'RegisterUser.fxml'.";
        assert password_check != null : "fx:id=\"password_check\" was not injected: check your FXML file 'RegisterUser.fxml'.";
        assert donor_hospital != null : "fx:id=\"donor_hospital\" was not injected: check your FXML file 'RegisterUser.fxml'.";
        assert donor_bank != null : "fx:id=\"donor_bank\" was not injected: check your FXML file 'RegisterUser.fxml'.";
        assert donor_phone != null : "fx:id=\"donor_phone\" was not injected: check your FXML file 'RegisterUser.fxml'.";
        assert donor_blood != null : "fx:id=\"donor_blood\" was not injected: check your FXML file 'RegisterUser.fxml'.";
        assert donor_city != null : "fx:id=\"donor_city\" was not injected: check your FXML file 'RegisterUser.fxml'.";
        assert error_field != null : "fx:id=\"donor_city\" was not injected: check your FXML file 'RegisterUser.fxml'.";

    }
}
