package workout;

import java.io.FileReader;
import java.util.Iterator;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import barbell.Barbell;
import metcons.MetCon;
import olympics.Olympics;


public class Parser {
	
	public Parser(Barbell bb) {
		
	}
	

	public JSONArray getArray(String in) {

		JSONArray amrapPRs = null;

		if (in.equals("bench")) {
			try {
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(new FileReader("C:\\Users\\Josh\\Desktop\\WorkoutApp\\BenchPRs.txt"));
				JSONObject jsonObject = (JSONObject) obj;
				amrapPRs = (JSONArray) jsonObject.get("AMRAPs");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (in.equals("squat")) {
			try {
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(new FileReader("C:\\Users\\Josh\\Desktop\\WorkoutApp\\SquatPRs.txt"));
				JSONObject jsonObject = (JSONObject) obj;
				amrapPRs = (JSONArray) jsonObject.get("AMRAPs");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (in.equals("deadlift")) {
			try {
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(new FileReader("C:\\Users\\Josh\\Desktop\\WorkoutApp\\DeadliftPRs.txt"));
				JSONObject jsonObject = (JSONObject) obj;
				amrapPRs = (JSONArray) jsonObject.get("AMRAPs");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (in.equals("ohp")) {
			try {
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(new FileReader("C:\\Users\\Josh\\Desktop\\WorkoutApp\\OHPPRs.txt"));
				JSONObject jsonObject = (JSONObject) obj;
				amrapPRs = (JSONArray) jsonObject.get("AMRAPs");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

		return amrapPRs;
	}

	@SuppressWarnings("unchecked")
	public void readBenchPR() {
		JSONArray amrapPRs = getArray("bench");
		Iterator<PR> iterator = amrapPRs.iterator();

		System.out.println("Bench PRs:\n");

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			iterator.next().toString();
		}
	}

	@SuppressWarnings("unchecked")
	public void readSquatPR() {
		JSONArray amrapPRs = getArray("squat");
		Iterator<PR> iterator = amrapPRs.iterator();

		System.out.println("Squat PRs:\n");

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			iterator.next().toString();
		}
	}

	@SuppressWarnings("unchecked")
	public void readDLPR() {
		JSONArray amrapPRs = getArray("deadlift");
		Iterator<PR> iterator = amrapPRs.iterator();

		System.out.println("Deadlift PRs:\n");

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			iterator.next().toString();
		}
	}

	@SuppressWarnings("unchecked")
	public void readOHPPR() {
		JSONArray amrapPRs = getArray("ohp");
		Iterator<PR> iterator = amrapPRs.iterator();

		System.out.println("OHP PRs:\n");

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			iterator.next().toString();
		}
	}

	@SuppressWarnings("unchecked")
	public void addBenchPR(PR input) {
		
		JSONArray amrapPRs = getArray("bench");

		amrapPRs.add(input);
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("C:\\Users\\Josh\\Desktop\\WorkoutApp\\BenchPRs.txt"));
		JSONObject jsonObject = (JSONObject) obj;
		amrapPRs = (JSONArray) jsonObject.get("AMRAPs");


	}

}


