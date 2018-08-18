package workout;

import java.time.LocalDate;

/**
 * -AMPRAPs Object takes the date, weight, and reps performed
 * -Stores the effort in a string ie "165x8"
 * -Calculates the effort using Wendler's formula, stores
 *  it in result variable
 *  Returns both effort ("165x8") and result (205) for storage in JSON
 * 
 * @author Josh
 *
 */
public class AMRAPs {

	LocalDate date;
	String effort;
	double weight;
	int reps;
	double result;
	
	
	public AMRAPs(LocalDate date, double weight, int reps) {
		this.date = date;
		this.weight = weight;
		this.reps = reps;
		calculateEffort();
		calculateResult();
	}
	
	public void calculateResult() {
		result = weight * reps * .0333 + weight;
		result = 5*(Math.round(result/5));
	}
	
	public void calculateEffort() {
		effort = weight + "x" + reps;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public String getEffort()  {
		return effort;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public int getReps() {
		return reps;
	}
	
	public double getResult() {
		return result;
	}
}
