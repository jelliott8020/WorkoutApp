package barbell;

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
	public int sets;
	public boolean prSet; //last set of wendler to try amrap
	
	public abstract Barbell barbell();
	
	

}
