package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BloodTable {

	private final StringProperty Blood;
	private final DoubleProperty Quantity;
	
	public BloodTable(String blood,double quantity){
		this.Blood=new SimpleStringProperty(blood);
		this.Quantity=new SimpleDoubleProperty(quantity);
	}
	public String getBlood() {
		return Blood.get();
	}
	public double getQuantity() {	
		return Quantity.get();
	}
	public void setBlood(String value) {
		Blood.set(value);
	}
	public void setQuantity(double value) {
		Quantity.set(value);
	}
	public StringProperty BloodProperty() {
		return Blood;
	}
	public DoubleProperty QuantityProperty() {
		return Quantity;
	}
	
}
