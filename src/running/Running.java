package running;


/**
 * 
 * @author Josh
 * @version 7/26/18
 * 
 * Class will store different types of running workouts. Some
 * examples are trying to increase distance but going slower,
 * reducing max distance slightly, but trying to go faster,
 * and different sprint/tempo type workouts.
 * 
 * Need to store PRs somewhere. Need to learn database use. 
 * Also need to learn how to export data to excel (graphs).
 *
 */

public abstract class Running {

	double distance;
	int intervals;
	double speed;
	boolean hills;
	
	public abstract Running running();
	
}
