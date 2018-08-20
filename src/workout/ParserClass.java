package workout;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
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


public class ParserClass {
	
	JSONArray amrapPRs;
	JSONParser parser;
	Object obj;
	JSONObject jsonObject;
	Barbell bb;
	
	public ParserClass(Barbell bb) {
		this.bb = bb;
	}
	
	public ParserClass() {
		amrapPRs = new JSONArray();
		parser = new JSONParser();
		jsonObject = new JSONObject();
		obj = new Object();
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		ParserClass par = new ParserClass();
		par.getCycleStart();
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
	
	public void getCycleStart() throws FileNotFoundException, IOException, ParseException {
				
		try {
			obj = parser.parse(new FileReader("D:\\WorkoutApp\\test.json"));
			jsonObject = (JSONObject) obj;
			String name = (String) jsonObject.get("name");
			System.out.println(name);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		/*
		JSONParser par = new JSONParser();
		
		try {
			Object ob2 = par.parse(new FileReader("D:\\WorkoutApp\\test.json"));
			JSONObject ob3 = (JSONObject) ob2;
			String name = (String) ob3.get("name");
			System.out.println(name);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		*/
	}
	
	
	
	public void writeTest() {
		JSONObject ob = new JSONObject();
		ob.put("name", "josh");
		ob.put("age", new Integer(100));
		
		JSONArray list = new JSONArray();
		list.add("msg 1");
		list.add("Test2");
		
		ob.put("Tests", list);
		
		try (FileWriter file = new FileWriter("C:\\Users\\Josh\\Desktop\\WorkoutApp\\test.json")) {
			file.write(ob.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(obj);
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


