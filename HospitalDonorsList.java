package application;


import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HospitalDonorsList {
	
	private final StringProperty DName;
	private final StringProperty DonorID;
	private final StringProperty DonorBlood;
	private final StringProperty DDonated;
	private final LongProperty DNumber;
	
	public HospitalDonorsList(String name,String id,String blood,String Donated,Long number) {
		this.DName=new SimpleStringProperty(name);
		this.DonorID=new SimpleStringProperty(id);
		this.DonorBlood=new SimpleStringProperty(blood);
		this.DDonated=new SimpleStringProperty(Donated);
		this.DNumber=new SimpleLongProperty(number);
	}
	
	
	public String getDName() {
		return DName.get();
	}

	public String getDonorID() {
		return DonorID.get();
	}

	public String getDonorBlood() {
		return DonorBlood.get();
	}

	public String getDDonated() {
		return DDonated.get();
	}

	public Long getDNumber() {
		return DNumber.get();
	}

	public StringProperty DNameProperty() {
		return DName;
	}
	public StringProperty DonorIDProperty(){
		return DonorID;
	}
	public StringProperty DonorBloodProperty(){
		return DonorBlood;
	}
	public StringProperty DDonatedProperty(){
		return DDonated;
	}
	public LongProperty DNumberProperty() {
		return DNumber;
	}
}
