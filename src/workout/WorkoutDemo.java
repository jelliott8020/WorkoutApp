package workout;
import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

import barbell.Barbell;
import barbell.Bench;
import barbell.Deadlift;
import barbell.OHP;
import barbell.Squat;
import gymnastics.Gymnastics;
import misc.Abs;
import misc.Misc;
import misc.Neck;
import running.Running;
import running.LISS_Distance;
import running.Sprints;

public class WorkoutDemo {
	
	

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
			
		if (monthName.equals("May") ||
				monthName.equals("June") ||
				monthName.equals("July") ||
				monthName.equals("August")) {
				
				if (dayName.equals("Sunday")) {
					Running liss = new LISS_Distance();
					System.out.println("Running LISS");
				}
				else if (dayName.equals("Monday")) {
					// need to change between OHP and Bench here
					Barbell bench = new Bench();
					Barbell ohp = new OHP();
					System.out.println("Barbell Bench or OHP");
				}
				else if (dayName.equals("Tuesday")) {				
					Misc abs = new Abs();
					Misc neck = new Neck();
					Running sprint = new Sprints();
					System.out.println("Abs, Neck, Sprints");
				}
				else if (dayName.equals("Wednesday")) {
					Running liss = new LISS_Distance();
					System.out.println("Running LISS");
				}
				else if (dayName.equals("Thursday")) {
					Gymnastics gym = new Gymnastics();
					System.out.println("Bodyweight skills");
					System.out.println("Metcon");
				}
				else if (dayName.equals("Friday")) {
					// need to change between Squat and Deadlift here
					Barbell squat = new Squat();
					Barbell dl = new Deadlift();
					System.out.println("Barbell Squat or Deadlift");
				}
				else if (dayName.equals("Saturday")) {
					System.out.println("Today is a rest day.");
				}
				
			}
			else if (monthName.equals("September") ||
					 monthName.equals("October") ||
					 monthName.equals("November") ||
					 monthName.equals("December")) {
				
				System.out.println("Barbell Strength");
				
				if (dayName.equals("Sunday")) {
					Running liss = new LISS_Distance();
					System.out.println("Running LISS");
				}
				else if (dayName.equals("Monday")) {
					Barbell squat = new Squat();
					System.out.println("Barbell Squat");
				}
				else if (dayName.equals("Tuesday")) {
					Barbell squat = new Squat();
					System.out.println("Barbell Squat");
				}
				else if (dayName.equals("Wednesday")) {
					Barbell squat = new Squat();
					System.out.println("Barbell Squat");
				}
				else if (dayName.equals("Thursday")) {
					Barbell squat = new Squat();
					System.out.println("Barbell Squat");
				}
				else if (dayName.equals("Friday")) {
					Barbell squat = new Squat();
					System.out.println("Barbell Squat");
				}
				else if (dayName.equals("Saturday")) {
					Barbell squat = new Squat();
					System.out.println("Barbell Squat");
				}
				
			}
			else if (monthName.equals("January") ||
					 monthName.equals("February")) {
				
				System.out.println("Hypertrophy");
				
				if (dayName.equals("Sunday")) {
					Running liss = new LISS_Distance();
					System.out.println("Running LISS");
				}
				else if (dayName.equals("Monday")) {
					Barbell squat = new Squat();
					System.out.println("Barbell Squat");
				}
				else if (dayName.equals("Tuesday")) {
					Barbell squat = new Squat();
					System.out.println("Barbell Squat");
				}
				else if (dayName.equals("Wednesday")) {
					Barbell squat = new Squat();
					System.out.println("Barbell Squat");
				}
				else if (dayName.equals("Thursday")) {
					Barbell squat = new Squat();
					System.out.println("Barbell Squat");
				}
				else if (dayName.equals("Friday")) {
					Barbell squat = new Squat();
					System.out.println("Barbell Squat");
				}
				else if (dayName.equals("Saturday")) {
					Barbell squat = new Squat();
					System.out.println("Barbell Squat");
				}
				
			}
			else if (monthName.equals("March") ||
				 	 monthName.equals("April")) {
				
				System.out.println("HITT");
				
				if (dayName.equals("Sunday")) {
					Running liss = new LISS_Distance();
					System.out.println("Running LISS");
				}
				else if (dayName.equals("Monday")) {
					Barbell squat = new Squat();
					System.out.println("Barbell Squat");
				}
				else if (dayName.equals("Tuesday")) {
					Barbell squat = new Squat();
					System.out.println("Barbell Squat");
				}
				else if (dayName.equals("Wednesday")) {
					Barbell squat = new Squat();
					System.out.println("Barbell Squat");
				}
				else if (dayName.equals("Thursday")) {
					Barbell squat = new Squat();
					System.out.println("Barbell Squat");
				}
				else if (dayName.equals("Friday")) {
					Barbell squat = new Squat();
					System.out.println("Barbell Squat");
				}
				else if (dayName.equals("Saturday")) {
					Barbell squat = new Squat();
					System.out.println("Barbell Squat");
				}
				
			}
	}	
}
