package generator.app;

import java.io.IOException;

import generator.app.processed.GenerateProcessedJsons;
import generator.app.unprocessed.GenerateUnprocessedJsons;

public class App {

	private static int outputObjectNum = 500000;
	
	public static void main(String[] args) throws IOException {
		Generate generator = new GenerateUnprocessedJsons();
		generator.generate(outputObjectNum);
	}

}
