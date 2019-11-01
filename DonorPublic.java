package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DonorPublic {

    @FXML
    private TextField donorBlood;

    @FXML
    private TextField donorCity;

    @FXML
    private TableView<PublicDonors> DonorTable;
    
    @FXML
    private TableColumn<PublicDonors, String> colHospital;

    @FXML
    private TableColumn<PublicDonors, String> colBlood;

    @FXML
    private TableColumn<PublicDonors, String> colCity;

    @FXML
    private TableColumn<PublicDonors, String> colState;

    @FXML
    private TableColumn<PublicDonors, Long> colContact;

    @FXML
    private TableColumn<PublicDonors, String> colManager;
    
    ObservableList<PublicDonors> data;
    
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

    @FXML
    void Search(ActionEvent event) {
    	String blood=donorBlood.getText();
    	String city=donorCity.getText();
    	try {
    		createConnection();
        	data=FXCollections.observableArrayList();
    		String sql="Select H.hospital_name,B.blood_type,H.hospital_name,H.hospital_state,M.manager_phone,M.manager_name from Hospital H,hospitalblood B,manager M where B.blood_type='"+blood+"' AND H.hospital_city='"+city+"' AND H.hospital_id=B.hospital_id AND M.hospital_id=H.hospital_id";//Query To get details
    	PreparedStatement stmt=con.prepareStatement(sql);
    	ResultSet rs;
    		rs = stmt.executeQuery();
    		
    	while(rs.next()) {
    		data.add(new PublicDonors(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getString(6)));
        }
        	colHospital.setCellValueFactory(new PropertyValueFactory<>("Name"));
            colBlood.setCellValueFactory(new PropertyValueFactory<>("Blood"));
            colCity.setCellValueFactory(new PropertyValueFactory<>("City"));
            colState.setCellValueFactory(new PropertyValueFactory<>("State"));
            colContact.setCellValueFactory(new PropertyValueFactory<>("Number"));
            colManager.setCellValueFactory(new PropertyValueFactory<>("Manager"));
        	DonorTable.setItems(data);
        	}
         catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
    

}
