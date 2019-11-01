package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BankBlood {
	private final StringProperty Blood;
	private final IntegerProperty Cost;
	public BankBlood(String Blood,int Cost){
		this.Blood=new SimpleStringProperty(Blood);
		this.Cost=new SimpleIntegerProperty(Cost);		
	}
	public String getBlood() {
		return Blood.get();
	}
	public Integer getCost() {
		return Cost.get();
	}
	public void setBlood(String value) {
		Blood.set(value);
	}
	public void setCost(int value) {
		Cost.set(value);
	}
	public StringProperty BloodProperty() {
		return Blood;
	}
	public IntegerProperty CostProperty() {
		return Cost;
	}
}
