package workout;
import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

import barbell.*;
import endurance.*;
import gymnastics.*;
import metcons.*;
import misc.*;
import hypertrophy.*;
import olympics.*;

public class WorkoutDemo {


	/**
	 * Each object gets its own JSON file
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * ask for date, day
		 * use day of week - "was your workout x type?"
		 * if yes, populate questions
		 * if no, ask what type (drop down)
		 * 
		 * which metcon did you do?
		 * time? reps?
		 * 
		 * after done looping, print sheet with results
		 * and save results in database
		 */

		LocalDate date = LocalDate.now();
		DayOfWeek dow = date.getDayOfWeek();
		Month month = date.getMonth();

		String dayName = dow.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		String monthName = month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);

		System.out.println("Today is: " + dayName);
		System.out.println("The month is: " + monthName);

		System.out.println("The workouts for today is: ");

		WorkoutDemo demo = new WorkoutDemo();

		demo.workout(dayName, monthName);	
		
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
				System.out.println("LISS Distance");				
			}
			else if (dayName.equals("Monday")) {
				Olympics sn = new Snatch();
				// need to change between OHP and Bench here
				Barbell bench = new Bench();
				Barbell ohp = new OHP();
				System.out.println("Barbell Bench or OHP");
				MetCon upper = new Fullbody_MC();
				System.out.println("Upperbody Metcon");
			}
			else if (dayName.equals("Tuesday")) {				
				Misc abs = new Abs();
				Misc neck = new Neck();
				Endurance sprint = new Sprints();
				System.out.println("Abs, Neck, Sprints");
			}
			else if (dayName.equals("Wednesday")) {
				Endurance liss = new LISS_Speed();
				System.out.println("LISS Speed");
			}
			else if (dayName.equals("Thursday")) {
				Gymnastics gym = new Gymnastics();
				System.out.println("Bodyweight skills");
				MetCon fb = new Fullbody_MC();
				System.out.println("Metcon");
			}
			else if (dayName.equals("Friday")) {
				Olympics cl = new Clean();
				// need to change between Squat and Deadlift here
				Barbell squat = new Squat();
				Barbell dl = new Deadlift();
				System.out.println("Barbell Squat or Deadlift");
				MetCon lower = new Lower_MC();
				System.out.println("Lowerbody Metcon");
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
				Barbell fb1 = new FullBodyBB1();
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
				Barbell fb2 = new FullBodyBB2();
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
