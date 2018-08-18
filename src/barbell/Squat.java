package barbell;

import java.time.LocalDate;

import workout.Workout;

public class Squat extends Barbell {

	public double weight;
	public int reps;
	public String date;
	public String set;
	public double wendlerCalc;
	
	public Squat() {
		
	}
	
	public LocalDate getCycleStart() {
		return this.cycleStart;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public int getReps() {
		return this.reps;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public String getSet() {
		return this.set;
	}
	
	public double getWendlerCalc() {
		return this.wendlerCalc;
	}
	
	public void setCycleStart(LocalDate date) {
		this.cycleStart = date;
	}
	
	public void setWeight(double wt) {
		this.weight = wt;
	}
	
	public void setReps(int rps) {
		this.reps = rps;
	}
	
	public void setDate(String da) {
		this.date = da;
	}
	
	public void setSet(String st) {
		this.set = st;
	}
	
	public void setWendlerCalc() {
		wendlerCalc = calculate();
	}
	
	public double calculate() {
		return getWeight() * getReps() * .0333 + getWeight();
	}
	
	public String toString() {
		return "Date: " + getDate() + " Set: " + getSet() +
			  " Weight: " + getWeight() + " Reps: " + getReps() +
			  " Calculated 1RM: " + getWendlerCalc();
	}

}
