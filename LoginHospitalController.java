 package application;

    import java.io.IOException;
    import java.net.URL;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.ResourceBundle;
    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Node;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.scene.control.PasswordField;
    import javafx.scene.control.TextField;
    import javafx.stage.Stage;

    public class LoginHospitalController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private TextField hospitalID;

        @FXML
        private TextField bankID;

        @FXML
        private TextField passwordBank;

        @FXML
        private PasswordField passwordHospital;
        


        @FXML
        void goBackPrivate(ActionEvent event) throws IOException {
        	Parent pane=FXMLLoader.load(getClass().getResource("Main.fxml"));
        	Scene scene=new Scene(pane);
        	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
        	window.setScene(scene);
        	window.setTitle("Home");
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
        void loginBank(ActionEvent event) {
        	
        	String id=bankID.getText();
        	String pass=passwordBank.getText();
        	try {
        		createConnection();
        		String sql="Select *from bloodbank where bloodbank_id='"+id+"' and bank_password='"+pass+"'";
    		@SuppressWarnings("null")
    		PreparedStatement stmt=con.prepareStatement(sql);
    		ResultSet rs=stmt.executeQuery();
        	if(rs.first()) {
        		Parent pane=FXMLLoader.load(getClass().getResource("BankDonors.fxml"));
            	Scene scene=new Scene(pane);
            	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
            	window.setScene(scene);
            	window.setTitle("BloodBank Database");
            	window.show();
            	
        		}
        	}
        	
        	catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }

        @FXML
        void loginHospital(ActionEvent event) {
        	String id=hospitalID.getText();
        	String pass=passwordHospital.getText();
        	try {
        		createConnection();
        		String sql="Select *from hospital where hospital_id='"+id+"' and hospital_password='"+pass+"'";
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
        	}
        	
        	catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }

        @FXML
        void initialize() {
            assert hospitalID != null : "fx:id=\"hospitalID\" was not injected: check your FXML file 'LoginHospital.fxml'.";
            assert bankID != null : "fx:id=\"bankID\" was not injected: check your FXML file 'LoginHospital.fxml'.";
            assert passwordBank != null : "fx:id=\"passwordBank\" was not injected: check your FXML file 'LoginHospital.fxml'.";
            assert passwordHospital != null : "fx:id=\"passwordHospital\" was not injected: check your FXML file 'LoginHospital.fxml'.";

        }
    }
