package application;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ListBoth {

	private final StringProperty ID;
	private final StringProperty City;
	private final LongProperty Number;
	private final StringProperty Manager;
	
	ListBoth(String ID,String City,Long Number,String Manager){
		this.ID=new SimpleStringProperty(ID);
		this.City=new SimpleStringProperty(City);
		this.Number=new SimpleLongProperty(Number);
		this.Manager=new SimpleStringProperty(Manager);
	}
	public String getID() {
		return ID.get();
	}
	public String getCity() {
		return City.get();
	}
	public Long getNumber() {
		return Number.get();
	}
	public String getManager() {
		return Manager.get();
	}
	public void setID(String value) {
		ID.set(value);
	}
	public void setCity(String value) {
		City.set(value);
	}
	public void setNumber(long value) {
		Number.set(value);
	}
	public void setManager(String value) {
		Manager.set(value);
	}
	public StringProperty IDProperty() {
		return ID;
		
	}
	public StringProperty CityProperty() {
		return City;
	}
	public LongProperty NumberProperty() {
		return Number;
		
	}
	public StringProperty ManagerProperty() {
		return Manager;
		
	}
}
