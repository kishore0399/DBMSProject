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

public class BankHospitalsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<BankHospitals> bankHospitals;

    @FXML
    private TableColumn<BankHospitals, String> colHospital;

    @FXML
    private TableColumn<BankHospitals, String> colLocation;

    @FXML
    private TableColumn<BankHospitals, Long> colContact;

    @FXML
    private TableColumn<BankHospitals, String> colBlood;
    
    ObservableList <BankHospitals> Hlist;

    @FXML
    private TextField searchBlood;

    @FXML
    private Label bloodbank;

    @FXML
    private TableView<BankBlood> tableBlood;

    @FXML
    private TableColumn<BankHospitals, Integer> colCost;
    
    @FXML
    private TableColumn<BankHospitals, String> colBloodGroup;
    
    ObservableList <BankBlood> BList;
    
    @FXML
    private TextField bankID;
    
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
    void bloodDetails(ActionEvent event) {
    	String ID=bankID.getText();
    	try {
    		createConnection();
        	Hlist=FXCollections.observableArrayList();
    		String sql="Select B.blood_type,B.cost from bloodbank D,bankblood B where  B.bank_i=A'"+ID+"'ND B.bank_id=D.bank_id ";
    	PreparedStatement stmt=con.prepareStatement(sql);
    	ResultSet rs;
    		rs = stmt.executeQuery();
    	
    	while(rs.next()) {
    		BList.add(new BankBlood(rs.getString(1),rs.getInt(2)));
        }
        	colBloodGroup.setCellValueFactory(new PropertyValueFactory<>("Blood"));
        	colCost.setCellValueFactory(new PropertyValueFactory<>("Cost"));
          	tableBlood.setItems(BList);
        	}
         catch (SQLException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void goManagers(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("Main.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    
    @FXML
    void goDonors(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("BankDonors.fxml"));
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
    void searchBlood(ActionEvent event) {
    	try {
    		String group=searchBlood.getText();
    		createConnection();
        	Hlist=FXCollections.observableArrayList();
    		String sql="Select H.hospital_name,H.hospital_city,H.hospital_number,B.blood_type from hospital H,hospitalblood B where blood_type='"+ group+"' AND H.hospital_id=B.hospital_id AND B.quantity<100 ";
    	PreparedStatement stmt=con.prepareStatement(sql);
    	ResultSet rs;
    		rs = stmt.executeQuery();
    	
    	while(rs.next()) {
    		Hlist.add(new BankHospitals(rs.getString(1),rs.getString(2),rs.getLong(2),rs.getString(2)));
        }
        	colHospital.setCellValueFactory(new PropertyValueFactory<>("Name"));
        	colLocation.setCellValueFactory(new PropertyValueFactory<>("City"));
        	colContact.setCellValueFactory(new PropertyValueFactory<>("Number"));
        	colBlood.setCellValueFactory(new PropertyValueFactory<>("Blood"));
        	bankHospitals.setItems(Hlist);
        	}
         catch (SQLException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void updateBlood(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("BankBloodDetails.fxml"));
    	Scene scene=new Scene(pane);
    	Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    
    @FXML
    void initialize() {
    	
    	try {
    		createConnection();
        	Hlist=FXCollections.observableArrayList();
    		String sql="Select H.hospital_name,H.hospital_city,H.hospital_number,B.blood_type from hospital H,hospitalblood B where H.hospital_id=B.hospital_id AND B.quantity<100";
    	PreparedStatement stmt=con.prepareStatement(sql);
    	ResultSet rs;
    		rs = stmt.executeQuery();
    	
    	while(rs.next()) {
    		Hlist.add(new BankHospitals(rs.getString(1),rs.getString(2), null, sql));
        }
        	colHospital.setCellValueFactory(new PropertyValueFactory<>("Name"));
        	colLocation.setCellValueFactory(new PropertyValueFactory<>("City"));
        	colContact.setCellValueFactory(new PropertyValueFactory<>("Number"));
        	colBlood.setCellValueFactory(new PropertyValueFactory<>("Blood"));
        	bankHospitals.setItems(Hlist);
        	}
         catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}

    }
}
