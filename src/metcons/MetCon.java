package metcons;


/**
 * 
 * @author Josh
 * @version 7/26/18
 * 
 * Class will store a database of different metcons. There will be
 * bodypart focused metcons (legs, upperbody, fullbody). When called,
 * it will check what day of the week it is, what barbell workout was 
 * done the previous day and what we will be done tomorrow, and
 * produce a random metcon from the constraints.
 * 
 * Need to store past PRs somewhere, will it be in this class? That
 * way when user pulls up the metcon, they will see past PRs and what
 * to strive to beat.
 * 
 * Give user option to add metcons to the database
 * 
 */

public abstract class MetCon {

	boolean amrap;
	boolean rft;
	
	public abstract MetCon metcon();
}
