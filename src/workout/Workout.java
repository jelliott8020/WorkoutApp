package workout;

import barbell.Barbell;
import endurance.Endurance;
import metcons.MetCon;

/**
 * 
 * @author Josh
 * @version 7/26/18
 * 
 * Will need to ask user what their PRs for barbell lifts are.
 * Need to use Wendler's calculator to determine 1rms. 
 *
 */
public class Workout {

	MetCon metCon;
	Barbell barbell;
	Endurance running;
	
	public Workout() {
		
	}
	
	public Workout(MetCon mc, Barbell bb, Endurance run) {
		this.metCon = mc;
		this.barbell = bb;
		this.running = run;
	}
	
	public MetCon getMetCon() {
		return metCon;
	}
	
	public Barbell getBarbell() {
		return barbell;
	}
	
	public Endurance getRunning() {
		return running;
	}
	
	public void setMetCon(MetCon mc) {
		this.metCon = mc;
	}
	
	public void setBarbell(Barbell bb) {
		this.barbell = bb;
	}
	
	public void setRunning(Endurance run) {
		this.running = run;
	}
	
	
}
