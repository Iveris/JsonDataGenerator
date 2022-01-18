package generator.app;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import generator.app.processed.ProcessedJson;
import generator.app.unprocessed.UnprocessedJson;

public class GenerateBoth implements Generate{

	private Map<String, ProcessedJson> mapData = new HashMap<>();
	private UnprocessedJson[] ujArray;
	private String upFilename; //unprocessed data json
	private String pFilename; //processed data json
	private Gson gson = new GsonBuilder().create();
	
	@Override
	public void generate(int amount) throws IOException {
		DataGenerator dg = new DataGenerator();
		ujArray = new UnprocessedJson[amount];
		String filename = dg.genPath() + ".json";
		upFilename = "up" + filename;
		pFilename = "p" + filename;
		
		for(int i = 0; i < amount; i++) {
			String path = dg.genPath();
			String url = dg.genWebsite();
			Integer size = dg.genInt();
			
			ujArray[i] = new UnprocessedJson(url, path, size);
			ProcessedJson pj = new ProcessedJson(url, size);
			mapData.put(path, pj);
		}
		write(ujArray, upFilename);
		write(mapData, pFilename);
	}

	private void write(UnprocessedJson[] uj, String filename) throws IOException {
		Writer writer = new FileWriter(filename, true);
		gson.toJson(uj, writer);
		writer.close();
	}
	
	private void write(Map<String, ProcessedJson> data, String filename) throws IOException {
		Writer writer = new FileWriter(filename, true);
		gson.toJson(data, writer);
		writer.close();
	}
	
}
