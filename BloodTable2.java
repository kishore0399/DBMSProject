package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BloodTable2 {
	private final StringProperty Blood;
	private final DoubleProperty Quantity;
	private final IntegerProperty Cost;
	
	public BloodTable2(String blood,double quantity,int Cost){
		this.Blood=new SimpleStringProperty(blood);
		this.Quantity=new SimpleDoubleProperty(quantity);
		this.Cost=new SimpleIntegerProperty(Cost);
	}
	public String getBlood() {
		return Blood.get();
	}
	public double getQuantity() {	
		return Quantity.get();
	}
	public int getCost() {	
		return Cost.get();
	}
	public void setBlood(String value) {
		Blood.set(value);
	}
	public void setQuantity(double value) {
		Quantity.set(value);
	}
	public void setCost(int value) {
		Cost.set(value);
	}
	public StringProperty BloodProperty() {
		return Blood;
	}
	public DoubleProperty QuantityProperty() {
		return Quantity;
	}
	public IntegerProperty CostProperty() {
		return Cost;
	}
}
