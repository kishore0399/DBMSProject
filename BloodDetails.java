package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BloodDetails {
	private final StringProperty blood;
	private final IntegerProperty quantity;
	public BloodDetails(String blood,int quantity) {
		this.blood=new SimpleStringProperty(blood);
		this.quantity=new SimpleIntegerProperty(quantity);
	
	}
	public String getBlood() {
		return blood.get();
	}
	public int getQuantity() {
		return quantity.get();
	}
	public void setBlood(String value) {
		 blood.set(value);
	}
	public void setQuantity(int value) {
		quantity.set(value);
	}
	public StringProperty BloodProperty() {
		return blood;
	}
	public IntegerProperty QuantityProperty() {
		return quantity;
	}
	
}
