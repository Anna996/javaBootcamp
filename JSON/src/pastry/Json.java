package pastry;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import pastry.Pastry.Label;

import com.google.gson.reflect.TypeToken;

public class Json {

	public static String PASTRY_FILE_NAME = "myFiles/pastry.json";
	public static String PASTRY_LIST_FILE_NAME = "myFiles/pastry_list.json";
	public static String PASTRY_MAP_FILE_NAME = "myFiles/pastry_map.json";
	
	private static void saveJsonToFile(String formattedStr ,String filename) {
		File file = new File(filename);
		try (FileWriter writer = new FileWriter(file);) {
			writer.write(formattedStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// One Object
	public static void saveToJson(Pastry pastry) {
		Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
		String pastryJson = gson.toJson(pastry);
		saveJsonToFile(pastryJson, PASTRY_FILE_NAME);
	}

	// One Object
	public static Pastry parseToPastry() {
		File file = new File(PASTRY_FILE_NAME);
		try (FileReader reader = new FileReader(file);) {

			JsonReader jsonReader = new JsonReader(reader);
			Gson gson = new Gson();
			Pastry pastry = gson.fromJson(jsonReader, Pastry.class);
			return pastry;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	// List of Objects
	public static void saveToJson(List<Pastry> pastryList) {
		Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
		String pastryListJson = gson.toJson(pastryList);
		saveJsonToFile(pastryListJson, PASTRY_LIST_FILE_NAME);
	}

	// List of Objects
	public static List<Pastry> parseToPastryList() {
		File file = new File(PASTRY_LIST_FILE_NAME);
		try (FileReader reader = new FileReader(file);) {

			JsonReader jsonReader = new JsonReader(reader);
			Gson gson = new Gson();

			Type listType = new TypeToken<ArrayList<Pastry>>() {}.getType();
			List<Pastry> pastryList = gson.fromJson(jsonReader, listType);

			return pastryList;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	// Map of Objects
	public static void saveToJson(Map<Label, List<Pastry>> pastryMap) {
		Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
		String pastryMapJson = gson.toJson(pastryMap);
		saveJsonToFile(pastryMapJson,PASTRY_MAP_FILE_NAME);
	}
	
	// Map of Objects
		public static Map<Label, List<Pastry>> parseToPastryMap() {
			File file = new File(PASTRY_MAP_FILE_NAME);
			try (FileReader reader = new FileReader(file);) {

				JsonReader jsonReader = new JsonReader(reader);
				Gson gson = new Gson();

				Type mapType = new TypeToken<HashMap<Label, List<Pastry>>>() {}.getType();
				Map<Label, List<Pastry>> pastryMap = gson.fromJson(jsonReader, mapType);

				return pastryMap;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
}
