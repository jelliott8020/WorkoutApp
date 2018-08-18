package barbell;

import java.time.LocalDate;

import workout.Workout;

/**
 * 
 * @author Josh
 * @version 7/26/18
 * 
 * Class will store barbell workouts and PRs. Current use
 * will be for Wendler 5/3/1. 
 *
 */

public abstract class Barbell {
	
	public double weight;
	public int reps;
	public String date;
	public String set;
	public double wendlerCalc;
	public LocalDate cycleStart;
	
	public abstract LocalDate getCycleStart();
	public abstract double getWeight();
	public abstract int getReps();
	public abstract String getDate();
	public abstract String getSet();
	public abstract double getWendlerCalc();
	public abstract void setCycleStart(LocalDate date);
	public abstract void setWeight(double wt);
	public abstract void setReps(int rps);
	public abstract void setDate(String da);
	public abstract void setSet(String st);
	public abstract void setWendlerCalc();
	public abstract double calculate();
	public abstract String toString();
	
}
