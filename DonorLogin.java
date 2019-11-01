package application;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DonorLogin {
	private final StringProperty Name;
	private final StringProperty City;
	private final StringProperty State;
	private final LongProperty Amount;
	private final StringProperty Urgency;
	
	public DonorLogin(String Name,String City,String State,Long Amount,String urgency) {

		this.Name=new SimpleStringProperty(Name);
		this.City=new SimpleStringProperty(City);
		this.State=new SimpleStringProperty(State);
		this.Amount=new SimpleLongProperty(Amount);
		this.Urgency = new SimpleStringProperty(urgency);
		
	}
	
	public String getName() {
		return Name.get();
	}
	public String getCity() {
		return City.get();
	}
	public String getState() {
		return State.get();
	}
	public Long getAmount() {
		return Amount.get(); 
	}
	public String getUrgency() {
		return Urgency.get();
	}
	
	public void setName(String value) {
		Name.set(value);
		
	}
	public void setCity(String value) {
		City.set(value);
		
	}
	public void setState(String value) {
		State.set(value);
		
	}
	public void setAmount(Long value) {
		Amount.set(value);
		
	}
	public void setUrgency(String value) {
		Urgency.set(value);
		
	}
	public StringProperty NameProperty() {
		return Name;
	}
	public StringProperty CityProperty(){
		return City;
	}
	public StringProperty StateProperty(){
		return State;
	}
	public LongProperty AmountProperty(){
		return Amount;
	}
	public StringProperty UrgencyProperty() {
		return Urgency;
	}
}
