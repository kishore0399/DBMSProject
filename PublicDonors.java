package application;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PublicDonors {
	private final StringProperty Name;
	private final StringProperty Blood;
	private final StringProperty City;
	private final StringProperty State;
	private final LongProperty Number;
	private final StringProperty Manager;
	
	public PublicDonors(String name,String blood,String city,String state,Long number,String manager){
		this.Name=new SimpleStringProperty(name);
		this.Blood=new SimpleStringProperty(blood);
		this.City=new SimpleStringProperty(city);
		this.State=new SimpleStringProperty(state);
		this.Number=new SimpleLongProperty(number);
		this.Manager=new SimpleStringProperty(manager);
		
	}
	public String getName() {
		return Name.get();
	}
	public String getBlood() {
		return Blood.get();
	}
	public String getCity() {
		return City.get();
	}
	public String getState() {
		return State.get();
	}
	public Long getNumber() {
		return Number.get();
	}
	public String getManager() {
		return Manager.get();
	}
	public void setName(String value) {
		Name.set(value);
	}
	public void setBlood(String value) {
		Blood.set(value);
	}
	public void setCity(String value) {
		City.set(value);
	}
	public void setState(String value) {
		State.set(value);
	}
	public void setNumber(Long value) {
		Number.set(value);
	}
	public void setManager(String value) {
		Manager.set(value);
	}
public StringProperty NameProperty() {
		return Name;
	}
	public StringProperty BloodProperty() {
		return Blood;
	}
	public StringProperty CityProperty() {
		return City;
	}
	public StringProperty StateProperty() {
		return State;
	}
	public LongProperty NumberProperty() {
		return Number;
	}
	public StringProperty ManagerProperty() {
		return Manager;
	}
}
