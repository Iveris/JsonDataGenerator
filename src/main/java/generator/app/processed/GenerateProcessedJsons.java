package generator.app.processed;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import generator.app.DataGenerator;
import generator.app.Generate;

public class GenerateProcessedJsons implements Generate {
	
	private String filename;
	
	public void generate(int amount) throws IOException {
		DataGenerator dg = new DataGenerator();
		filename = dg.genPath() + ".json";
		Map<String, ProcessedJson> hashMap = new HashMap<>();
		
		
		for(int i = 0; i < amount; i++) {
			ProcessedJson pj = new ProcessedJson(dg.genWebsite(), 
					dg.genInt());
			
			hashMap.put(dg.genPath(), pj);
		}
		write(hashMap);
	}
	
	private void write(Map<String, ProcessedJson> data) throws IOException {
		Gson gson = new GsonBuilder().create();
		Writer writer = new FileWriter(filename, true);
		
		gson.toJson(data, writer);
		writer.close();
	}
}
