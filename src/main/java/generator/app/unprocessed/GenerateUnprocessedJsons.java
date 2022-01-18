package generator.app.unprocessed;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import generator.app.DataGenerator;
import generator.app.Generate;

public class GenerateUnprocessedJsons implements Generate {

	private String filename;
	
	public void generate(int amount) throws IOException {
		DataGenerator dg = new DataGenerator();
		filename = dg.genPath() + ".json";
		
		UnprocessedJson[] ujarray = new UnprocessedJson[amount];
		
		for(int i = 0; i < amount; i++) {
			UnprocessedJson uj = new UnprocessedJson(
					dg.genWebsite(), 
					dg.genPath(), 
					dg.genInt());
			ujarray[i] = uj;
		}
		
		write(ujarray);
	}
	private void write(UnprocessedJson[] data) throws IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Writer writer = new FileWriter(filename, true);
		
		gson.toJson(data, writer);
		writer.close();
	}
	

}
