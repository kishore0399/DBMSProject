package application;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

    	public class RegisterController {

    	    @FXML
    	    private TextField hospitalname;

    	    @FXML
    	    private TextField hospital_city;

    	    @FXML
    	    private TextField hospital_state;

    	    @FXML
    	    private TextField hospital_manager;

    	    @FXML
    	    private TextField hospital_password;

    	    @FXML
    	    private TextField hospital_password_check;

    	    @FXML
    	    private TextField hospital_id;

    	    @FXML
    	    private Button register;

    	    @FXML
    	    private TextField passwordError;
    	    
    	    @FXML
    	    private TextField bank_id;

    	    @FXML
    	    private TextField hospital_number;
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
    	    	Parent pane=FXMLLoader.load(getClass().getResource("Private.fxml"));
    	    	Scene scene=new Scene(pane);
    	    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	    	window.setScene(scene);
    	    	window.show();
    	    }
    	    @FXML
    	    void Register(ActionEvent event) throws IOException {
    	    	createConnection();
    	    	String id=hospital_id.getText();
    	    	String bankid=bank_id.getText();
        	    String name=hospitalname.getText();
        	    String city=hospital_city.getText();
        	    String state=hospital_state.getText();
        	    long number=Long.valueOf( hospital_number.getText());
        	    String password=hospital_password.getText();
        	    String passwordCheck=hospital_password_check.getText();
        	    String manager=hospital_password_check.getText();
    	    	if(bankid.equals("")) {
    	    			if(password.equals(passwordCheck)&&password!=null) {
    	    		System.out.println("Success");
    	    		try {
						PreparedStatement stmt=con.prepareStatement("INSERT INTO  hospital VALUES(?,?,?,?,?,?,?)");
						stmt.setString(1, id);
						stmt.setString(2, name);
						stmt.setString(3, city);
						stmt.setString(4, state);
						stmt.setLong(5,number);
						stmt.setString(6, manager);
						stmt.setString(7, password);
						stmt.execute();
						System.out.println("Success!");
						stmt.close();
						
						PreparedStatement stmt1=con.prepareStatement("INSERT INTO  hospitalblood VALUES('"+id+"','A+',0)");
						PreparedStatement stmt2=con.prepareStatement("INSERT INTO  hospitalblood VALUES('"+id+"','A-',0)");
						PreparedStatement stm3=con.prepareStatement("INSERT INTO  hospitalblood VALUES('"+id+"','B+',0)");
						PreparedStatement stm4=con.prepareStatement("INSERT INTO  hospitalblood VALUES('"+id+"','B-',0)");
						PreparedStatement stm5=con.prepareStatement("INSERT INTO  hospitalblood VALUES('"+id+"','AB+',0)");
						PreparedStatement stmt6=con.prepareStatement("INSERT INTO  hospitalblood VALUES('"+id+"','AB-',0)");
						PreparedStatement stmt7=con.prepareStatement("INSERT INTO  hospitalblood VALUES('"+id+"','O+',0)");
						PreparedStatement stmt8=con.prepareStatement("INSERT INTO  hospitalblood VALUES('"+id+"','O-',0)");

						stmt1.execute();
						stmt2.execute();
						stm3.execute();
						stm4.execute();
						stm5.execute();
						stmt6.execute();
						stmt7.execute();
						stmt8.execute();
						stmt1.close();
						stmt2.close();
						stm3.close();
						stm4.close();
						stm5.close();
						stmt6.close();
						stmt7.close();
						stmt8.close();
						
						
    	    		} catch (SQLException e) {
						e.printStackTrace();
					}
    	    		
    	    	}
    	    			else {
    	    	    		passwordError.setText("Password Incorrect!!");
    	    	    	}
    	    			}
    	    	else {
    	    		if(password.equals(passwordCheck)&&password!=null) {
        	    		System.out.println("Success");
        	    		try {
    						PreparedStatement stmt=con.prepareStatement("INSERT INTO  bloodbank VALUES(?,?,?,?,?)");
    						stmt.setString(1, bankid);
    						stmt.setLong(2, number);
    						stmt.setString(3, state);
    						stmt.setString(4, manager);
    						stmt.setString(5, password);
    						stmt.execute();
    						System.out.println("Success!");
    						stmt.close();
    						
    						PreparedStatement stmt1=con.prepareStatement("INSERT INTO  bankblood VALUES('"+bankid+"','A+',0,0)");
    						PreparedStatement stmt2=con.prepareStatement("INSERT INTO  bankblood VALUES('"+bankid+"','A-',0,0)");
    						PreparedStatement stm3=con.prepareStatement("INSERT INTO  bankblood VALUES('"+bankid+"','B+',0,0)");
    						PreparedStatement stm4=con.prepareStatement("INSERT INTO  bankblood VALUES('"+bankid+"','B-',0,0)");
    						PreparedStatement stm5=con.prepareStatement("INSERT INTO  bankblood VALUES('"+bankid+"','AB+',0,0)");
    						PreparedStatement stmt6=con.prepareStatement("INSERT INTO  bankblood VALUES('"+bankid+"','AB-',0,0)");
    						PreparedStatement stmt7=con.prepareStatement("INSERT INTO  bankblood VALUES('"+bankid+"','O+',0,0)");
    						PreparedStatement stmt8=con.prepareStatement("INSERT INTO  bankblood VALUES('"+bankid+"','O-',0,0)");
    						
    						stmt1.execute();
    						stmt2.execute();
    						stm3.execute();
    						stm4.execute();
    						stm5.execute();
    						stmt6.execute();
    						stmt7.execute();
    						stmt8.execute();
    						stmt1.close();
    						stmt2.close();
    						stm3.close();
    						stm4.close();
    						stm5.close();
    						stmt6.close();
    						stmt7.close();
    						stmt8.close();
    						
        	    		} catch (SQLException e) {
    						e.printStackTrace();
    					}
    	    	}
    	    		else {
        	    		passwordError.setText("Password Incorrect!!");
        	    	}
    	    	}
    	    	
	    	}
    	    @FXML
    	    void loginAccounts(ActionEvent event) throws IOException {
    	    	Parent pane=FXMLLoader.load(getClass().getResource("LoginHospital.fxml"));
    	    	Scene scene=new Scene(pane);
    	    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	    	window.setScene(scene);
    	    	window.show();
    	    }

}
