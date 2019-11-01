package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Wrapper;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
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

public class DonorList {

    @FXML 
    private ResourceBundle resources;

    @FXML 
    private URL location;

    @FXML // fx:id="hospitalName"
    private Label hospitalName;

    @FXML
    private TableView<HospitalDonorsList> donorTable=new TableView<HospitalDonorsList>() ;

    @FXML // fx:id="donorField"
    private Label donorField; 

    @FXML // fx:id="SearchBlood"
    private TextField SearchBlood;

    @FXML // fx:id="ownID"
    private TextField ownID;

    @FXML
    private TableColumn<HospitalDonorsList, String> tableDonorName;

    @FXML
    private TableColumn<HospitalDonorsList, String> tableDonorID;

    @FXML
    private TableColumn<HospitalDonorsList, String> tableDonorBlood;

    @FXML
    private TableColumn<HospitalDonorsList, String> tableDonorDonated;

    @FXML
    private TableColumn<HospitalDonorsList, Long> tableDonorNum;
    
    ObservableList<HospitalDonorsList> data;
    
    @FXML
    private TableView<BloodDetails> bloodDetails;

    @FXML
    private TableColumn<BloodDetails, String> bloodGroup;

    @FXML
    private TableColumn<BloodDetails, String> bloodQuantity;
    
    ObservableList<BloodDetails> details;

    @FXML
    void HospitalBlood(ActionEvent event) {
    	String id=ownID.getText();
    	
    	try {
    		createConnection();
        	details=FXCollections.observableArrayList();
    		String sql="Select * from hospitalblood  where hospital_id='"+id+"'";
    	PreparedStatement stmt=con.prepareStatement(sql);
    	ResultSet rs;
    		rs = stmt.executeQuery();
    	
    	while(rs.next()) {
    		details.add(new BloodDetails(rs.getString(2),rs.getInt(3)));
        }
        	bloodGroup.setCellValueFactory(new PropertyValueFactory<>("blood"));
        	bloodQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        	bloodDetails.setItems(details);
        	}
         catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
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
    void goBank(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("HospitalBank.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    @FXML
    void addDonors(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("HospitalDonorEntry.fxml"));
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

    private
    @FXML
    void Search(ActionEvent event) {
    	String id=ownID.getText();
    	String blood=SearchBlood.getText();
    	
    	try {
    		createConnection();
        	data=FXCollections.observableArrayList();
    		String sql="Select * from donor D  where D.hospital_id='"+id+"' AND D.donor_blood='"+ blood +"'";//Query To get details
    	PreparedStatement stmt=con.prepareStatement(sql);
    	ResultSet rs;
    	
    		System.out.println(blood);
    		rs = stmt.executeQuery();
    		String sql1="Select hospital_name as name from Hospital  where hospital_id='"+id+"' ";//To set hospital name
        	PreparedStatement stmt1=con.prepareStatement(sql1);
        	ResultSet rs1;
        	rs1 = stmt1.executeQuery();
        	if(rs1.next()) {
        		hospitalName.setText(rs1.getString(1));
        	}
    	while(rs.next()) {
    		data.add(new HospitalDonorsList(rs.getString(2),rs.getString(1),rs.getString(5),rs.getString(11),rs.getLong(6)));
        }
        	tableDonorName.setCellValueFactory(new PropertyValueFactory<>("DName"));
            tableDonorID.setCellValueFactory(new PropertyValueFactory<>("DonorID"));
            tableDonorBlood.setCellValueFactory(new PropertyValueFactory<>("DonorBlood"));
            tableDonorDonated.setCellValueFactory(new PropertyValueFactory<>("DDonated"));
            tableDonorNum.setCellValueFactory(new PropertyValueFactory<>("DNumber"));
        	donorTable.setItems(data);
        	}
         catch (SQLException e) {
    		// TODO Auto-generated catch block
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
    void gotoRecipents(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("HospitalRecipient.fxml"));
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
    	data=FXCollections.observableArrayList();
		String sql="Select * from donor D  where d.hospital_id='"+id+"'";
	PreparedStatement stmt=con.prepareStatement(sql);
	ResultSet rs;
		rs = stmt.executeQuery();
	
	while(rs.next()) {
		data.add(new HospitalDonorsList(rs.getString(2),rs.getString(1),rs.getString(5),rs.getString(11),rs.getLong(6)));
    }
    	tableDonorName.setCellValueFactory(new PropertyValueFactory<>("DName"));
        tableDonorID.setCellValueFactory(new PropertyValueFactory<>("DonorID"));
        tableDonorBlood.setCellValueFactory(new PropertyValueFactory<>("DonorBlood"));
        tableDonorDonated.setCellValueFactory(new PropertyValueFactory<>("DDonated"));
        tableDonorNum.setCellValueFactory(new PropertyValueFactory<>("DNumber"));
    	donorTable.setItems(data);
    	}
     catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
   
    @FXML
    void updateDetails(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("updateBlood.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    
}
