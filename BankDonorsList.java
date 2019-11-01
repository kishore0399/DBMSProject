package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BankDonorsList {
private final StringProperty Name;
private final IntegerProperty Age;
private final StringProperty City;
private final LongProperty Number;
private final StringProperty Blood;
private final StringProperty Date;
	public BankDonorsList(String name,Integer age,String city,Long Number,String blood,String date) {
		this.Name=new SimpleStringProperty(name);
		this.Age=new SimpleIntegerProperty(age);
		this.City=new SimpleStringProperty(city);
		this.Number=new SimpleLongProperty(Number);
		this.Blood=new SimpleStringProperty(blood);
		this.Date=new SimpleStringProperty(date);
	}
	public String getName() {
		return Name.get();
	}
	public Integer getAge() {
		return Age.get();
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
	public String getDate() {
		return Date.get();
	}
	public void setName(String value) {
		Name.set(value);
	}
	public void setAge(Integer value) {
		Age.set(value);
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
	public void setDate(String value) {
		Date.set(value);
	}
	public StringProperty NameProperty() {
		return Name;
	}
	public IntegerProperty AgeProperty() {
		return Age;
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
	public StringProperty DateProperty() {
		return Date;
	}
	
}
