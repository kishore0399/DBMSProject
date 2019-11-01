package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Locale;
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

public class ManagerEntry {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField managerID;

    @FXML
    private TextField hospitalID;

    @FXML
    private TextField managerName;

    @FXML
    private TextField managerCity;

    @FXML
    private TextField managerContact;

    @FXML
    private TextField bankID;

    @FXML
    private Button enterData;

    @FXML
    private TableView<ManagerList> managerTable;

    @FXML
    private TableColumn<ManagerList, String> colName;

    @FXML
    private TableColumn<ManagerList, Long> colContact;

    @FXML
    private TableColumn<ManagerList, String> colHospital;

    @FXML
    private TableColumn<ManagerList, String> colBloodBank;
    
    ObservableList<ManagerList> data;

    @FXML
    private Button viewManagers;

    @FXML
    private Button goBack;

    @FXML
    private Button goHome;
    
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
    void enterData(ActionEvent event) {
    	String id=managerID.getText();
    	String bankId=bankID.getText();
    	String hospitalId=hospitalID.getText();
    	String name=managerName.getText();
    	String city=managerCity.getText();
    	long number=Long.valueOf(managerContact.getText());
    	createConnection();
	   // String donated=lstDonation.getText();
    	//date(new SimpleDateFormat("dd/MM/yy",Locale.ENGLISH).parse(lstDonation.toString()));
	    if(bankId.equals("")) {
    		System.out.println("Success");
    		try {
				PreparedStatement stmt=con.prepareStatement("Update manager set manager_name='"+name+"', manager_city='"+city+"',manager_phone='"+number+"' where manager_ssn='"+id+"' AND hospital_id='"+ hospitalId+"'");
				stmt.execute();
				System.out.println("VALUES ENTERED");
				stmt.close();
    		} catch (SQLException e) {
				System.out.println(e);
			}
    		
    	}
	    else if(hospitalId.equals("")) {
    		System.out.println("Success");
    		try {
				PreparedStatement stmt=con.prepareStatement("Update manager set manager_name='"+name+"', manager_city='"+city+"',manager_phone='"+number+"' where manager_ssn='"+id+"' AND bank_id='"+ bankId+"'");
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

    @FXML
    void goBack(ActionEvent event) throws IOException {
    	Parent pane=FXMLLoader.load(getClass().getResource("Private.fxml"));
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
    void viewManagers(ActionEvent event) {
    	
    	try {
    		createConnection();
        	data=FXCollections.observableArrayList();
    		String sql="Select M.manager_name,M.manager_phone,H.hospital_name,B.bank_id from manager M , hospital H where M.hospital_id=H.hospital_id ";
    	PreparedStatement stmt=con.prepareStatement(sql);
    	ResultSet rs;
    		rs = stmt.executeQuery();
    	
    	while(rs.next()) {
    		data.add(new ManagerList(rs.getString(2),rs.getLong(1),rs.getString(5),rs.getString(11)));
        }
        	colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
            colContact.setCellValueFactory(new PropertyValueFactory<>("Number"));
            colHospital.setCellValueFactory(new PropertyValueFactory<>("Hospital"));
            colBloodBank.setCellValueFactory(new PropertyValueFactory<>("Bank"));
            managerTable.setItems(data);
        	}
         catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }

    @FXML
    void initialize() {
        assert managerID != null : "fx:id=\"managerID\" was not injected: check your FXML file 'ManagerEntry.fxml'.";
        assert hospitalID != null : "fx:id=\"hospitalID\" was not injected: check your FXML file 'ManagerEntry.fxml'.";
        assert managerName != null : "fx:id=\"managerName\" was not injected: check your FXML file 'ManagerEntry.fxml'.";
        assert managerCity != null : "fx:id=\"managerCity\" was not injected: check your FXML file 'ManagerEntry.fxml'.";
        assert managerContact != null : "fx:id=\"managerContact\" was not injected: check your FXML file 'ManagerEntry.fxml'.";
        assert bankID != null : "fx:id=\"bankID\" was not injected: check your FXML file 'ManagerEntry.fxml'.";
        assert enterData != null : "fx:id=\"enterData\" was not injected: check your FXML file 'ManagerEntry.fxml'.";
        assert managerTable != null : "fx:id=\"managerTable\" was not injected: check your FXML file 'ManagerEntry.fxml'.";
        assert colName != null : "fx:id=\"colName\" was not injected: check your FXML file 'ManagerEntry.fxml'.";
        assert colContact != null : "fx:id=\"colContact\" was not injected: check your FXML file 'ManagerEntry.fxml'.";
        assert colHospital != null : "fx:id=\"colHospital\" was not injected: check your FXML file 'ManagerEntry.fxml'.";
        assert colBloodBank != null : "fx:id=\"colBloodBank\" was not injected: check your FXML file 'ManagerEntry.fxml'.";
        assert viewManagers != null : "fx:id=\"viewManagers\" was not injected: check your FXML file 'ManagerEntry.fxml'.";
        assert goBack != null : "fx:id=\"goBack\" was not injected: check your FXML file 'ManagerEntry.fxml'.";
        assert goHome != null : "fx:id=\"goHome\" was not injected: check your FXML file 'ManagerEntry.fxml'.";

    }
}
