package workout;
import java.awt.Frame;
import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import barbell.*;
import endurance.*;
import gymnastics.*;
import metcons.*;
import misc.*;
import hypertrophy.*;
import olympics.*;


/**
 * - Demo for workout program.
 * 
 * - Program is based off a yearly cycle.
 * - Oct, Nov, Dec, Jan: (Goal: Strength) 4x/week barbell strength. 2x/week LISS Cardio.
 * - Feb, Mar: (Goal: Mass) 6x/week Hypertrophy. PPLR PPLR.
 * - Apr, May: (Goal: Fat Loss) 2x/week Barbell Fullbody. 2x/week Running buildup. 4x/week HITT.
 * - Jun, Jul, Aug, Sep: (Goal: Running) 2x/week barbell upper/lower. 3+/week running.
 * 
 * - Demo will produce different workouts depending on the month of the year
 *   and the day of the week
 *   
 * - For Wendler 531, it will ask the user if they have retested their
 *   maxes. It stores this informtion in JSON files and uses it to
 *   calculate daily workouts.
 *   
 * - It will display the workout for the day using information stored
 *   in JSON files: %s for Wendler, and randomly pulled metcons.
 * 
 * @author Josh
 * @version 8/18/18
 * 
 */

public class WorkoutDemo {

	Frames frame;
	/**
	 * Each object gets its own JSON file
	 * 
	 * @param args
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		/*
		 * 1. Ask if maxes were retested (This will be a button in Frame later)
		 * 2. If yes, ask for efforts. (weight, reps), calculate best effort. Store in JSON array.
		 * 3. If no, display workout of the day depending on month of year and day of week.
		 * 4. Ask, did you do this workout?
		 * 5. If yes, ask for AMRAP set reps. Store in JSON. Display past X (maybe 5) amraps from
		 * 		JSON to compare. Maybe all of the past AMRAPS, or 10, in descending order with dates.
		 * 6. If no, display a motivating message.
		 * 7. Ask, did you do the metcon (if there was one).
		 * 8. If yes, ask for metcon time/reps. Store in JSON. Display past performances with dates.
		 * 9. If no, display a motivating message.
		 */
		
		WorkoutDemo demo = new WorkoutDemo();
		Scanner sc = new Scanner(System.in);
		LocalDate date = LocalDate.now();
		DayOfWeek dow = date.getDayOfWeek();
		Month month = date.getMonth();
		int ans;
		String dayName = dow.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		String monthName = month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);

		System.out.println("Today is: " + dayName + ", " + monthName 
						   + " " + date.getDayOfMonth() +  ", " + date.getYear());
		
		System.out.println(dow);
		System.out.println(month);
		System.out.println(date);
		
		System.out.println();
		
		demo.currentCycle(monthName);
		
		System.out.println();

		do {
			System.out.println("What would you like to do?");
			System.out.println("1: Get your daily workout.");
			System.out.println("2: Enter daily workout results.");
			System.out.println("3: Enter new tested maxes.");
			ans = sc.nextInt();

			if (ans == 1) {
				demo.workout(dayName, monthName);
			}
			else if (ans == 2){
				
			}
			else if (ans == 3) {
				demo.newMaxes();
				//ask for input for new maxes, add to JSON
				//how to return to this loop after getting maxes????
			}
			else {
				System.out.println("Invalid selection.");
			}
		} while (ans > 2);
	
		sc.close();
	}
	
	public void printDate(LocalDate date) {
		
	}
	
	public void currentCycle(String monthName) throws FileNotFoundException, IOException, ParseException {
		if (     monthName.equals("May") ||
			     monthName.equals("June") ||
			     monthName.equals("July") ||
			     monthName.equals("August")) { System.out.println("You are currently on the running cycle.");}
		else if (monthName.equals("September") ||
				 monthName.equals("October") ||
				 monthName.equals("November") ||
				 monthName.equals("December")) { System.out.println("You are currently on the strength cycle.");}
		else if (monthName.equals("January") ||
				 monthName.equals("February")) { System.out.println("You are currently on the hypertrophy cycle.");}
		else if (monthName.equals("March") ||
				 monthName.equals("April")) { System.out.println("You are currently on the fat loss cycle."); }
		
		System.out.println("Your current cycle begain on: "); 
		
		Barbell bn = new Bench();
		Parser par = new Parser(bn);
		System.out.println(par.getCycleStart());
		
		System.out.println("Your current training maxes are: "); //look up maxes
		System.out.println("|| Bench: ");
		System.out.println("|| Squat: ");
		System.out.println("|| OHP: ");
		System.out.println("|| Deadlift: ");
	}

	public double[] newMaxes() {

		double[] ans =  new double[4];
		
		System.out.println("\nYour last tested maxes were: ");
		System.out.println("|| Bench: \n" + "|| Squat: \n" + "|| OHP: \n" + "|| Deadlift: \n");
		System.out.println("Your current training maxes are: ");
		System.out.println("|| Bench: \n" + "|| Squat: \n" + "|| OHP: \n" + "|| Deadlift: \n");

		System.out.println("Give us the weight and the reps, and we'll calculate the max.");
		System.out.println("If you want to stop, answer 'n' and we'll move to the next exercise.");
		System.out.println("Once you decide to stop, we will compare all"
				+ " results entered and determine your best effort.");
		

		System.out.println("What was your Bench effort?");
		ans[0] = calculate();
		System.out.println(ans[0]);

		System.out.println("What was your Squat effort?");
		ans[1] = calculate();

		System.out.println("What was your OHP effort?");
		ans[2] = calculate();

		System.out.println("What was your Deadlift effort?");
		ans[3] = calculate();

		return ans;
	}

	public double calculate() {

		double weight = 0.0;
		double result = 0.0;
		double result2 = 0.0;
		int reps = 0;

		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Weight: ");
			weight = sc.nextDouble();
			System.out.println("Reps: ");
			reps = sc.nextInt();
			sc.nextLine();
			result = weight * reps * .0333 + weight;

			if (result2 >= result) {
				System.out.println(5*(Math.round(result/5)));
				System.out.println("That wasn't better than " + 5*(Math.round(result2/5)));
				System.out.println("Sticking with previous max");
			}
			else if (result >= result2) result2 = result;

			System.out.println("Current max: " + 5*(Math.round(result2/5)));

			System.out.println("Continue? y or n");
		} while (!sc.nextLine().equals("n") || !sc.nextLine().equals("N"));
		
		System.out.println("Your best effort was: " + result2);

		sc.close();
		return result2;	
	}

	public void workout(String dayName, String monthName) {

		/*
		 * Running
		 * LISS = 2x days/week
		 * Sprints = 2x days/week
		 * Metcons = 3x days/week
		 * Barbell Strength = 2x days/week, 1 day upper, 1 day lower
		 * 
		 * 
		 */
		if (monthName.equals("May") ||
				monthName.equals("June") ||
				monthName.equals("July") ||
				monthName.equals("August")) {

			if (dayName.equals("Sunday")) {
				Endurance liss = new LISS_Distance();			
			}
			else if (dayName.equals("Monday")) {
				Olympics sn = new Snatch();
				// need to change between OHP and Bench here
				Barbell bench = new Bench();
				Barbell ohp = new OHP();
				MetCon upper = new Fullbody_MC();

				Workout work = new Workout(sn, bench, upper);

				frame = new Frames(work);
			}
			else if (dayName.equals("Tuesday")) {				
				Misc abs = new Abs();
				Misc neck = new Neck();
				Endurance sprint = new Sprints();
			}
			else if (dayName.equals("Wednesday")) {
				Endurance liss = new LISS_Speed();
			}
			else if (dayName.equals("Thursday")) {
				Gymnastics gym = new Gymnastics();
				MetCon fb = new Fullbody_MC();
			}
			else if (dayName.equals("Friday")) {
				Olympics cl = new Clean();
				// need to change between Squat and Deadlift here
				Barbell squat = new Squat();
				Barbell dl = new Deadlift();
				MetCon lower = new Lower_MC();
			}
			else if (dayName.equals("Saturday")) {
				System.out.println("Today is a rest day.");
				System.out.println("Go for an easy walk.");
			}

		}
		/*
		 * Strength Training
		 * 4x days/week = 531
		 * Upper/Lower, Upper/Lower
		 * LISS = 2x days/week
		 * Sept, Oct, Nov, Dec
		 */
		else if (monthName.equals("September") ||
				monthName.equals("October") ||
				monthName.equals("November") ||
				monthName.equals("December")) {

			System.out.println("Barbell Strength");

			if (dayName.equals("Sunday")) {
				Barbell bench = new Bench();
			}
			else if (dayName.equals("Monday")) {
				Olympics cl = new Clean();
				Barbell squat = new Squat();
			}
			else if (dayName.equals("Tuesday")) {
				Endurance easy = new Low_Impact();
			}
			else if (dayName.equals("Wednesday")) {
				Barbell ohp = new OHP();
			}
			else if (dayName.equals("Thursday")) {
				Olympics sn = new Snatch();
				Barbell dl = new Deadlift();
			}
			else if (dayName.equals("Friday")) {
				Endurance easy = new Low_Impact();
			}
			else if (dayName.equals("Saturday")) {
				System.out.println("Today is a rest day.");
				System.out.println("Go for an easy walk.");
			}

		}
		/*
		 * Hypertrophy
		 * PPLPPLR
		 * Push1 Bench, Push2 OHP
		 * Pull1 Row, Pull2 Pullups
		 * Legs1 Squat, Legs2 Deadlift
		 * Metcons 2x day/week after legs
		 * Incorporate running into every metcon
		 */
		else if (monthName.equals("January") ||
				monthName.equals("February")) {

			System.out.println("Hypertrophy");

			if (dayName.equals("Sunday")) {
				Hyper pull1 = new Pull1();
			}
			else if (dayName.equals("Monday")) {
				Hyper push1 = new Push1();
			}
			else if (dayName.equals("Tuesday")) {
				Hyper legs1 = new Legs1();
				MetCon mc = new Lower_MC();
			}
			else if (dayName.equals("Wednesday")) {
				Hyper pull2 = new Pull2();
			}
			else if (dayName.equals("Thursday")) {
				Hyper push2 = new Push2();
			}
			else if (dayName.equals("Friday")) {
				Hyper legs2 = new Legs2();
				MetCon mc = new Lower_MC();
			}
			else if (dayName.equals("Saturday")) {
				System.out.println("Today is a rest day.");
				System.out.println("Go for an easy walk.");
			}

		}

		/*
		 * HITT/Running Buildup
		 * Barbell = 2x day/week full body
		 * Running = 2x day/week buildup
		 * MetCons = 4x day/week
		 */
		else if (monthName.equals("March") ||
				monthName.equals("April")) {

			System.out.println("HITT");

			if (dayName.equals("Sunday")) {
				//Barbell fb1 = new FullBodyBB1();
			}
			else if (dayName.equals("Monday")) {
				MetCon low = new Lower_MC();
				Endurance spr = new Sprints();
			}
			else if (dayName.equals("Tuesday")) {
				MetCon fb = new Fullbody_MC();
				Endurance liss = new LISS_Distance();
			}
			else if (dayName.equals("Wednesday")) {
				//Barbell fb2 = new FullBodyBB2();
			}
			else if (dayName.equals("Thursday")) {
				MetCon low = new Lower_MC();
				Endurance spr = new Sprints();
			}
			else if (dayName.equals("Friday")) {
				MetCon fb = new Fullbody_MC();
				Endurance liss = new LISS_Distance();
			}
			else if (dayName.equals("Saturday")) {
				System.out.println("Today is a rest day.");
				System.out.println("Go for an easy walk.");
			}

		}
	}	
}
