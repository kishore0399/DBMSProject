package application;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ManagerList {

	private final StringProperty Name;
	private final LongProperty Number;
	private final StringProperty Hospital;
	private final StringProperty Bank;
	
	public ManagerList(String name , Long number , String hospital ,  String bank){
		this.Name=new SimpleStringProperty(name);
		this.Number=new SimpleLongProperty(number);
		this.Hospital=new SimpleStringProperty(hospital);
		this.Bank=new SimpleStringProperty(bank);
	}
	public String getName() {
	return Name.get();	
	}
	public Long getNumber() {
		return Number.get();
	}
	public String getHospital() {
		return Hospital.get();
	}
	public String getBank() {
		return Bank.get();
	}
	public void setName(String value) {
		Name.set(value);
	}
	public void setNumber(long value) {
		 Number.set(value);
	}
	public void setHospital(String value) {
		Hospital.set(value);
	}
	public void setBank(String value) {
		Bank.set(value);
	}
	public StringProperty NameProperty() {
		return Name;	
		}
		public LongProperty NumberProperty() {
			return Number;
		}
		public StringProperty HospitalProperty() {
			return Hospital;
		}
		public StringProperty BankProperty() {
			return Bank;
		}
	
}
