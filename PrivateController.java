package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;

public class PrivateController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Login;

    @FXML
    private Button Sign_Up;

    @FXML
    private Button Home;

    @FXML
    private Button publicHome;

    @FXML
    private Button Register;

    @FXML
    private Button aboutUs;

    @FXML
    private Button exit;
    
    @FXML
    private TextField hospital_id;

    @FXML
    private PasswordField hospital_password;
    
    @FXML
    private TableView<?> bankDonor;

    @FXML
    private Label bloodbankName;

    @FXML
    private TextField search;
    @FXML
    private TableView<?> bankHospitals;

    @FXML
    private TextField searchBlood;

    @FXML
    private Label bloodbank;
    
    @FXML
    private Label hospitalName;


    @FXML
    private Label donorField;

    @FXML
    private TextField SearchBlood;

    @FXML
    private TableView<?> HospitalsBank;

    @FXML
    private Button goBackPrivate;

    @FXML
    private TableView<?> hospitalReceivers;

    @FXML
    private TextField Search;
    
    @FXML
    private TextField hospitalID;

    @FXML
    private TextField bankID;

    @FXML
    private TextField passwordBank;

    @FXML
    private PasswordField passwordHospital;

    
    @FXML
    private TextField ownID;

  
    
    @FXML
    void goBackPrivate1(ActionEvent event) {

    }
    
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
    void goLogin(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("LoginHospital.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    @FXML
    void Login(ActionEvent event) throws IOException, SQLException  {
    	  String id=hospital_id.getText();
    		 String pass=hospital_password.getText();
    	
    	// Statement statement = null;
    	// ResultSet resultSet = null;
    	try {
    		createConnection();
    		String sql="Select *from hospital where hospital_id='"+id+"' and hospital_password='"+pass+"'";
		@SuppressWarnings("null")
		PreparedStatement stmt=con.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
    	if(rs.first()) {
    		Parent pane=FXMLLoader.load(getClass().getResource("Hospital.fxml"));
        	Scene scene=new Scene(pane);
        	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
        	window.setScene(scene);
        	window.setTitle("Hospital Database");
        	window.show();
        	
    	}
    	
   	//else {  usernameError.setText("Incorrect");  	}
	//	resultSet = stmt.executeQuery("select hospital_id,hospital_password from users");
    	}
    	
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    /*	PreparedStatement stmt1=con.prepareStatement("Select hospital_name from hospital where hospital_id='"+id+"'");
		ResultSet rs1=stmt1.executeQuery();
		String str=rs1.getString(1);
    	*/
    }

  
    @FXML
    void Sign_up(ActionEvent event) throws IOException {

    	Parent pane=FXMLLoader.load(getClass().getResource("Register.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    
    }

    @FXML
    void exit(ActionEvent event) {

    }

    @FXML
    void goAbout(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("AboutUs.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    @FXML
    void goBack(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("Main.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

    @FXML
    void goHome(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("Main.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

    @FXML
    void goPublicHome(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("Public.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

    @FXML
    void goRegister(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("Register.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    
    @FXML
    void goBackPrivate(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("Private.fxml"));
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
    void goHospitals(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("BankHospitals.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

    @FXML
    void searchBlood(ActionEvent event) throws IOException {
    	
    }

   
    
    @FXML
    void initialize(URL location) {
        assert Login != null : "fx:id=\"Login\" was not injected: check your FXML file 'Private.fxml'.";
        assert Sign_Up != null : "fx:id=\"Sign_Up\" was not injected: check your FXML file 'Private.fxml'.";
        assert Home != null : "fx:id=\"Home\" was not injected: check your FXML file 'Private.fxml'.";
        assert publicHome != null : "fx:id=\"publicHome\" was not injected: check your FXML file 'Private.fxml'.";
        assert Register != null : "fx:id=\"Register\" was not injected: check your FXML file 'Private.fxml'.";
        assert aboutUs != null : "fx:id=\"aboutUs\" was not injected: check your FXML file 'Private.fxml'.";
        assert exit != null : "fx:id=\"exit\" was not injected: check your FXML file 'Private.fxml'.";
        assert bankDonor != null : "fx:id=\"bankDonor\" was not injected: check your FXML file 'BankDonors.fxml'.";
        assert bloodbankName != null : "fx:id=\"bloodbankName\" was not injected: check your FXML file 'BankDonors.fxml'.";
        assert search != null : "fx:id=\"search\" was not injected: check your FXML file 'BankDonors.fxml'.";
        //assert donorTable != null : "fx:id=\"donorTable\" was not injected: check your FXML file 'UserMaster.fxml'.";
        
    }
 
}
   
