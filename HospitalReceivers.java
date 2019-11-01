package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HospitalReceivers {

	private final StringProperty Name;
	private final IntegerProperty Age;
	private final StringProperty Sex;
	private final StringProperty Date;
	private final LongProperty Number;
	private final StringProperty Blood;
	
	public HospitalReceivers(String name,int age,String sex,String Date,Long Number,String Blood) {
		this.Name=new SimpleStringProperty(name);
		this.Age=new SimpleIntegerProperty(age);
		this.Sex=new SimpleStringProperty(sex);
		this.Date=new SimpleStringProperty(Date);
		this.Number=new SimpleLongProperty(Number);
		this.Blood=new SimpleStringProperty(Blood);
	}
	public String getName() {
		return Name.get();
	}
	public int getAge() {
		return Age.get();
	}
	public String getSex() {
		return Sex.get();
	}
	public String getDate() {
		return Date.get();
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
	public void setAge(int value) {
		Age.set(value);
	}
	public void setSex(String value) {
		Sex.set(value);
	}
	public void setDate(String value) {
		Date.set(value);
	}
	public void setNumber(long value) {
		Number.set(value);
	}
	public void setBlood(String value) {
		Blood.set(value);
	}
	public StringProperty NameProperty() {
		return Name;
	}
	public IntegerProperty AgeProperty() {
		return Age;
	}
	public StringProperty SexProperty() {
		return Sex;
	}
	public StringProperty getDateProperty() {
		return Date;
	}
	public LongProperty NumberProperty() {
		return Number;
	}
	public StringProperty BloodProperty() {
		return Blood;
	}
	
}
