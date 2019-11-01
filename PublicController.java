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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PublicController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button goBack;

    @FXML
    private Button General;

    @FXML
    private Button Private;

    @FXML
    private Button Home;

    @FXML
    private Button privateHome;

    @FXML
    private Button Register;
    
    @FXML
    private TextArea info_field;

    @FXML
    private Button aboutUs;

    @FXML
    private Button exit;

    @FXML
    private Button Login;

    @FXML
    private Button Sign_Up;
    
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;
   // @FXML
    //private TextArea donor_area;

    //@FXML
    //private TextArea recipient_area;
    
    @FXML
    private TextField name;

    @FXML
    private TextField age;

    @FXML
    private TextField weight;

    @FXML
    private TextField height;

    @FXML
    private TextField bloodGroup;

    @FXML
    private TableView<?> tableView;

    @FXML
    private Button goBack2;

    @FXML
    private TextField donatedOn;
    
    @FXML
    private TextField passwordError;

    @FXML
    private TextField usernameError;
    
    @FXML
    private TableView<?> DonorTable;
    
    @FXML
    private TextField donorBlood;

    @FXML
    private TextField donorCity;
    
    @FXML
    void searchHospitals(ActionEvent event) {
    	
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
    void Back(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("Public.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

    @FXML
    void Home(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("Main.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
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
    void GeneralView(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("PublicDonor.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

    

    @FXML
    void RecipientView(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("Recipient.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

    @FXML
    void Sign_up(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("RegisterUser.fxml"));
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
    void Search(ActionEvent event) {

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
    void goPrivateHome(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("Private.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

    @FXML
    void goRegister(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("RegisterUser.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

    @FXML
    void Login(ActionEvent event) throws IOException  {
    	
    	String id=username.getText();
    	String pass=password.getText();
    	try {
    		createConnection();
		String sql="Select *from donor where donor_id='"+id+"' and donor_password='"+pass+"'";
		PreparedStatement stmt=con.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
    	if(rs.first()) {
    		Parent pane=FXMLLoader.load(getClass().getResource("Donor.fxml"));
        	Scene scene=new Scene(pane);
        	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
        	window.setScene(scene);
        	window.show();
        	name.setText("Name");
    	}
   	else {  usernameError.setText("Incorrect Password/Username");  	}
    	}
    	
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @FXML
    void initialize() {
        assert goBack != null : "fx:id=\"goBack\" was not injected: check your FXML file 'Public.fxml'.";
        assert General != null : "fx:id=\"General\" was not injected: check your FXML file 'Public.fxml'.";
        assert Private != null : "fx:id=\"Private\" was not injected: check your FXML file 'Public.fxml'.";
        assert Home != null : "fx:id=\"Home\" was not injected: check your FXML file 'Public.fxml'.";
        assert privateHome != null : "fx:id=\"publicHome\" was not injected: check your FXML file 'Public.fxml'.";
        assert Register != null : "fx:id=\"Register\" was not injected: check your FXML file 'Public.fxml'.";
        assert aboutUs != null : "fx:id=\"aboutUs\" was not injected: check your FXML file 'Public.fxml'.";
        assert exit != null : "fx:id=\"exit\" was not injected: check your FXML file 'Public.fxml'.";
        assert Login != null : "fx:id=\"Login\" was not injected: check your FXML file 'Public.fxml'.";
        assert Sign_Up != null : "fx:id=\"Sign_Up\" was not injected: check your FXML file 'Public.fxml'.";
        assert DonorTable != null : "fx:id=\"DonorTable\" was not injected: check your FXML file 'PublicDonor.fxml'.";
        assert donorCity != null : "fx:id=\"donorCity\" was not injected: check your FXML file 'PublicDonor.fxml'.";
        assert DonorTable != null : "fx:id=\"DonorTable\" was not injected: check your FXML file 'PublicDonor.fxml'.";

    }
}
