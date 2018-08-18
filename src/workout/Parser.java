package workout;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import barbell.Barbell;
import metcons.MetCon;
import olympics.Olympics;


public class Parser {
	
	JSONArray amrapPRs;
	JSONParser parser;
	Object obj;
	JSONObject jsonObject;
	Barbell bb;
	
	public Parser(Barbell bb) {
		this.bb = bb;
	}
	
	public JSONArray getArray(String in) {

		if (in.equals("bench")) {
			try {
				//JSONParser parser = new JSONParser();
				obj = parser.parse(new FileReader("C:\\Users\\Josh\\Desktop\\WorkoutApp\\Bench.txt"));
				jsonObject = (JSONObject) obj;
				amrapPRs = (JSONArray) jsonObject.get("AMRAPs");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (in.equals("squat")) {
			try {
				//JSONParser parser = new JSONParser();
				obj = parser.parse(new FileReader("C:\\Users\\Josh\\Desktop\\WorkoutApp\\Squat.txt"));
				jsonObject = (JSONObject) obj;
				amrapPRs = (JSONArray) jsonObject.get("AMRAPs");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (in.equals("deadlift")) {
			try {
				//JSONParser parser = new JSONParser();
				obj = parser.parse(new FileReader("C:\\Users\\Josh\\Desktop\\WorkoutApp\\Deadlift.txt"));
				jsonObject = (JSONObject) obj;
				amrapPRs = (JSONArray) jsonObject.get("AMRAPs");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (in.equals("ohp")) {
			try {
				//JSONParser parser = new JSONParser();
				obj = parser.parse(new FileReader("C:\\Users\\Josh\\Desktop\\WorkoutApp\\OHP.txt"));
				jsonObject = (JSONObject) obj;
				amrapPRs = (JSONArray) jsonObject.get("AMRAPs");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

		return amrapPRs;
	}
	
	public LocalDate getCycleStart() throws FileNotFoundException, IOException, ParseException {
		obj = parser.parse(new FileReader("C:\\Users\\Josh\\Desktop\\WorkoutApp\\Bench.txt"));
		jsonObject = (JSONObject) obj;
		LocalDate date = (LocalDate) jsonObject.get("Cycle Start Date");
		return date;
	}

	@SuppressWarnings("unchecked")
	public void readBenchPR() {
		amrapPRs = getArray("bench");
		Iterator<Barbell> iterator = amrapPRs.iterator();

		System.out.println("Bench PRs:\n");

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			iterator.next().toString();
		}
	}

	@SuppressWarnings("unchecked")
	public void readSquatPR() {
		amrapPRs = getArray("squat");
		Iterator<Barbell> iterator = amrapPRs.iterator();

		System.out.println("Squat PRs:\n");

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			iterator.next().toString();
		}
	}

	@SuppressWarnings("unchecked")
	public void readDLPR() {
		amrapPRs = getArray("deadlift");
		Iterator<Barbell> iterator = amrapPRs.iterator();

		System.out.println("Deadlift PRs:\n");

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			iterator.next().toString();
		}
	}

	@SuppressWarnings("unchecked")
	public void readOHPPR() {
		amrapPRs = getArray("ohp");
		Iterator<Barbell> iterator = amrapPRs.iterator();

		System.out.println("OHP PRs:\n");

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			iterator.next().toString();
		}
	}

	@SuppressWarnings("unchecked")
	public void addBenchPR(Barbell input) {
		
		amrapPRs = getArray("bench");
		amrapPRs.add(input);
		
		try {
			parser = new JSONParser();
			obj = parser.parse(new FileReader("C:\\Users\\Josh\\Desktop\\WorkoutApp\\BenchPRs.txt"));
			jsonObject = (JSONObject) obj;
			amrapPRs = (JSONArray) jsonObject.get("AMRAPs");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		


	}

}


