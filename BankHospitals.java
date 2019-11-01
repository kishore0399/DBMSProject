package application;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BankHospitals {

	private final StringProperty Name;
	private final StringProperty City;
	private final LongProperty Number;
	private final StringProperty Blood;
	BankHospitals(String Name,String City,Long Number,String Blood){
		this.Name=new SimpleStringProperty(Name);
		this.City=new SimpleStringProperty(City);
		this.Number=new SimpleLongProperty(Number);
		this.Blood=new SimpleStringProperty(Blood);
	}
	public String getName() {
		return Name.get();
	}
	public String getCity() {
		return City.get();
	}
	public Long getNumber() {
		return Number.get();
	}
	public String getBlood() {
		return Blood.get();
	}
	public void setName(String value) {
		Name.set(value);
	}
	public void setCity(String value) {
		City.set(value);
	}
	public void setNumber(Long value) {
		Number.set(value);
	}
	public void setBlood(String value) {
		Blood.set(value);
	}
	
	public StringProperty NameProperty() {
		return Name;
	}
	public StringProperty CityProperty() {
		return City;
	}
	public LongProperty NumberProperty() {
		return Number;
	}
	public StringProperty BloodProperty() {
		return Blood;
	}
}
