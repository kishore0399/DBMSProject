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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private TableView<DonorLogin> tableView;

    @FXML
    private TableColumn<DonorLogin, String> colHospital;

    @FXML
    private TableColumn<DonorLogin, String> colCity;

    @FXML
    private TableColumn<DonorLogin, String> colState;

    @FXML
    private TableColumn<DonorLogin, String> colBlood;

    @FXML
    private TableColumn<DonorLogin, String> colUrgency;

    @FXML
    private Button goBack2;

    @FXML
    private TextField donatedOn;

    @FXML
    private TextField donorID;
    
    ObservableList<DonorLogin> details;
    
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
    void Logout(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("Main.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.setFullScreen(false);
    	window.setTitle("HomePage");
    	window.show();
    }

    @FXML
    void listHospitals(ActionEvent event) {
    	String id=donorID.getText();
    	
    	try {
    		createConnection();
        	details=FXCollections.observableArrayList();
        	
        	String sqlname="Select D.donor_name from donor D where donor_id='"+ id+"'";
    		String sqlage="Select D.age from donor D where donor_id='"+ id+"'";
    		String sqlweight="Select I.weight from information I,donor D where I.id='"+ id+"' AND I.id=D.donor_id";
    		String sqlheight="Select I.height from information I,donor D where I.id='"+ id+"' AND I.id=D.donor_id";
    		String sqldate="Select D.last_donated from donor D where donor_id='"+ id+"'";
    		String sqlblood="Select D.donor_blood from donor D where donor_id='"+ id+"'";    
    		
    		PreparedStatement stmtname=con.prepareStatement(sqlname);
        	ResultSet rsname;
        		rsname = stmtname.executeQuery();
        		if(rsname.next()) {
        		name.setText(rsname.getString(1));
        		}
        		else {
       				name.setText("Not Entered");
       			}
        	PreparedStatement stmtage=con.prepareStatement(sqlage);
           	ResultSet rsage;
           		rsage = stmtage.executeQuery();
           		if(rsage.next()) {
           		age.setText(rsage.getString(1));
           		}
           		else {
       				age.setText("Not Entered");
       			}
       		PreparedStatement stmtweight=con.prepareStatement(sqlweight);
       		ResultSet rsweight;
       		rsweight = stmtweight.executeQuery();
       			if(rsweight.next()) {
       				weight.setText(rsweight.getString(1));
       			}
       			else {
       				weight.setText("Not Entered");
       			}
                		
       		PreparedStatement stmtheight=con.prepareStatement(sqlheight);
       		ResultSet rsheight;
          		rsheight = stmtheight.executeQuery();
          		if(rsheight.next()) {
          			height.setText(rsheight.getString(1));
          		}
          		else {
       				height.setText("Not Entered");
       			}
          		PreparedStatement stmtblood=con.prepareStatement(sqlblood);
           		ResultSet rsblood;
              		rsblood = stmtblood.executeQuery();
              		if(rsblood.next()) {
              			bloodGroup.setText(rsblood.getString(1));
              		}
                    		
      		PreparedStatement stmtdate=con.prepareStatement(sqldate);
      		ResultSet rsdate;
             rsdate = stmtdate.executeQuery();
           if(rsdate.next()) {
        	   donatedOn.setText(rsdate.getString(1));
           
           }
             
    		String sql="Select H.hospital_name,H.hospital_city,H.hospital_state,H.hospital_number,D.last_donated from hospital H, donor D where D.donor_id='"+id+"' AND H.hospital_id=D.hospital_id";
    	PreparedStatement stmt=con.prepareStatement(sql);
    	ResultSet rs;
    		rs = stmt.executeQuery();
    	
    	while(rs.next()) {
    		details.add(new DonorLogin(rs.getString(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5)));
        }
        	colHospital.setCellValueFactory(new PropertyValueFactory<>("Name"));
            colCity.setCellValueFactory(new PropertyValueFactory<>("City"));
            colState.setCellValueFactory(new PropertyValueFactory<>("State"));
            colBlood.setCellValueFactory(new PropertyValueFactory<>("Amount"));
            colUrgency.setCellValueFactory(new PropertyValueFactory<>("Urgency"));
        	tableView.setItems(details);
        	}
         catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }

    @FXML
    void searchHospitals(ActionEvent event) {
String id=donorID.getText();
    	
    	try {
    		createConnection();
        	details=FXCollections.observableArrayList();
    		String sql="Select * from hospital H  where d.hospital_id='"+id+"'";
    		
    		
             PreparedStatement stmt=con.prepareStatement(sql);
    	ResultSet rs;
    		rs = stmt.executeQuery();
    	
    	while(rs.next()) {
    		details.add(new DonorLogin(rs.getString(2),rs.getString(1),rs.getString(5),rs.getLong(6),rs.getString(11)));
        }
        	colHospital.setCellValueFactory(new PropertyValueFactory<>("Name"));
            colCity.setCellValueFactory(new PropertyValueFactory<>("City"));
            colState.setCellValueFactory(new PropertyValueFactory<>("State"));
            colBlood.setCellValueFactory(new PropertyValueFactory<>("Amount"));
            colUrgency.setCellValueFactory(new PropertyValueFactory<>("Urgency"));
        	tableView.setItems(details);
        	}
         catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }

    @FXML
    void initialize() {
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'Donor.fxml'.";
        assert age != null : "fx:id=\"age\" was not injected: check your FXML file 'Donor.fxml'.";
        assert weight != null : "fx:id=\"weight\" was not injected: check your FXML file 'Donor.fxml'.";
        assert height != null : "fx:id=\"height\" was not injected: check your FXML file 'Donor.fxml'.";
        assert bloodGroup != null : "fx:id=\"bloodGroup\" was not injected: check your FXML file 'Donor.fxml'.";
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'Donor.fxml'.";
        assert colHospital != null : "fx:id=\"colHospital\" was not injected: check your FXML file 'Donor.fxml'.";
        assert colCity != null : "fx:id=\"colCity\" was not injected: check your FXML file 'Donor.fxml'.";
        assert colState != null : "fx:id=\"colState\" was not injected: check your FXML file 'Donor.fxml'.";
        assert colBlood != null : "fx:id=\"colBlood\" was not injected: check your FXML file 'Donor.fxml'.";
        assert colUrgency != null : "fx:id=\"colUrgency\" was not injected: check your FXML file 'Donor.fxml'.";
        assert goBack2 != null : "fx:id=\"goBack2\" was not injected: check your FXML file 'Donor.fxml'.";
        assert donatedOn != null : "fx:id=\"donatedOn\" was not injected: check your FXML file 'Donor.fxml'.";
        assert donorID != null : "fx:id=\"donorID\" was not injected: check your FXML file 'Donor.fxml'.";

    }
}
